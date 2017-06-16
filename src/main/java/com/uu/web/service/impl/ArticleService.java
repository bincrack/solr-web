package com.uu.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.uu.web.entity.Article;
import com.uu.web.service.IArticleService;

@Component
public class ArticleService implements IArticleService
{
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	@Resource
	private SolrClient solrClient;
	
	private String[] content = new String[] {
			"从2015年11月召开的中央财经领导小组第十一次会议首次提出“着力加强供给侧结构性改革”，到今年1月中共中央政治局就深入推进供给侧结构性改革进行第三十八次集体学习，一年多来，习近平总书记多次深入阐述供给侧结构性改革的现实依据、深刻内涵、根本目的和工作要求。",
			"最新经济数据表明，在供给侧结构性改革持续发力之下，我国产业结构不断优化，在减少无效供给的同时扩大了中高端供给，带动产业结构优化调整；服务和产品的供给质量稳步提升，共享经济、分享经济、智能家居等新业态都在快速发展；补短板亮点突出，生态环境保护投资、公共设施管理投资等都保持了比较快的增长。",
			"“结构性问题，供给和需求两侧都有，但矛盾的主要方面在供给侧。供给侧结构性改革是一场关系全局、关系长远的攻坚战。”习近平总书记指出了问题的关键所在。",
			"经过30多年的高速发展，我国经济取得了举世瞩目的成就，但也积累了一些结构性问题，经济面临着实体经济结构性的供给失衡、金融和实体经济的失衡、房地产和实体经济的失衡等问题。如何实现经济发展“动能切换”，实现“升级换档”，跨过“中等收入陷阱”，成了摆在中国经济面前的一道难题。",
			"习近平总书记指出，推进供给侧结构性改革，要处理好“减法”和“加法”之间的关系。这为深入推进供给侧结构性改革提供了正确方法论。“文武之道，一张一弛”。在坚持稳中求进工作总基调的大背景下，中国经济增长内生动力持续释放，在“减”和“加”之间，向历史和人民交出了靓丽答卷。",
			"换言之，推进供给侧结构性改革，就要“减法”和“加法”一起做。一方面，要淘汰落后和过剩产能，为新兴产业发展腾出更多资源，下好产业结构优化升级的“先手棋”；另一方面，要加快改造传统产业，做强做大优势产业、培育壮大新兴产业。",
			"供给侧结构性改革的“减法”与“加法”，不是一个简单的数学公式，而是一道时代命题。坚定不移把供给侧结构性改革向前推进，着力培育新动能，激发经济社会发展活力，中国经济的转型升级将获得强劲动力，不断前进的中国经济也将为世界经济复苏创造更多机遇。",
			"如何打赢推进供给侧结构性改革这场硬仗？习近平总书记指明了清晰的路径：要把握好“加法”和“减法”，增加要素投入，促进经济总量增加，减少无效和低端供给，扩大有效和中高端供给，提高全要素生产率。",
			"新常态下，发展需要新理念、新智慧、新方法。要解决国民经济发展中的一些问题，必须以供给侧结构性改革为主攻方向，这是我国经济发展进入新常态的必然选择。",
			"6月14日，国家统计局公布了我国前5月经济运行情况。各项数据表明，供给侧结构性改革持续发力，国民经济发展的协调性和稳定性不断增强。总体平稳、稳中有进、稳中向好，中国经济传递出增速趋稳、质量趋优的信号。",
	};

	@Override
	public void add(Article bean)
	{
		bean = new Article();
		bean.setTitle("供给侧改革的“加减法”怎么做？习近平给出答案");

		try
		{
			for (String s : content)
			{
				bean.setContent(s);

				UpdateResponse res = solrClient.addBean(bean);

				logger.info(String.format("UpdateResponse: %s", res));
			}

			solrClient.commit();
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
	}

	@Override
	public List<Article> list()
	{
		SolrQuery query = new SolrQuery();
		query.setQuery("*");
		query.setStart(0);
		query.setRows(100);

		try
		{
			QueryResponse res = solrClient.query(query);
			if (res != null)
			{
				return res.getBeans(Article.class);
			}
		}
		catch (Exception e)
		{
			logger.error("", e);
		}

		return null;
	}

	@Override
	public void del()
	{
		try
		{
			UpdateResponse res = solrClient.deleteByQuery("*:*");
			
			logger.info(String.format("UpdateResponse: %s", res));
			
			solrClient.commit();
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
	}
}

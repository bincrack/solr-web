package com.uu.web.entity;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class Article implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Field("title_s")
	private String title;		// 标题
	@Field("content_s")
	private String content;		// 内容
	@Field("createDate_s")
	private String createDate;	// 创建日期
	@Field("createTime_s")
	private String createTime;	// 创建时间
	@Field("pushDate_s")
	private String pushDate;	// 发布日期
	@Field("pushTime_s")
	private String pushTime;	// 发布时间

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	public String getPushDate()
	{
		return pushDate;
	}

	public void setPushDate(String pushDate)
	{
		this.pushDate = pushDate;
	}

	public String getPushTime()
	{
		return pushTime;
	}

	public void setPushTime(String pushTime)
	{
		this.pushTime = pushTime;
	}

}

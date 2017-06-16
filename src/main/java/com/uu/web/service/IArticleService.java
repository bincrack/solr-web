package com.uu.web.service;

import java.util.List;

import com.uu.web.entity.Article;

public interface IArticleService
{
	public void add(Article bean);

	public List<Article> list();

	public void del();
}

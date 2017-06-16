package com.uu.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uu.web.entity.Article;
import com.uu.web.service.IArticleService;

@Controller
@RequestMapping("/index")
public class IndexController
{
	@Resource
	private IArticleService articleService;

	@RequestMapping("/")
	@ResponseBody
	public List<Article> index(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		return articleService.list();
	}

	@RequestMapping("/add")
	@ResponseBody
	public void add(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		articleService.add(null);
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<Article> list(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		return articleService.list();
	}

	@RequestMapping("/del")
	@ResponseBody
	public void del(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		articleService.del();
	}
}

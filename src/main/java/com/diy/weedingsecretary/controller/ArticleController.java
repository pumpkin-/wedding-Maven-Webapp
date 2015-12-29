package com.diy.weedingsecretary.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diy.weedingsecretary.domain.MicroClassArticle;
import com.diy.weedingsecretary.service.ArticleService;
import com.mysql.jdbc.StringUtils;

@RequestMapping("/article/operation")
@Controller
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@RequestMapping(value = "/uploadArticle.action", method = RequestMethod.POST)
	public String uploadArticle(HttpServletRequest request, HttpServletResponse response,
			MicroClassArticle microClassArticle, Model model) {

		String content = request.getParameter("content");
		// String id = request.getParameter("id");
		// System.out.println(id);
		MicroClassArticle data = articleService.get(microClassArticle.getId());
		int flag = 0;
		if (data == null) {
			flag = articleService.insert(microClassArticle);
		} else {
			flag = articleService.update(microClassArticle);
		}
		if (flag > 0) {
			model.addAttribute("html", "保存成功");
		} else {
			model.addAttribute("html", "保存失败");
		}
		return "/articleDetails.jsp";
	}

	@RequestMapping(value = "/articleDetail.action", method = RequestMethod.GET)
	public String articleDetail(HttpServletRequest request, HttpServletResponse response, Model model) {

		String id = request.getHeader("id");
		MicroClassArticle microClassArticle = articleService.get(id);
		if (microClassArticle != null && 
				!StringUtils.isEmptyOrWhitespaceOnly(microClassArticle.getContent())) {
			model.addAttribute("html", microClassArticle.getContent());
		} else {
			model.addAttribute("html", "该文章正在开发中...");
		}
		return "/articleDetails.jsp";
	}

}

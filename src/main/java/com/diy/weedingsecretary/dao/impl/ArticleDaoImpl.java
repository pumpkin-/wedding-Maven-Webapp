package com.diy.weedingsecretary.dao.impl;

import org.springframework.stereotype.Repository;

import com.diy.weedingsecretary.dao.ArticleDao;
import com.diy.weedingsecretary.domain.MicroClassArticle;

@Repository
public class ArticleDaoImpl extends BaseDaoImpl<MicroClassArticle> implements ArticleDao {

	public ArticleDaoImpl() {
		this.setNs("com.diy.weeding.mapper.ArticleMapper.");
	}

	
}

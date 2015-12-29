package com.diy.weedingsecretary.service;

import java.io.Serializable;

import com.diy.weedingsecretary.domain.MicroClassArticle;

public interface ArticleService {
	
	public MicroClassArticle get(Serializable id);

	public int insert(MicroClassArticle Article);

	public int update(MicroClassArticle Article);

	public int delete(Serializable id);
	
}

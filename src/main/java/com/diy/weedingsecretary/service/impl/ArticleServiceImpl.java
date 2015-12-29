package com.diy.weedingsecretary.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diy.weedingsecretary.dao.ArticleDao;
import com.diy.weedingsecretary.domain.MicroClassArticle;
import com.diy.weedingsecretary.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleDao articleDao;
	
	@Override
	public MicroClassArticle get(Serializable id) {
		return articleDao.get(id);
	}

	@Override
	public int insert(MicroClassArticle Article) {
		return articleDao.insert(Article);
	}

	@Override
	public int update(MicroClassArticle Article) {
		return articleDao.update(Article);
	}

	@Override
	public int delete(Serializable id) {
		return articleDao.delete(id);
	}

}

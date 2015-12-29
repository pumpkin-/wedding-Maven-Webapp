package com.diy.weedingsecretary.domain;

import java.io.Serializable;

public class MicroClassArticle implements Serializable {
	
	/** 
	
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	
	*/ 
	private static final long serialVersionUID = -1323083075428651440L;
	//文章ID
	private Integer id;
	//文章对应的HTML
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

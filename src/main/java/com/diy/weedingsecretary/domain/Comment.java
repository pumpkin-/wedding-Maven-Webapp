package com.diy.weedingsecretary.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 评论表
 * @author Byron
 *
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//用户id
	private Integer userId;
	//内容
	private String content;
	//日期
	private Date date;
	//回复的id集合
	private List<Integer> ids;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
	
}

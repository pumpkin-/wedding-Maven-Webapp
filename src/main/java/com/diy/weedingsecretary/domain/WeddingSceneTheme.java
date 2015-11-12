package com.diy.weedingsecretary.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 婚礼现场主题
 * @author Byron
 *
 */
public class WeddingSceneTheme implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//标题
	private String title;
	//主题效果图
	private String effectPicture;
	//标签      0:中式 1:西式 2:主题 
	private List<Integer> tags;
	//评论集合
	private List<Integer> comments;
	//收藏量
	private Integer favourateNum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEffectPicture() {
		return effectPicture;
	}
	public void setEffectPicture(String effectPicture) {
		this.effectPicture = effectPicture;
	}
	public List<Integer> getTags() {
		return tags;
	}
	public void setTags(List<Integer> tags) {
		this.tags = tags;
	}
	public List<Integer> getComments() {
		return comments;
	}
	public void setComments(List<Integer> comments) {
		this.comments = comments;
	}
	public Integer getFavourateNum() {
		return favourateNum;
	}
	public void setFavourateNum(Integer favourateNum) {
		this.favourateNum = favourateNum;
	}
	
	//TODO 宾客区,签到台,舞台
	
}

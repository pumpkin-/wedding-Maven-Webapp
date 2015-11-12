package com.diy.weedingsecretary.vo;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 结果集
 * @author Byron
 *
 */
public class MResult {
	
	private Boolean success;
	private String info;
	
	//预留字段
	private String reverse1;
	private String reverse2;
	private String reverse3;
	
	private Map<String,String> params;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getReverse1() {
		return reverse1;
	}
	public void setReverse1(String reverse1) {
		this.reverse1 = reverse1;
	}
	public String getReverse2() {
		return reverse2;
	}
	public void setReverse2(String reverse2) {
		this.reverse2 = reverse2;
	}
	public String getReverse3() {
		return reverse3;
	}
	public void setReverse3(String reverse3) {
		this.reverse3 = reverse3;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	
	
}

package com.diy.weedingsecretary.vo;

import java.io.Serializable;

/**
 * 客户端请求的参数
 * @author Administrator
 *
 */
public class HttpParams implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String reqPageName;
	public String methodTag;
    public Integer userId;
    
    
	public HttpParams() {
		super();
	}

	@Override
	public String toString() {
		return "HttpParams [reqPageName=" + reqPageName + ", methodTag=" + methodTag + ", userId=" + userId + "]";
	}
    
}

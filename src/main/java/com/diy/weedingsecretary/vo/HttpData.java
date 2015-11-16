package com.diy.weedingsecretary.vo;

import java.io.Serializable;

public class HttpData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String json;
	private MResult mResult;
	private HttpParams httpParams;
	
	public HttpData() {
		super();
	}
	public HttpData(String json, HttpParams httpParams) {
		super();
		this.json = json;
		this.httpParams = httpParams;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public MResult getmResult() {
		return mResult;
	}
	public void setmResult(MResult mResult) {
		this.mResult = mResult;
	}
	public HttpParams getHttpParams() {
		return httpParams;
	}
	public void setHttpParams(HttpParams httpParams) {
		this.httpParams = httpParams;
	}
	
	
}

package com.diy.weedingsecretary.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.diy.weedingsecretary.vo.HttpData;
import com.mysql.jdbc.StringUtils;

public class BaseController {


	/**
	 * 获取客户端的json
	 * 
	 * @param request
	 */
	public HttpData readJson(HttpServletRequest request) {
		String result = null;
		 HttpData data = null;
		try {
			request.setCharacterEncoding("UTF-8");
			BufferedReader reader = request.getReader();
			String line = null;
			StringBuffer jsonIn = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				jsonIn.append(line);
			}
			result = jsonIn.toString();
			System.out.println("request ---------------");
			System.out.println(result);
			if (StringUtils.isNullOrEmpty(result)) {
				return null;
			}
			data = JSON.parseObject(result, HttpData.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void doJsonResponse(HttpServletResponse response, HttpData httpData) {
		OutputStream os = null;
		String resultJson = null;
		try {
			resultJson = JSON.toJSONString(httpData);
			System.out.println("response ----------------------------");
			System.out.println(resultJson);
			os = response.getOutputStream();

			response.setHeader("Cache-Control", "no-cache");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf8");

			byte[] data = resultJson.getBytes("utf8");
			response.setContentLength(data.length);
			os.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package com.diy.weedingsecretary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.diy.weedingsecretary.service.FileUploadService;
import com.diy.weedingsecretary.vo.HttpData;
import com.diy.weedingsecretary.vo.MResult;

@RequestMapping("/file/operation")
@Controller
public class FileUploadController extends BaseController {

	@Autowired
	FileUploadService fileUploadService;
	
	/**
	 * 
	
	* @Title: doAvatarUpload 
	
	* @Description: 上传用户头像
	
	* @param @param request
	* @param @param response
	* @param @throws ServletException
	* @param @throws IOException    设定文件 
	
	* @return void    返回类型 
	
	* @throws
	 */
	@RequestMapping(value = "/avatarUpload.action", method = RequestMethod.POST)
	public void doAvatarUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("==========================");
		MResult result = fileUploadService.uploadUserAvatar(request);
		HttpData httpData = new HttpData();
		httpData.setJson(JSON.toJSONString(result));
		doJsonResponse(response, httpData);
	}

}

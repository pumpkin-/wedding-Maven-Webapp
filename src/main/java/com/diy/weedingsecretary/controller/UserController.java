package com.diy.weedingsecretary.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.diy.weedingsecretary.domain.User.User;
import com.diy.weedingsecretary.service.UserService;
import com.diy.weedingsecretary.vo.HttpData;
import com.diy.weedingsecretary.vo.MResult;
import com.diy.weedingsecretary.vo.UserInfo;

@RequestMapping("/user/operation")
@Controller
public class UserController extends BaseController {

	@Autowired
	UserService userService;

	// 用户登录
	@RequestMapping(value = "/userLogin.action", method = RequestMethod.POST)
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 从客户端端读取json
		HttpData data = readJson(request);
		String json = data.getJson();
		UserInfo info = userService.doLogin(json);
		data.setJson(JSON.toJSONString(info.getUser()));
		data.setmResult(info.getmResult());
		System.out.println(data.getHttpParams().toString());
		// 响应json
		doJsonResponse(response, data);
	}

	// 用户注册或者修改密码
	@RequestMapping(value = "/userRegisterOrResetPassword.action", method = RequestMethod.POST)
	public void userRegiste(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 从客户端端读取json
		HttpData data = readJson(request);
		String json = data.getJson();
		UserInfo info = userService.userRegisterOrResetPassword(json);
		data.setJson(JSON.toJSONString(info.getUser()));
		data.setmResult(info.getmResult());
		// 响应json
		doJsonResponse(response, data);

	}

	// 完善个人信息
	@RequestMapping(value = "/updateUserInfo.action", method = RequestMethod.POST)
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 从客户端端读取json
		HttpData data = readJson(request);
		String json = data.getJson();
		UserInfo info = userService.updateUserInfo(json);
		data.setJson(JSON.toJSONString(info.getUser()));
		data.setmResult(info.getmResult());
		// 响应json
		doJsonResponse(response, data);
	}

	// 根据用户id查询用户信息
	@RequestMapping(value = "/getUserInfo.action", method = RequestMethod.POST)
	public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 从客户端端读取json
		HttpData data = readJson(request);
		String json = data.getJson();
		User user = userService.getUserById(json);
		data.setJson(JSON.toJSONString(user));
		// 响应json
		doJsonResponse(response, data);
	}
	
	// 根据用户名查询用户信息
	@RequestMapping(value = "/getUserByUsername.action", method = RequestMethod.POST)
	public void getUserByUsername(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 从客户端端读取json
		HttpData data = readJson(request);
		String json = data.getJson();
		UserInfo info = userService.getUserByUsername(json);
		data.setJson(JSON.toJSONString(info.getUser()));
		data.setmResult(info.getmResult());
		// 响应json
		doJsonResponse(response, data);
	}

}

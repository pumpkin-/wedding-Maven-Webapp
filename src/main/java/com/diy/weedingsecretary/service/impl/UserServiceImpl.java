package com.diy.weedingsecretary.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.diy.weedingsecretary.dao.UserDao;
import com.diy.weedingsecretary.domain.User.User;
import com.diy.weedingsecretary.service.UserService;
import com.diy.weedingsecretary.vo.MResult;
import com.diy.weedingsecretary.vo.UserInfo;
import com.mysql.jdbc.StringUtils;

/**
 * 
 * 
 * @ClassName: UserServiceImpl
 * 
 * @Description: 用户处理完善
 * 
 * @author 孙嘉楠(Byron)
 * 
 * @date 2015-10-31 下午9:11:49
 * 
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User get(Serializable id) {
		return userDao.get(id);
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int delete(Serializable id) {
		return userDao.delete(id);
	}

	/**
	 * 处理用户登录请求
	 */
	public UserInfo doLogin(String json) {
		System.out.println(json);
		MResult result = new MResult();
		UserInfo userInfo = new UserInfo();
		User user = parseJsonToUser(json);
		User userLogin = userDao.selectByUsername(user.getUsername());

		if (userLogin != null) {
			if(userLogin.getPassword().equals(user.getPassword())) {
			 result.setSuccess(true);
			} else {
				result.setInfo("密码错误");
				result.setSuccess(false);
			}
		} else {
			result.setInfo("用户不存在");
			result.setSuccess(false);
		}

		userInfo.setmResult(result);
		userInfo.setUser(userLogin);
		return userInfo;
	}

	/**
	 * 
	 * @Title: updateUserInfo
	 * 
	 * @Description: 完善用户资料
	 * 
	 * @param @param user
	 * @param @return 设定文件
	 * 
	 * @return MResult 返回类型
	 * 
	 * @throws
	 */
	public MResult updateUserInfo(String json) {
		MResult mResult = new MResult();
		User user = parseJsonToUser(json);
		System.out.println(user);
		if (user != null) {
			if (update(user) > 0) {
				mResult.setSuccess(true);
			} else {
				mResult.setSuccess(false);
			}
		} else {
			mResult.setSuccess(false);
		}
		return mResult;

	}

	/**
	 * 
	 * 
	 * @Title: userRegist
	 * 
	 * @Description: 用户注册
	 * 
	 * @param @param user
	 * @param @return 设定文件
	 * 
	 * @return MResult 返回类型
	 * 
	 * @throws
	 */
	public MResult userRegiste(String json) {
		MResult mResult = new MResult();
		User user = parseJsonToUser(json);
		User dbuser = userDao.selectByUsername(user.getUsername());
		//用户已存在
		if(dbuser != null) {
			mResult.setSuccess(false);
			mResult.setInfo("用户已存在");
			return mResult;
		}
		if (user != null) {
			if (insert(user) > 0) {
				user = userDao.selectByUsername(user.getUsername());
				mResult.setSuccess(true);
				mResult.setInfo("注册成功");
				mResult.setReverse1(user.getId()+"");
			} else {
				mResult.setSuccess(false);
				mResult.setInfo("注册失败,请重试");
			}
		}
		return mResult;
	}

	/**
	 * 
	 * 
	 * @Title: parseJsonToUser
	 * 
	 * @Description: 将json字符串转为user对象
	 * 
	 * @param @param json
	 * @param @return 设定文件
	 * 
	 * @return User 返回类型
	 * 
	 * @throws
	 */
	private User parseJsonToUser(String json) {
		if (StringUtils.isNullOrEmpty(json)) {
			return null;
		} else {
			User user = JSON.parseObject(json, User.class);
			return user;
		}
	}
	
	/**
	 * 
	
	* @Title: getUserById 
	
	* @Description: 根据用户id获取用户
	
	* @param @param json
	* @param @return    设定文件 
	
	* @return User    返回类型 
	
	* @throws
	 */
	public User getUserById(String json) {
		if (StringUtils.isNullOrEmpty(json)) {
			return null;
		} else {
			
			User user = get(String.valueOf(json));
			return user;
		}
	}

}

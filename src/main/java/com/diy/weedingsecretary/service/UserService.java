package com.diy.weedingsecretary.service;

import java.io.Serializable;

import com.diy.weedingsecretary.domain.User.User;
import com.diy.weedingsecretary.vo.UserInfo;
import com.diy.weedingsecretary.vo.MResult;

/**
 * 

* @ClassName: UserService 

* @Description: 

* @author 孙嘉楠(Byron)

* @date 2015-10-31 下午8:16:45 

*
 */
public interface UserService {
	
	public User get(Serializable id);
	public int insert(User user);
	public int update(User user);
	public int delete(Serializable id);
	UserInfo doLogin(String json);
	MResult updateUserInfo(String json);
	MResult userRegiste(String json);
	User getUserById(String json);
	
}

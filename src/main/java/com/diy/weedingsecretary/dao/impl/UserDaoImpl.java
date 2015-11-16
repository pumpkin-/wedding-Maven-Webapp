package com.diy.weedingsecretary.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.diy.weedingsecretary.dao.UserDao;
import com.diy.weedingsecretary.domain.User.User;

/**
 * 
 * 
 * @ClassName: UserDaoImpl
 * 
 * @Description: 对tb_user用户表的操作
 * 
 * @author 孙嘉楠(Byron)
 * 
 * @date 2015-10-31 下午8:05:25
 * 
 * 
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		this.setNs("com.diy.weeding.mapper.UserMapper.");
	}

	@Override
	public User userLogin(User user) {
		return this.getSqlSession().selectOne(getNs() + "userLogin", user);
	}

	@Override
	public User selectByUsername(String username) {
		return this.getSqlSession().selectOne(getNs() + "selectByUsername", username);
	}

	@Override
	public User resetPassword(User user) {
		
		return this.getSqlSession().selectOne(getNs() + "resetPassword", user);
	}

}

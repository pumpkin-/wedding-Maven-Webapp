package com.diy.weedingsecretary.dao;

import com.diy.weedingsecretary.domain.User.User;

public interface UserDao extends BaseDao<User> {
	
	User userLogin(User user);
	User selectByUsername(String username);
	int resetPassword(User user);
}

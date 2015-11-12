package com.diy.weedingsecretary.vo;

import com.diy.weedingsecretary.domain.User.User;

/**
 * 

* @ClassName: LoginInfo 

* @Description: 用户登录返回	

* @author 孙嘉楠(Byron)

* @date 2015-10-31 下午10:20:32 

*
 */
public class UserInfo {
	
	private User user;
	private MResult mResult;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MResult getmResult() {
		return mResult;
	}
	public void setmResult(MResult mResult) {
		this.mResult = mResult;
	}
	
}

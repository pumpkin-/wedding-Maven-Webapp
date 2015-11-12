package com.diy.weedingsecretary.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.diy.weedingsecretary.vo.MResult;

/**
 * 

* @ClassName: FileUploadService 

* @Description: 文件上传

* @author 孙嘉楠(Byron)

* @date 2015-11-4 下午8:59:51 

*
 */
public interface FileUploadService {
	
	/**
	 * 
	
	* @Title: uploadUserAvatar 
	
	* @Description: 上传用户头像
	
	* @param @param request
	* @param @return    设定文件 
	
	* @return MResult    返回类型 
	
	* @throws
	 */
	MResult uploadUserAvatar(HttpServletRequest request);

}

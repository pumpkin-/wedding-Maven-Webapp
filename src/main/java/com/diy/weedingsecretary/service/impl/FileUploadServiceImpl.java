package com.diy.weedingsecretary.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diy.weedingsecretary.dao.UserDao;
import com.diy.weedingsecretary.domain.User.User;
import com.diy.weedingsecretary.service.FileUploadService;
import com.diy.weedingsecretary.vo.MResult;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	UserDao userDao;

	String baseUrl = "http://192.168.0.102:8080/wedding";
	private String uploadPath = "/files/upload/"; // 上传文件的目录
	private String tempPath = "/files/uploadtmp/"; // 临时文件目录

	private int sizeMax = 9;// 图片最大上限
	private String[] fileType = new String[] { ".jpg", ".gif", ".bmp", ".png", ".jpeg", ".ico" };

	/**
	 * 
	 * 
	 * @Title: uploadFiles
	 * 
	 * @Description: 文件上传
	 * 
	 * @param @param request
	 * @param @return 设定文件
	 * 
	 * @return MResult 返回类型
	 * 
	 * @throws
	 */
	public MResult uploadFiles(HttpServletRequest request) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		String parameter = request.getHeader("msg");
		System.out.println(parameter);

		MResult mResult = new MResult();

		String serverPath = getServerPath();

		// Servlet初始化时执行,如果上传文件目录不存在则自动创建
		if (!new File(serverPath + uploadPath).isDirectory()) {
			new File(serverPath + uploadPath).mkdirs();
		}
		if (!new File(serverPath + tempPath).isDirectory()) {
			new File(serverPath + tempPath).mkdirs();
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(5 * 1024); // 最大缓存
		factory.setRepository(new File(serverPath + tempPath));// 临时文件目录

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(sizeMax * 1024 * 1024);// 文件最大上限

		String filePath = null;
		try {
			List<FileItem> items = upload.parseRequest(request);// 获取所有文件列表
			for (FileItem item : items) {
				// bodyparamtar 判断是否为文件 获得文件名，这个文件名包括路径
				if (!item.isFormField()) {
					// 文件名
					String fileName = item.getName().toLowerCase();

					if (fileName.endsWith(fileType[0]) || fileName.endsWith(fileType[1])
							|| fileName.endsWith(fileType[2]) || fileName.endsWith(fileType[3])
							|| fileName.endsWith(fileType[4]) || fileName.endsWith(fileType[5])) {
						String uuid = UUID.randomUUID().toString();

						String webLoction = uploadPath + uuid + fileName.substring(fileName.lastIndexOf("."));

						filePath = serverPath + webLoction;
						System.out.println(filePath);
						item.write(new File(filePath));
						// 上传成功
						mResult.setSuccess(true);
						String webUrl = baseUrl + webLoction;
						mResult.setReverse1(webUrl);
					} else {
						// 上传失败
						mResult.setSuccess(false);
					}
				} else {
					map.put(item.getFieldName(), item.getString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 上传文件超出限制
			mResult.setSuccess(false);
		} finally {
			mResult.setParams(map);
		}
		return mResult;
	}

	/**
	 * 
	 * 
	 * @Title: getServerPath
	 * 
	 * @Description: 获取服务器存储路径
	 * 
	 * @param @return 设定文件
	 * 
	 * @return String 返回类型
	 * 
	 * @throws
	 */
	public String getServerPath() {
		String serverPath = "/" + this.getClass().getResource("/").getPath().substring(1).replace("%20", "");
		int lastWeb = this.getClass().getResource("/").getPath().substring(1).lastIndexOf("WEB-INF");
		serverPath = serverPath.substring(0, lastWeb);
		return serverPath;
	}



	/**
	 * 
	 * 
	 * @Title: uploadUserAvatar
	 * 
	 * @Description: 上传用户头像
	 * 
	 * @param @param request 设定文件
	 * 
	 * @return void 返回类型
	 * 
	 * @throws
	 */
	public MResult uploadUserAvatar(HttpServletRequest request) {

		// 上传文件
		MResult mResult = uploadFiles(request);
		
		
		String serverPath = getServerPath();
		String newImgPath = mResult.getReverse1();
		String newpath = "";
		if(newImgPath != null) {
			newpath= serverPath + newImgPath.substring(baseUrl.length());
		}
		
		Map<String, String> params = mResult.getParams();
		String userId = params.get("id");
		User user = userDao.get(userId);
		if (user == null) {
			mResult.setSuccess(false);
			FileUtils.deleteQuietly(new File(newpath));
			return (mResult);
		}
		String oldImgPath = user.getAvatar();
		
		
		String oldpath = "";
		// 获取服务器图片完整路径
		
		if(oldImgPath != null) {
			oldpath = serverPath + oldImgPath.substring(baseUrl.length());
		}
		
		// 上传成功将新的图片存入服务器 ,并删除旧的图片
		if (mResult != null && mResult.getSuccess()) {
			user.setAvatar(mResult.getReverse1());
			System.out.println(user);
			int update = userDao.update(user);
			//System.out.println("upadte" + update);
			if(update <= 0) {
				mResult.setSuccess(false);
				FileUtils.deleteQuietly(new File(newpath));
				mResult.setReverse1(oldImgPath);
			} else {
				mResult.setSuccess(true);
				if(oldImgPath != null) {
					FileUtils.deleteQuietly(new File(oldpath));
				}
			}
		}

		return mResult;
	}

}

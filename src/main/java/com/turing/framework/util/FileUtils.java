package com.turing.framework.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUtils {
	private static String upload ="upload";
	
	public static String upload(CommonsMultipartFile picFile,
			HttpServletRequest request) {
		String cover = "";
		if (!picFile.isEmpty()) {
			String originalName = picFile.getOriginalFilename();
			String fileType = originalName.substring(originalName
					.lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + fileType;
			ServletContext application = request.getSession().getServletContext();
			String path = application.getRealPath(upload);
			java.io.File file = new java.io.File(path + "\\" + fileName);
			try {
				picFile.getFileItem().write(file);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			StringBuffer realPath = request.getRequestURL();
			cover = realPath.toString().substring(
					0,
					realPath.toString().indexOf(request.getContextPath())
							+ request.getContextPath().length())
					+ "/"+upload+"/" + fileName;
		}
		return cover;
	}
	
	public static boolean delete(String cover,HttpServletRequest request){
		boolean flag = false;
		if (cover!=null&&!"".equals(cover)) {
			ServletContext application = request.getSession().getServletContext();
			String path = application.getRealPath(upload);
			String filePath = path+"//"+cover.substring(cover.lastIndexOf("/")+1);
			File file = new File(filePath);
			if (file.exists()) {
				flag = file.delete();
			}
		}
		return flag;
	}
}

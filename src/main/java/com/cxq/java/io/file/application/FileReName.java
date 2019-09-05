package com.cxq.java.io.file.application;

import java.io.File;

public class FileReName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String format = ".avi";
		File dir = new File("E:\\JAVA\\01_尚硅谷Java教程\\16_Spring注解驱动开发\\视频");
		File[] files = dir.listFiles();
		for(File f : files){
			String fileName = f.getName();
//			int index = fileName.lastIndexOf(".");
//			String newFileName = fileName.substring(0, index) + format + fileName.substring(index);
//			String newFilePath = f.getParent() + File.separator + newFileName;
			String newFileName = fileName.replace("-", "_");
			String newFilePath = f.getParent() + File.separator + newFileName;
			reName(f.getAbsolutePath(),newFilePath);
			System.out.println("fileName:" + fileName + "		newFileName:" + newFileName +"		newPath:" + newFilePath);
		}
//		File dir = new File("E:\\个人资料\\相册\\湖北大学\\2013东湖-落雁岛\\东湖-落雁岛2");
//		File[] files = dir.listFiles();
//		for(File f : files){
//			String fileName = f.getName();
//			int index = 9;
//			String newFileName = fileName.replace("1.", "2.");
//			String newFilePath = f.getParent() + File.separator + newFileName;
//			reName(f.getAbsolutePath(),newFilePath);
//			System.out.println("path:" + newFilePath);
//		}
		
	}
	
	public static void reName(String filePath, String newFilePath){
		File file = new File(filePath);
		file.renameTo(new File(newFilePath));
	}

}

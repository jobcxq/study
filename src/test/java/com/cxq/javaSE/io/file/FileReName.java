package com.cxq.javaSE.io.file;

import java.io.File;

public class FileReName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String format = ".avi";
		File dir = new File("E:\\JAVA\\01_尚硅谷Java教程\\10_Web基础\\04_React\\01_视频");
		File[] files = dir.listFiles();
		for(File f : files){
			String fileName = f.getName();
			String newFileName = fileName.replace("_尚硅谷", "");
			String newFilePath = f.getParent() + File.separator + newFileName;
			reName(f.getAbsolutePath(),newFilePath);
			System.out.println("fileName:" + fileName + "		newFileName:" + newFileName +"		newPath:" + newFilePath);
		}
	}
	
	public static void reName(String filePath, String newFilePath){
		File file = new File(filePath);
		file.renameTo(new File(newFilePath));
	}

}

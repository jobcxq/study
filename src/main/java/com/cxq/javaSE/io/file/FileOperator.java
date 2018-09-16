package com.cxq.javaSE.io.file;

import java.io.File;

public class FileOperator {
	
	static int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String fileName = "E:\\02_基本语法";
		String fileName = "E:\\百度云同步盘\\JAVA\\01_尚硅谷Java教程\\01_Java基础\\03_视频\\13_Java反射机制";
		findFile(fileName);
	}
	
	public static void findFile(String fileName){
		File file = new File(fileName);
		if(!file.exists()){
			System.out.println("文件/文件夹：" + fileName + " 不存在！");
		}else if(file.isDirectory()){
			File [] files = file.listFiles();
			if(files != null && files.length > 0){
				for(int i = 0; i < files.length; i ++){
					if(files[i].isDirectory()){
						findFile(files[i].getAbsolutePath());
					}else{
						fileOperator(files[i]);
					}
				}
			}
		}else{
			fileOperator(file);
		}
	}
	
	public static void fileOperator(File file){
		System.out.println("file name:" + file.getName());
		
		fileReName(file);
	}
	
	public static void fileReName(File file){
		String fileName = file.getName();
		String fileFormat = fileName.substring(fileName.lastIndexOf(".")+1);
		if(fileFormat.equals("wmv")){
			String newName = Integer.toString(++count).length() == 1 ? "0" + count : Integer.toString(count);
			newName += fileName.substring(2);
//			newName += ".jpg";
			System.out.println("new name:" + newName);
			String fileLocation = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\"));
			File newFile = new File(fileLocation + "\\" + newName);
			if(!newFile.exists()){
				file.renameTo(newFile);
			}else{
				System.out.println("文件名：" + newName + " 已存在：" + newFile.getAbsolutePath());
			}
		}
	}

}

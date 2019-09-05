package com.cxq.java.io.file;

import java.io.File;

public class SvnFileDelete {
	
	private static int count = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String path = "C:\\Users\\Qin\\Desktop\\imagecontrol";
		String path = "E:/JAVA/11_开源框架jar包/Javascript & jQuery & Ajax & JSON/JQuery/jQuery 插件/jquery-form-validate";
		deleteFile(new File(path));
		System.out.println("=====over=====:count=" + count);
	}
	
	public static void deleteFile(File file){
		File [] fileList = file.listFiles();
		for(File f : fileList){
			if(f.getName().equals(".svn")){
				deleteAll(f);
			}else if(f.isDirectory()){
				deleteFile(f);
			}
		}
	}
	
	public static void deleteAll(File file){
		File [] fileList = file.listFiles();
		for(File f : fileList){
			if(f.isFile()){
				System.out.println(f.getAbsolutePath());
				try{
					System.out.println(f.delete());
					count ++;
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(f.isDirectory() && f.listFiles().length == 0){
				System.out.println(f.getAbsolutePath());
				try{
					System.out.println(f.delete());
					count ++;
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				deleteAll(f);
			}
		}
		try{
			System.out.println(file.delete());
			count ++;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

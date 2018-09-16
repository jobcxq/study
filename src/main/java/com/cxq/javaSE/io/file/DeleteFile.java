package com.cxq.javaSE.io.file;

import java.io.File;

public class DeleteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "E://test";
		File file = new File(path);
		deleteFile(file);
	}
	
	public static boolean deleteFile(File file){
		if(file.exists()){
			String[] filesList = file.list();
			if(filesList!=null){
				System.out.println("length: "+filesList.length);
				for(int i = 0;i < filesList.length; i++){
					//File subFile = new File(file + "//" + filesList[i]);
					File subFile = new File(file,filesList[i]);
					System.out.println("file name: " + subFile.getName());
					if(!deleteFile(subFile)){
						return false;
					}
				}
			}
		}
		return file.delete();
	}

}

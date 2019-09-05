package com.cxq.java.io.file.application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "E:\\JAVA";
		File file= new File(filePath);
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		String str = gson.toJson(file);
		System.out.println("==========str==========" + str.length());
		file.writeLog("E:/log.txt","\r\n\r\n" + str + "\r\n");
		System.exit(0);
	}
}

package com.cxq.java.base;

import sun.security.provider.MD5;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public class TestString {

	private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		switchNull(null);
//		String a = "a", b = "b", c = "c", d = "a";
//		System.out.println(a == d);
//		swap(a, b);
//		System.out.println("a=" + a + ", b=" + b);

		String s = "11";
		String b = null;
		System.out.println(s + b + s);

//		FileInputStream is = new FileInputStream(new File("C:\\Users\\8000654471\\Downloads\\image20190905141100112055850.pdf"));
//		FileInputStream is = new FileInputStream(new File("C:\\Users\\8000654471\\Downloads\\DZ000062PDEA19330203010000600002.txt"));
//
//		byte[] buffer = new byte[is.available()];
//		is.read(buffer,0,buffer.length);
//		MessageDigest md = MessageDigest.getInstance("MD5");
//		md.update(buffer);
//
//		System.out.println(bufferToHex(md.digest()));

	}

	private static void switchNull(String str){
		switch (str){
			case "1" : System.out.println("1");
			case "2" : System.out.println("2");
			default:System.out.println("null");
		}

	}

	private static String bufferToHex(byte bytes[]) {
		int m = 0;
		int n = bytes.length;
		StringBuilder stringbuffer = new StringBuilder(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			char c0 = hexDigits[(bytes[l] & 0xf0) >> 4];
			char c1 = hexDigits[bytes[l] & 0xf];
			stringbuffer.append(c0);
			stringbuffer.append(c1);
		}
		return stringbuffer.toString();
	}


	public static void swap(String a, String b){
		String tmp = a;
		a = b;
		b = tmp;
	}

}

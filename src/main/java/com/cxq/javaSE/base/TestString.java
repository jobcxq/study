package com.cxq.javaSE.base;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String a = "a", b = "b", c = "c", d = "a";
		System.out.println(a == d);
		swap(a, b);
		System.out.println("a=" + a + ", b=" + b);

	}

	public static void swap(String a, String b){
		String tmp = a;
		a = b;
		b = tmp;
	}

}

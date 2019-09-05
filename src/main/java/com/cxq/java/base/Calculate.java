package com.cxq.java.base;

public class Calculate {

	public static void main(String[] args){
		int a = 5,b = 5;
		a = add1(a,b);
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}
	
	public static void add(int x, int y){
		x += y;	//x = x + y
		y -= x;	//y = y - x
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
	
	public static int add1(int x, int y){
		return (x += y);
	}
}

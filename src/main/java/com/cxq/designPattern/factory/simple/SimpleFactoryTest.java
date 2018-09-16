package com.cxq.designPattern.factory.simple;

import com.cxq.designPattern.factory.vo.Milk;

public class SimpleFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleFactory factory = new SimpleFactory();
		
		Milk milk = factory.getMilk("伊利");
		System.out.println(milk.getMikeName());
	}

}

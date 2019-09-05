package com.cxq.designpattern.factory.simple;

import com.cxq.designpattern.factory.vo.IMilk;

public class SimpleFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleFactory factory = new SimpleFactory();
		
		IMilk milk = factory.getMilk("伊利");
		System.out.println(milk.getMikeName());
	}

}

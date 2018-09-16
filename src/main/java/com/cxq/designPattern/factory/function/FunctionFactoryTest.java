package com.cxq.designPattern.factory.function;

public class FunctionFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//工厂方法的模式
		MilkFactory factory = new TelunsuFactory();
		System.out.println(factory.getMilk().getMikeName());
		
		factory = new MengniuFactory();
		System.out.println(factory.getMilk().getMikeName());
		
	}

}

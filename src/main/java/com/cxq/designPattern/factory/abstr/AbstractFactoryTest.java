package com.cxq.designPattern.factory.abstr;

public class AbstractFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//抽象工厂模型
		AbstractMilkFactory factory = new MilkFactory();
		
		//用户只有选择的权限,对工厂升级，不会对外部有影响
		System.out.println(factory.getMengniu().getMikeName());
		System.out.println(factory.getTelunsu().getMikeName());
		
	}

}

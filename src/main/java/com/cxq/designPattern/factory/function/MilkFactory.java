package com.cxq.designPattern.factory.function;

import com.cxq.designPattern.factory.vo.Milk;

public interface MilkFactory {

	//牛奶配比等公共方法
	
	/**
	 * 
	 * @return
	 */
	public Milk getMilk();
	
}

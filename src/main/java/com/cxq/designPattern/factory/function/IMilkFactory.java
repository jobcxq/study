package com.cxq.designPattern.factory.function;

import com.cxq.designPattern.factory.vo.IMilk;

public interface IMilkFactory {

	//牛奶配比等公共方法
	
	/**
	 * 
	 * @return
	 */
	public IMilk getMilk();
	
}

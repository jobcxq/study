package com.cxq.designpattern.factory.abstr;

import com.cxq.designpattern.factory.vo.IMilk;

/**
 * 抽象工厂，用户的主入口
 * @author Qin
 *
 */
public interface IMilkFactory {

	//公共逻辑，便于统一管理

	public IMilk getMilk();

	public IYogurt getYogurt();
	
}

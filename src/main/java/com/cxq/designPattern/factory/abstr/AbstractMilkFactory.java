package com.cxq.designPattern.factory.abstr;

import com.cxq.designPattern.factory.vo.Milk;

/**
 * 抽象工厂，用户的主入口
 * @author Qin
 *
 */
public abstract class AbstractMilkFactory {

	//公共逻辑，便于统一管理
	
	public abstract Milk getMengniu();
	
	public abstract Milk getTelunsu();
	
	public abstract Milk getYili();
}

package com.cxq.designPattern.factory.function;

import com.cxq.designPattern.factory.vo.Milk;
import com.cxq.designPattern.factory.vo.Yili;

public class YiliFactory implements MilkFactory{

	@Override
	public Milk getMilk() {
		return new Yili();
	}

}

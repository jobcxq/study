package com.cxq.designPattern.factory.function;

import com.cxq.designPattern.factory.vo.Mengniu;
import com.cxq.designPattern.factory.vo.Milk;

public class MengniuFactory implements MilkFactory{

	@Override
	public Milk getMilk() {
		return new Mengniu();
	}

}

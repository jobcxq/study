package com.cxq.designPattern.factory.function;

import com.cxq.designPattern.factory.vo.Milk;
import com.cxq.designPattern.factory.vo.Telunsu;

public class TelunsuFactory implements MilkFactory{

	@Override
	public Milk getMilk() {
		return new Telunsu();
	}

}

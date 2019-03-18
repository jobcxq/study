package com.cxq.designPattern.factory.abstr;

import com.cxq.designPattern.factory.vo.IMilk;
import com.cxq.designPattern.factory.vo.MengniuMilk;

public class MengniuFactory implements IMilkFactory {


	@Override
	public IMilk getMilk() {
		return new MengniuMilk();
	}

	@Override
	public IYogurt getYogurt() {
		return new MengniuYogurt();
	}
}

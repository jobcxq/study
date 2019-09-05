package com.cxq.designpattern.factory.abstr;

import com.cxq.designpattern.factory.vo.IMilk;
import com.cxq.designpattern.factory.vo.MengniuMilk;

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

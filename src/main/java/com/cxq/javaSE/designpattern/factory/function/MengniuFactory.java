package com.cxq.designpattern.factory.function;

import com.cxq.designpattern.factory.vo.IMilk;
import com.cxq.designpattern.factory.vo.MengniuMilk;

public class MengniuFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new MengniuMilk();
	}

}

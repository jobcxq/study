package com.cxq.java.designpattern.factory.function;

import com.cxq.java.designpattern.factory.vo.IMilk;
import com.cxq.java.designpattern.factory.vo.MengniuMilk;

public class MengniuFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new MengniuMilk();
	}

}

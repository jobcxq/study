package com.cxq.java.designpattern.factory.function;

import com.cxq.java.designpattern.factory.vo.IMilk;
import com.cxq.java.designpattern.factory.vo.YiliMilk;

public class YiliFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new YiliMilk();
	}

}

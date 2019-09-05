package com.cxq.javaSE.designpattern.factory.function;

import com.cxq.javaSE.designpattern.factory.vo.IMilk;
import com.cxq.javaSE.designpattern.factory.vo.YiliMilk;

public class YiliFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new YiliMilk();
	}

}

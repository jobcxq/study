package com.cxq.designPattern.factory.function;

import com.cxq.designPattern.factory.vo.IMilk;
import com.cxq.designPattern.factory.vo.YiliMilk;

public class YiliFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new YiliMilk();
	}

}

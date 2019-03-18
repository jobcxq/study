package com.cxq.designPattern.factory.function;

import com.cxq.designPattern.factory.vo.IMilk;
import com.cxq.designPattern.factory.vo.TelunsuMilk;

public class TelunsuFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new TelunsuMilk();
	}

}

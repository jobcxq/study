package com.cxq.java.designpattern.factory.function;

import com.cxq.java.designpattern.factory.vo.IMilk;
import com.cxq.java.designpattern.factory.vo.TelunsuMilk;

public class TelunsuFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new TelunsuMilk();
	}

}

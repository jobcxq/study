package com.cxq.javaSE.designpattern.factory.function;

import com.cxq.javaSE.designpattern.factory.vo.IMilk;
import com.cxq.javaSE.designpattern.factory.vo.TelunsuMilk;

public class TelunsuFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new TelunsuMilk();
	}

}

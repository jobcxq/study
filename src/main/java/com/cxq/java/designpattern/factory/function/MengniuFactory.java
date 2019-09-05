package com.cxq.javaSE.designpattern.factory.function;

import com.cxq.javaSE.designpattern.factory.vo.IMilk;
import com.cxq.javaSE.designpattern.factory.vo.MengniuMilk;

public class MengniuFactory implements IMilkFactory {

	@Override
	public IMilk getMilk() {
		return new MengniuMilk();
	}

}

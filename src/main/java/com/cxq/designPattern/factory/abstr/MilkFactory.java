package com.cxq.designPattern.factory.abstr;

import com.cxq.designPattern.factory.function.MengniuFactory;
import com.cxq.designPattern.factory.function.TelunsuFactory;
import com.cxq.designPattern.factory.function.YiliFactory;
import com.cxq.designPattern.factory.vo.Mengniu;
import com.cxq.designPattern.factory.vo.Milk;
import com.cxq.designPattern.factory.vo.Telunsu;
import com.cxq.designPattern.factory.vo.Yili;

public class MilkFactory extends AbstractMilkFactory{

	@Override
	public Milk getMengniu() {
//		return new Mengniu();
		return new MengniuFactory().getMilk();
	}

	@Override
	public Milk getTelunsu() {
//		return new Telunsu();
		return new TelunsuFactory().getMilk();
	}

	@Override
	public Milk getYili() {
//		return new Yili();
		return new YiliFactory().getMilk();
	}

}

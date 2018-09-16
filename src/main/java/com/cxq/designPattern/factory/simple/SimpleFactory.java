package com.cxq.designPattern.factory.simple;

import com.cxq.designPattern.factory.vo.Mengniu;
import com.cxq.designPattern.factory.vo.Milk;
import com.cxq.designPattern.factory.vo.Telunsu;
import com.cxq.designPattern.factory.vo.Yili;

public class SimpleFactory {

	public Milk getMilk(String name){
		if("蒙牛".equals(name)){
			return new Mengniu();
		}else if("特仑苏".equals(name)){
			return new Telunsu();
		}else if("伊利".equals(name)){
			return new Yili();
		}else{
			System.out.println("无指定的牛奶：" + name);
			return null;
		}
	}
	
}

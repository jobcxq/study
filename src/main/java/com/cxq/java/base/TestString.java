package com.cxq.java.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String a = "a", b = "b", c = "c", d = "a";
		System.out.println(a == d);
		swap(a, b);
		System.out.println("a=" + a + ", b=" + b);
		new String("String");
		praseString();

		List<String> list = new ArrayList<>();

	}

	private static void praseString() {
		String message = "0101010128_重复投保[该车已在平安保险公司存在有效保单记录，保险期限是2018年08月24日 00:00－2019年08月23日 23:59[保险起期-保险止期]，请核对.]";
//		String message = "0101010128_重复投保[该车已在河南省地区国寿财险公司存在有效保单记录，保险期限是2019年05月08日 00:00－2020年05月07日 23:59[保险起期-保险止期]，请核对.]";
		String company = message.substring(message.indexOf("已在") + 2, message.indexOf("公司"));
		if(company.contains("地区")){
			System.out.println("地区：" + company.substring(0, company.indexOf("地区")).replace("省",""));
			System.out.println("公司：" + company.substring(company.indexOf("地区") + 2));
		}else{
			System.out.println("公司：" + company);
		}

		String dateMessage = message.substring(message.indexOf("保险期限是") + 5, message.indexOf("[保险起期-保险止期]"));
		System.out.println("保险起止日期：" + dateMessage);

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		try{
			System.out.println("保险起期：" + df.parse(dateMessage.substring(0, dateMessage.indexOf("－"))));
			System.out.println("保险止期：" + df.parse(dateMessage.substring(dateMessage.indexOf("－") + 1)));

		}catch (Exception e){
			e.printStackTrace();
		}


	}

	public static void swap(String a, String b){
		String tmp = a;
		a = b;
		b = tmp;
	}

}

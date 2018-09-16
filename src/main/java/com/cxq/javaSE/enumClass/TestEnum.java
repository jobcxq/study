package com.cxq.javaSE.enumClass;
/*
 * 一、枚举类
 * 1.如何自定义枚举类
 * 2.如何使用enum关键字定义枚举类
 *     >常用的方法:values() valueOf(String name)
 *     >如何让枚举类实现接口:可以让不同的枚举类的对象调用被重写的抽象方法，执行的效果不同。（相当于让每个对象重写抽象方法）
 */
public class TestEnum {
	public static void main(String[] args) {
		EnumSeason spring = EnumSeason.SPRING;
		System.out.println(spring);
		spring.show();
		System.out.println(spring.getSeasonName());
		
		System.out.println();
		//1.values()
		EnumSeason[] seasons = EnumSeason.values();
		for(int i = 0;i < seasons.length;i++){
			System.out.println(seasons[i]);
		}
		//2.valueOf(String name):要求传入的形参name是枚举类对象的名字。
		//否则，报java.lang.IllegalArgumentException异常
		String str = "WINTER";
		EnumSeason sea = EnumSeason.valueOf(str);
		System.out.println(sea);
		System.out.println();
		
		Thread.State[] states = Thread.State.values();
		for(int i = 0;i < states.length;i++){
			System.out.println(states[i]);
		}
		sea.show();
		
	}
}
interface Info{
	void show();
}
//枚举类
enum EnumSeason implements Info{
	SPRING("spring", "春暖花开"){
		public void show(){
			System.out.println("春天在哪里？");
		}
	},
	SUMMER("summer", "夏日炎炎"){
		public void show(){
			System.out.println("生如夏花");
		}
	},
	AUTUMN("autumn", "秋高气爽"){
		public void show(){
			System.out.println("秋天是用来分手的季节");
		}
	},
	WINTER("winter", "白雪皑皑"){
		public void show(){
			System.out.println("冬天里的一把火");
		}
	};
	
	private final String seasonName;
	private final String seasonDesc;
	
	private EnumSeason(String seasonName,String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	public String getSeasonName() {
		return seasonName;
	}
	
	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc="
				+ seasonDesc + "]";
	}
	
}
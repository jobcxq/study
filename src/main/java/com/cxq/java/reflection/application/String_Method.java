package com.cxq.java.reflection.application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class String_Method {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String key = "name=cxq,sex=M,age=25";
			
			String[] keys = key.split(",");
			Class clazz = People.class;
			People people = (People) clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();
			for(String str : keys){
				
				int index = str.indexOf("=");
				String param = str.substring(0, index);
				String value = str.substring(index + 1);
				String setMethod = getSetMethod(param);//获取param对应的set方法名
				for(Method m : methods){
					if(setMethod.equals(m.getName())){
							Method method = clazz.getDeclaredMethod(setMethod, String.class);
							method.invoke(people, value);
					}
				}
			}
			System.out.println(people);
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getSetMethod(String str){
		String string = "";
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length; i ++){
			if(i == 0)
				string = String.valueOf(c[i]).toUpperCase();
			else
				string += c[i];
		}
		System.out.println("String:" + string);
		return "set" + string;
	}
	
}

class People{
	private String name;
	private String sex;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "People [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
	
}




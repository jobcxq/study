package com.cxq.java.reflection.aboutClass;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import com.cxq.java.reflection.bean.Person;
import org.junit.Test;

/**
 * 
 * @author Qin
 *
 */
public class TestClass {
	
	/**
	 * 通过反射创建一个类的对象，并调用其中的结构
	 * @throws Exception 
	 */
	@Test
	public void test1() throws Exception{
		Class clazz = Person.class;	
		//使用了泛型，可以用 Class<Person> clazz = Person.class;不需要强转
		
		//1.创建clazz对应的运行时类Person类的对象
		Person p = (Person) clazz.newInstance();
		
		//2.通过反射调用运行时类的指定的属性
		Field name = clazz.getField("name");
		name.set(p, "chenxiaoqin");
		
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);	//设置private变量的访问权限
		age.set(p, 24);
		
		System.out.println(p);
		
		//3.通过反射调用运行时类的指定的方法
		Method showHeight = clazz.getMethod("showHeight", int.class);
		showHeight.invoke(p, 170);
	}
	
	/**
	 * java.lang.Class:是反射的源头。
	 * 我们创建了一个类，通过编译（javac.exe），生成对应的.class文件。之后我们使用java.exe加载（JVM的类加载器完成的）此.class文件，
	 * 该.class文件加载到内存以后，就是一个运行时类，存放在缓存区。那么这个运行时类本身就是一个Class的实例！
	 * 1.每一个运行时类只加载一次！
	 * 2.有了Class的实例以后，我们才可以进行如下的操作：
	 * 	1）创建对应的运行时类的对象
	 * 	2）获取对应的运行时类的完整结构（属性、方法、构造器、内部类、父类、所在的包、异常、注解、...）
	 * 	3）调用对应的运行时类的指定的结构(属性、方法、构造器)
	 * 	4）反射的应用：动态代理
	 */
	@Test
	public void test2(){
		Person p = new Person();
		Class clazz = p.getClass();	//通过运行时类的对象，调用其getClass()，返回其运行时类。
		System.out.println(clazz);	//class com.cxq.java.reflection.bean.Person
	}
	
	/**
	 * 获取Class的实例（4种）
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void test3() throws ClassNotFoundException{
		//1.调用运行时类本身的.class属性
		Class clazz1 = Person.class;
		System.out.println("clazz1:" + clazz1.getName());
		
		//2.通过运行时类的对象获取
		Person p = new Person();
		Class clazz2 = p.getClass();
		System.out.println("clazz2:" + clazz2.getName());
		
		//3.通过Class的静态方法forName获取（反射的动态性）
		String className = "com.cxq.java.reflection.bean.Person";
		Class clazz3 = Class.forName(className);
		System.out.println("clazz3:" + clazz3.getName());
		
		//4.通过类的加载器
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz4 = classLoader.loadClass(className);
		System.out.println("clazz4:" + clazz4.getName());
	}
	
	/**
	 * 使用类加载器获取文件信息
	 * @throws Exception 
	 */
	@Test
	public void test4() throws Exception{
		//1.文件在包中
		String fileName = "com/cxq/java/reflection/aboutClass/jdbc.properties";
		ClassLoader classLoader = this.getClass().getClassLoader();
//		InputStream  is = classLoader.getResourceAsStream(fileName);
		//2.文件在项目中
//		FileInputStream is = new FileInputStream(new File("jdbc.properties"));
		FileInputStream is = new FileInputStream(new File("src/com/cxq/java/reflection/aboutClass/jdbc.properties"));
		
		Properties pro = new Properties();
		pro.load(is);
		String name = pro.getProperty("name");
		String password = pro.getProperty("password");
		System.out.println(name);
		System.out.println(password);
	}
}

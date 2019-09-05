package com.cxq.java.jvm.classload;

/**
 * @author 8000654471
 * @desc 类加载顺序
 * @date 2019/9/4 9:11
 */
public class ClassLoadTest {

    //准备阶段，初始化为 null，初始化阶段调用构造器
    private static ClassLoadTest sington = new ClassLoadTest();

    //准备阶段赋值为 0
    private static int x;
    private static int y = 0;   //初始化阶段赋值为0，即 1 -> 0

    private ClassLoadTest(){
        x ++;
        y ++;
    }

    public static void main(String[] args){
        //类加载顺序测试一
        //x = 1, y = 0
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("------------------");

        //类加载顺序测试二
        ClassLoadTest test = new ClassLoadTest();
        Dog dog = new Dog();
        System.out.println("------------------");

        Animal animal = new Animal();
        test.override("dog",dog);
        test.override("animal",animal);

    }

    public void override(String name, Animal animal){
        System.out.println("Animal:" + name);
        System.out.println(animal);
    }

    public void override(String name, Dog dog){
        System.out.println("Dog:" + name);
        System.out.println(dog);
    }


}

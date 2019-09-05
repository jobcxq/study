package com.cxq.javaSE.jvm.classload;

/**
 * @author 8000654471
 * @desc 类加载顺序
 * @date 2019/9/4 9:11
 */
public class ClassLoadTest {


    public static void main(String[] args){
        ClassLoadTest test = new ClassLoadTest();
        Dog dog = new Dog();
        Animal animal = new Animal();
        System.out.println(dog);
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

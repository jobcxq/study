package com.cxq.javaSE.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author 8000654471
 * @desc 原子更新字段类
 * @date 2019/6/28 9:10
 */
public class AtomicIntegerFieldUpdaterTest {

    //AtomicIntegerFieldUpdater 为抽象类，需要使用静态方法 newUpdater 来创建更新器
    //必须使用 public volatile 来修饰需要更新的字段
    static AtomicIntegerFieldUpdater<Animal> updater = AtomicIntegerFieldUpdater.newUpdater(Animal.class,"age");

    public static void main(String[] args){

        Animal animal = new Animal("dog",2);
        System.out.println(updater.getAndIncrement(animal));

        System.out.println(updater.get(animal));

        System.out.println(animal);


    }

}

class Animal {

    private String name;
    public volatile int age;    //更新的字段，必须使用 public volatile 修饰

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
package com.cxq.designPattern.singleton.hungry;

//饿汉模式，在类加载时就立即初始化，并创建单例对象
//优点：没有加任何的锁，执行效率高，线程安全；用户体验比懒汉式好
//缺点：类加载就初始化，浪费空间
public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry(){

    }

    public static Hungry getInstance(){
        return instance;
    }

}

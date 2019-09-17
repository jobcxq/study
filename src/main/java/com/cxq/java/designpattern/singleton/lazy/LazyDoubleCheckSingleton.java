package com.cxq.java.designpattern.singleton.lazy;

//懒汉模式：在用户使用时才初始化,线程安全
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance = null; //volatile 防止指令重排序

    private LazyDoubleCheckSingleton(){
    }

    //双重检查锁
    public static LazyDoubleCheckSingleton getInstance(){
        if(instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(instance == null){
                    instance = new LazyDoubleCheckSingleton(); //存在指令的重排序问题
                }
            }
        }
        return instance;
    }

}

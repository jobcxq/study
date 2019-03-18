package com.cxq.designPattern.singleton.lazy;

//懒汉模式：在用户使用时才初始化,线程安全
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton instance = null;

    private LazyDoubleCheckSingleton(){
    }

    //双重检查锁
    public static LazyDoubleCheckSingleton getInstance(){
        if(instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(instance == null){
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}

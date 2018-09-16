package com.cxq.designPattern.singleton.lazy;

//懒汉模式：在用户使用时才初始化,线程安全
public class LazyOne {

    private static LazyOne instance = null;

    private LazyOne(){
    }

    //效率比getInstance1高
    public static LazyOne getInstance(){
        if(instance == null){
            synchronized (LazyOne.class){
                if(instance == null){
                    instance = new LazyOne();
                }
            }
        }
        return instance;
    }

    public static synchronized LazyOne getInstance1(){
        if(instance == null){
            instance = new LazyOne();
        }
        return instance;
    }

}

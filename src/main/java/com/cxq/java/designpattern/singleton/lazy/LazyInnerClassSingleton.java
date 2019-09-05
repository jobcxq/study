package com.cxq.javaSE.designpattern.singleton.lazy;

//特点：在外部类被调用的时候内部类才会被加载
//内部类一定是要在方法调用之前初始化
//巧妙地避免了线程安全问题

//这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
//完美地屏蔽了这两个缺点
//史上最牛B的单例模式的实现方式
public class LazyInnerClassSingleton {

    private static boolean initialized = false;

    //存在反射的入侵，通过反射会创建多个不同的对象
//    private LazyInnerClassSingleton(){
//
//    }
    private LazyInnerClassSingleton(){
        synchronized (LazyInnerClassSingleton.class){
            if(!initialized){
                initialized  = true;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    //static 是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.instance;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }

}

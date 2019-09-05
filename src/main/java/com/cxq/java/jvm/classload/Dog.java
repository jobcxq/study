package com.cxq.java.jvm.classload;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/4 9:16
 */
public class Dog extends Animal {

    static {
        System.out.println("Dog 静态代码块");
    }

    {
        System.out.println(this);
        System.out.println("Dog 构造器前代码块");
    }


    Dog(){
        System.out.println("Dog 构造器");
    }


    {
        System.out.println("Dog 构造器后代码块 B");
    }

}

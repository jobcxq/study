package com.cxq.java.jvm.classload;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/4 9:16
 */
public class Dog extends Animal {


    static Eye leftEye = new Eye("Dog's Left Eye"); //4

    static {
        System.out.println("Dog 静态代码块");    //5
    }

    static Eye rightEye = new Eye("Dog's Right Eye");   //6

    {
        System.out.println("Dog 构造器前代码块 A");    //10
    }


    Dog(){
        System.out.println("Dog 构造器");
    }   //12


    {
        System.out.println("Dog 构造器后代码块 B");    //11
    }

}

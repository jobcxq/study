package com.cxq.java.jvm.classload;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/4 9:11
 */
public class Animal {

    static Eye leftEye = new Eye("Animal's Left Eye"); //1

    static {
        System.out.println("Animal 静态代码块"); //2 初始化阶段执行
    }

    static Eye rightEye = new Eye("Animal's Left Eye"); //3

    {
        System.out.println("Animal 构造器前代码块 A");   //7
    }


    Animal(){
        System.out.println("Animal 构造器");
    }   //9


    {
        System.out.println("Animal 构造器后代码块 B"); //8
    }



}

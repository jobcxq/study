package com.cxq.javaSE.jvm;

/**
 * @author 8000654471
 * @desc
 * @date 2019/9/4 9:11
 */
public class Animal {

    static {
        System.out.println("Animal 静态代码块");
    }

    {
        System.out.println(this);
        System.out.println("Animal 构造器前代码块");
    }


    Animal(){
        System.out.println("Animal 构造器");
    }


    {
        System.out.println("Animal 构造器后代码块 B");
    }



}

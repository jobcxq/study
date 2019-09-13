package com.cxq.java.base;

import java.lang.reflect.Method;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/12 23:54
 */
public class FinalTest extends Parent{

    protected static String hello = "FinalTest";

    static void say(String str){
        System.out.println("FinalTest:" + str);
    }

    public static void main(String[] args){

        FinalTest test = new FinalTest();
        System.out.println(Parent.hello);
        System.out.println(test.hello);

        String str = "3435dsdgh454";
        System.out.println(Integer.parseInt(str));

    }

}

class Parent{

    protected static String hello ="Parent";
    static void say(String str){
        System.out.println("Parent:" + str);
    }

}

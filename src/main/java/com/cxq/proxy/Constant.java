package com.cxq.proxy;

public class Constant {

    public static void before() {
        System.out.println("before update user!");
    }


    public static void after() {
        System.out.println("after update user!");
    }

}

package com.cxq.java.jvm.classload;

/**
 * @author 8000654471
 * @desc
 * @date 2020/4/16 15:47
 */
public class Bike {

    public static Bike bike1=new Bike();
    public static Bike bike2=new Bike();

    {
        System.out.println("动态代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        new Bike();
    }

}

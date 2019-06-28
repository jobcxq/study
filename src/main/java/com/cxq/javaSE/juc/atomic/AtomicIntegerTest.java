package com.cxq.javaSE.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args){
        System.out.println(atomicInteger.get());                //1
        System.out.println(atomicInteger.addAndGet(8));  //9
        System.out.println(atomicInteger.getAndAdd(9));  //9  返回旧值
        System.out.println(atomicInteger.getAndIncrement());    //18 返回旧值
        System.out.println(atomicInteger.get());                //19
    }

}

package com.cxq.java.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author 8000654471
 * @desc
 * @date 2019/6/28 9:02
 */
public class AtomicIntegerArrayTest {

    static int [] value = new int[]{10,20};

    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);   //复制一份数组的值：array.clone();

    public static void main(String[] args){
        System.out.println(atomicIntegerArray.getAndAdd(0,5));
        System.out.println(atomicIntegerArray.get(0));

        System.out.println(value[0]);   //不影响传入的数组的值

    }

}

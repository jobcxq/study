package com.cxq.java.thread;

import com.cxq.java.vo.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/08 23:16
 */
public class ThreadLocalTest {

//    private static int num = 0;

    static ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;   //初始值，若是对象的引用，仍引用的同一个对象。
        }
    };

    static ThreadLocal<Integer> num2 = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 3;   //初始值，若是对象的引用，仍引用的同一个对象。
        }
    };

    static ThreadLocal<User> use = new ThreadLocal<User>(){
        @Override
        protected User initialValue() {
            return new User(1l, "threadlocal","tl");//需要重新 new 一个对象
        }
    };

    public static void main(String[] args){

        for(int i = 0; i < 5; i ++) {
            new Thread(() -> {
                int value = num.get() + 5;num.set(33);use.set(null);
                System.out.println(Thread.currentThread().getName() + " : " + value);
                System.out.println(Thread.currentThread().getName() + " : " + use.get());
            }, "thread" + i).start();
        }

    }

}

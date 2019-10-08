package com.cxq.java.thread;

import com.cxq.java.vo.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/08 23:16
 */
public class ThreadLocalTest {

//    private static int num = 0;

    static ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;   //初始值，若是对象的引用，仍引用的同一个对象。
        }
    };

    static ThreadLocal<User> use = new ThreadLocal<User>() {
        @Override
        protected User initialValue() {
            return new User(1l, "threadlocal", "tl");//需要重新 new 一个对象
        }
    };

    // 原子性整数，包含下一个分配的线程Thread ID
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // 每一个线程对应的Thread ID
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int value = num.get() + 5;
                System.out.println(Thread.currentThread().getName() + " : " + value);
//                System.out.println(Thread.currentThread().getName() + " : " + use.get());
                System.out.println(Thread.currentThread().getName() + " threadId : " + threadId.get());
            }, "thread" + i).start();
        }

        num.set(100);
        System.out.println(Thread.currentThread().getName() + " : " + num.get());

    }

}

package com.cxq.java.juc.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author cnxqin
 * @desc CountDownLatch
 * @date 2019/06/12 21:34
 */
public class CountDownLatchTest {

    public static void main(String[] args){
//        countDown();
        concurrency();
    }


    /**
     * 模拟并发场景，多个线程等待同一信号后，同时被唤醒执行（实际按入队顺序唤醒）
     */
    public static void concurrency(){
        CountDownLatch countDownLatch = new CountDownLatch(1);  //计数器的初始值

        for(int i = 0; i < 1000; i ++){
            new Thread(() -> {
                try {
                    countDownLatch.await(); //等待计数器的值为0时，再继续执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }).start();
        }

        System.out.println("==========Ready==========");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();     //计数器值减1，唤醒所有等待线程
        System.out.println("===========Go============");

    }


    /**
     * 模拟主线程等待其他所有线程达到某一状态后再继续执行
     */
    public static void countDown(){

        CountDownLatch countDownLatch = new CountDownLatch(3);  //计数器的初始值

        new Thread(() -> {
            System.out.println("线程1正在执行");
            countDownLatch.countDown();     //计数器就减一

            System.out.println("线程1执行完成");}).start();

        new Thread(() -> {
            System.out.println("线程2正在执行");
            countDownLatch.countDown();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行完成");}).start();

        new Thread(() -> {
            System.out.println("线程3正在执行");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("线程3执行完成");}).start();

        try {
            countDownLatch.await(); //使主线程阻塞，待计数器值为0时继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The End!");
    }

}

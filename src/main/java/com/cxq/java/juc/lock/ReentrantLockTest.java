package com.cxq.java.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cnxqin
 * @desc 重入锁
 * @date 2019/06/05 22:35
 */
public class ReentrantLockTest {

    static Lock lock = new ReentrantLock();

    static int count = 0;

    public static void inc(){
        lock.lock();
        count ++;
        lock.unlock();
    }

    public static void main(String[] args){
        for(int i = 0; i < 1000; i ++){
            new Thread(() -> ReentrantLockTest.inc()).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + count);

    }
}

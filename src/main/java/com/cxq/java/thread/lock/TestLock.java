package com.cxq.java.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    //定义锁对象
    private final ReentrantLock lock = new ReentrantLock();

    //定义需要保证线程安全的方法
    public void method(){
        //加锁
        lock.lock();
        try{
            //...需要保证线程安全的代码
        }finally {
            //使用finally来保证释放锁
            lock.unlock();
        }
    }
}

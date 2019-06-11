package com.cxq.javaSE.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author cnxqin
 * @desc Condition简单测试
 * @date 2019/06/09 23:18
 */
public class ConditionWait implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            try {
                System.out.println("begin ConditionWait");
                condition.await();
                System.out.println("end ConditionWait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }finally {
            lock.unlock();
        }
    }
}

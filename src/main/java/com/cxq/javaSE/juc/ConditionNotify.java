package com.cxq.javaSE.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author cnxqin
 * @desc Condition简单测试
 * @date 2019/06/09 23:20
 */
public class ConditionNotify implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("begin ConditionNotify");
//            condition.notify();   java.lang.IllegalMonitorStateException
            condition.signal();
            System.out.println("end ConditionNotify");
        }finally {
            lock.unlock();
        }
    }
}

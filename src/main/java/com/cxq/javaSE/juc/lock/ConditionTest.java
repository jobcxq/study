package com.cxq.javaSE.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cnxqin
 * @desc Condition简单测试
 * @date 2019/06/09 23:22
 */
public class ConditionTest {

    public static void main(String[] args){

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new ConditionWait(lock,condition)).start();
        new Thread(new ConditionNotify(lock,condition)).start();

    }

}

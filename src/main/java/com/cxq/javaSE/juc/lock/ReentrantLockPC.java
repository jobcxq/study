package com.cxq.javaSE.juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cnxqin
 * @desc 生产者消费者模式
 * @date 2019/06/11 22:51
 */
public class ReentrantLockPC {

    public final static int ARRAY_SIZE = 20;

    public static void main(String[] args){

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        List<String> list = new ArrayList();

        Thread producer = new Thread(new Producer(lock,condition,list));
        Thread consumer = new Thread(new Consumer(lock,condition,list));
        producer.start();
        consumer.start();

    }

    static class Producer implements Runnable{
        private Lock lock;
        private Condition condition;
        private List<String> list;

        public Producer(Lock lock, Condition condition,List<String> list) {
            this.lock = lock;
            this.condition = condition;
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == ARRAY_SIZE) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    put();
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        private void put(){
            String str = UUID.randomUUID().toString()
                    .replace("-","").substring(0,5);
            list.add(str);
            System.out.println("***add str : " + str + ", size = " + list.size());
        }
    }

    static class Consumer implements Runnable{
        private Lock lock;
        private Condition condition;
        private List<String> list;

        public Consumer(Lock lock, Condition condition,List<String> list) {
            this.lock = lock;
            this.condition = condition;
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    try {
                        Thread.currentThread().sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 0) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    take();
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        private void take(){
            String str = list.remove(0);
            System.out.println("remove str : " + str + ", size = " + list.size());
        }
    }

}

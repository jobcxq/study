package com.cxq.java.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author cnxqin
 * @desc 读写重入锁，写操作时，其他线程操作阻塞
 * @date 2019/06/05 22:41
 */
public class ReentrantReadWriteLockTest {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    static Map map = new HashMap();
    static int cocunt = 0;

    public static void read(String key){
        readLock.lock();
        try {
            System.out.println("读操作获取锁，执行读取操作：" + (String) map.get(key));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("**********读操作结束**********\n");
            readLock.unlock();
        }
    }

    public static void write(String key, String value){
        writeLock.lock();
        try{
            System.out.println("写操作获得锁，写入值：" + value);
            map.put(key,value);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("==========写操作结束==========\n");
            writeLock.unlock();
        }
    }

    public static void main(String[] args){
        for(int i = 0; i < 1000 ; i ++){
            new Thread(() -> {
                ReentrantReadWriteLockTest.write("key","value" + " : " + (cocunt ++));
            }).start();

            new Thread(() -> {
                ReentrantReadWriteLockTest.read("key");
            }).start();
        }
    }

}

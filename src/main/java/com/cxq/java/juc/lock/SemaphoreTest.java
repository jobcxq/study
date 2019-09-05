package com.cxq.java.juc.lock;

import java.util.concurrent.Semaphore;

/**
 * @author cnxqin
 * @desc Semaphore 限流测试，模拟停车位
 * @date 2019/06/12 22:05
 */
public class SemaphoreTest {

    public final static int PARKING_NUM = 5;    //定义许可（停车位）数量

    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(PARKING_NUM); //  初始化 5 个许可证

        for(int i = 0 ; i < 10 ; i ++){
            new Thread(new Car(semaphore,i)).start();
        }
    }


}

//模拟商场停车位
class Car implements Runnable{

    Semaphore semaphore;
    int num;

    public Car(Semaphore semaphore, int num) {
        this.semaphore = semaphore;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Car [" + num + "] acquired, begin shopping...");
            Thread.sleep(2000);
            System.out.println("Car [" + num + "] released!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

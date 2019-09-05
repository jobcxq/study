package com.cxq.java.juc.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author cnxqin
 * @desc CyclicBarrier
 * @date 2019/06/12 22:21
 */
public class CyclicBarrierTest {

    public static void main(String[] args){
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        Thread barrier = new Thread(() -> { System.out.println("cyclicBarrier"); });    //最后到达阻塞点
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,barrier);

        for(int i = 0; i < 5 ; i ++){
            new Thread(new CyclicBarrierThread(cyclicBarrier)).start();
        }
        System.out.println("The End!");

    }

}

class CyclicBarrierThread implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ：执行业务逻辑，执行完成后，阻塞...");
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " ：继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

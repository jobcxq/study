package com.cxq.java.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 17:58
 */
public class ThreadPoolTest {
    public static void main(String[] args){

        ScheduledExecutorService scheduledExecutorService =  Executors.newScheduledThreadPool(5);


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}

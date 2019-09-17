package com.cxq.java.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/15 18:10
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        queue.add("123");
        queue.put("1234");
        queue.poll();
        queue.remove("123");
    }

}

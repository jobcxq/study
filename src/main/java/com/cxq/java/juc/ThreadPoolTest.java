package com.cxq.java.juc;

import com.sun.org.apache.xpath.internal.functions.FuncTrue;

import java.util.concurrent.*;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 17:58
 */
public class ThreadPoolTest {
    public static void main(String[] args){

        MyRunnable runnable = new MyRunnable();
        MyCallable callable = new MyCallable();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future f1 = executorService.submit(runnable);
        Future<String> f2 = executorService.submit(callable);
        try {
            System.out.println("Runnable:" + f1.get());
            System.out.println("Callable:" + f2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("shutdown");
        executorService.shutdown(); //使用完成后必须调用 shutdown 方法关闭线程池
        System.out.println("ok");
    }
}

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("MyCallable");
        Thread.sleep(5000);
        return "success";
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {

        try {
            System.out.println("MyRunnable");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.cxq.java.thread.callable;

import java.util.concurrent.*;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return String.valueOf(1 + 2);
    }

    public static void main(String[] args){
        MyCallable callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
//        try {
//            new Thread(futureTask).start();
//            String result = futureTask.get(1000,TimeUnit.MILLISECONDS);
//            System.out.println("result = " + result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            System.out.println("time out");
//            e.printStackTrace();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Future future = executorService.submit(callable);
        executorService.execute(() -> {});
        try {
            String result = (String) future.get();
            System.out.println("result = " + result + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

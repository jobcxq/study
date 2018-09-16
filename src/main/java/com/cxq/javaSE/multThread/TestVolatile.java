package com.cxq.javaSE.multThread;

public class TestVolatile {

    volatile boolean stop = false;
//    boolean stop = false;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final TestVolatile test = new TestVolatile();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(System.currentTimeMillis() + " before if stop=" + test.stop);
                    if(!test.stop)
                        System.out.println(System.currentTimeMillis() + " stop=" + test.stop);
                    else
                        break;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(500);
            System.out.println(startTime + " [start time]");
            System.out.println(System.currentTimeMillis() + " ============" + "stop=" + test.stop);
            test.stop = true;
            System.out.println(System.currentTimeMillis() + " ============" + "stop=" + test.stop);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

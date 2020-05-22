package com.cxq.java.thread;

/**
 * @author cnxqin
 * @desc 三个线程交替打印 A B C 10次
 * @date 2019/12/23 21:01
 */
public class ThreadPrint {

    static Object object = new Object();

    static String flag = "A";

    public static void main(String[] args){


        Thread threadA = new Thread(new ThreadA(),"ThreadA");
        Thread threadB = new Thread(new ThreadB(),"ThreadB");
        Thread threadC = new Thread(new ThreadC(),"ThreadC");

        threadA.start();
        threadB.start();
        threadC.start();
    }


    static class ThreadA implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 10; i ++){
                boolean hasPrint = false;
                while(!hasPrint) {
                    synchronized (object) {
//                        System.out.println("ThreadA");
                        if (!"A".equals(flag)) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.print("A ");
                            hasPrint = true;
                            flag = "B";
                            object.notifyAll();
                        }
                    }
                }
            }
        }

    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 10; i ++){
                boolean hasPrint = false;
                while(!hasPrint) {
                    synchronized (object) {
//                        System.out.println("ThreadB");
                        if (!"B".equals(flag)) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.print("B ");
                            hasPrint = true;
                            flag = "C";
                            object.notifyAll();
                        }
                    }
                }
            }
        }
    }

    static class ThreadC implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 10; i ++){
                boolean hasPrint = false;
                while(!hasPrint) {
                    synchronized (object) {
//                        System.out.println("ThreadC");
                        if (!"C".equals(flag)) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.print("C ");
                            hasPrint = true;
                            flag = "A";
                            object.notifyAll();
                        }
                    }
                }
            }
        }
    }

}



package com.cxq.java.ftp;

/**
 * @author cnxqin
 * @desc
 * @date 2020/06/10 19:44
 */
public class FTPTest {

    public static void main(String[] args){

        FTPThread ftpThread = new FTPThread();
        new Thread(ftpThread,"thread1").start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(ftpThread,"thread2").start();
    }

}

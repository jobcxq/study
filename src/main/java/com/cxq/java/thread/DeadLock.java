package com.cxq.java.thread;

public class DeadLock {

	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();

	public static void main(String[] args) {
		new Thread("thread1") {
			public void run() {
				synchronized (sb1) {
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sb1.append("A");
					synchronized (sb2) {
						System.out.println("thread1 b2");
						sb2.append("B");
						System.out.println(Thread.currentThread().getName() + " : " + sb1);
						System.out.println(Thread.currentThread().getName() + " : " + sb2);
					}
				}
			}
		}.start();
		new Thread("thread2") {
			public void run() {
				synchronized (sb2) {
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sb1.append("C");
					synchronized (sb1) {
						System.out.println("thread2 b1");
						sb2.append("D");
						System.out.println(Thread.currentThread().getName() + " : " + sb1);
						System.out.println(Thread.currentThread().getName() + " : " + sb2);
					}
				}
			}
		}.start();
	}

}

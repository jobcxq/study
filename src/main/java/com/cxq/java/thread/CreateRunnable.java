package com.cxq.java.thread;
/*
 * 使用实现Runnable接口的方式，售票
 * 此程序存在线程的安全问题：打印车票时，会出现重票、错票
 */
public class CreateRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableWindow w = new RunnableWindow();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class RunnableWindow implements Runnable{
	int ticket = 100;

	public void run() {
		while (true) {
			show();
		}
	}
	
	public synchronized void show(){
		if (ticket > 0) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "售票，票号为："
					+ ticket--);
		} 
//		else {
//			break;
//		}
	}
}

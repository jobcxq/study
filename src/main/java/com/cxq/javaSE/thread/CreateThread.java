package com.cxq.javaSE.multThread;

/*
 * 模拟火车站售票窗口，开启三个窗口售票，总票数为100张
 * 存在线程的安全问题
 */
public class CreateThread {

	public static void main(String[] args) {
		ThreadWindow w1 = new ThreadWindow();
		ThreadWindow w2 = new ThreadWindow();
		ThreadWindow w3 = new ThreadWindow();
		
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");
		
		w1.start();
		w2.start();
		w3.start();
	}
}

class ThreadWindow extends Thread{
	static int ticket = 100;
	Object obj = new Object();
		public void run() {
			while (true) {
				synchronized(obj){
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票，票号为："
							+ ticket--);
				} else {
					break;
				}
			}
		}
	}
}

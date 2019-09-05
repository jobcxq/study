package com.cxq.javaSE.multThread;

public class Communication {

	/**
	 * 使用两个线程打印 1-100. 线程1, 线程2 交替打印
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintNum printNum = new PrintNum();

		Thread td1 = new Thread(printNum);
		Thread td2 = new Thread(printNum);

		td1.start();
		td2.start();
	}

}

class PrintNum implements Runnable {
	int num = 0;
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				this.notify(); //唤醒其他优先级高的线程。
				if (num < 100)
					System.out.println(Thread.currentThread().getName() + ":" + ( ++ num));
				else
					return;
				try {
					wait(); // 挂起当前线程。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

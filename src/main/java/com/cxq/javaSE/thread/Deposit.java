package com.cxq.javaSE.multThread;

public class Deposit {

	/**
	 * 银行有一个账户。
	 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepositOperation depositOperation = new DepositOperation();
		
		Thread td1 = new Thread(depositOperation);
		td1.setName("账户1");
		Thread td2 = new Thread(depositOperation);
		td2.setName("账户2");
		td1.start();
		td2.start();
	}
	
	

}

class DepositOperation implements Runnable{
	
	int count = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i++){
			synchronized (this) {
				count += 1000;
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ",	账户余额:" + count + "元");
			}
		}
	}
}
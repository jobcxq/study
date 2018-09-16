package com.cxq.javaSE.multThread;
class Clerk{
	int product;
	
	public synchronized void addProduct(){
		if(product >= 20){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			product++;
			System.out.println(Thread.currentThread().getName() + ":生产第" + product + "件产品");
			notifyAll();
		}
	}
	public synchronized void consumeProduct(){
		if(product <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + ":消费第" + product + "件产品");
			product--;
			notifyAll();
		}
	}
}

class Producer implements Runnable{
	Clerk clerk;
	
	public Producer(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("生产者开始生产产品");
		while(true){
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.addProduct();
			
		}
	}
}
class Consumer implements Runnable{
	Clerk clerk;
	public Consumer(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("消费者开始消费产品");
		while(true){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}
	}
}


public class TestProduceConsume {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Consumer c1 = new Consumer(clerk);
		Thread t1 = new Thread(p1);
		Thread t3 = new Thread(p1);
		Thread t2 = new Thread(c1);
		
		t1.setName("生产者1");
		t2.setName("消费者1");
		t3.setName("生产者2");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

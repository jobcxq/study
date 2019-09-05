package com.cxq.javaSE.multThread;

public class ProductorAndCustomer {

	/**
	 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品。
	 * 店员一次只能持有固定数量的产品(比如:20）。 如果生产者试图生产更多的产品，店员会叫生产者停一下；如果店中有空位放产品了再通知生产者继续生产；
	 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods goods = new Goods(0);

		Productor productor = new Productor(goods);
		Customer customer = new Customer(goods);

		Thread pro = new Thread(productor);
		Thread cus = new Thread(customer);

		pro.start();
		cus.start();
	}

}

class Productor implements Runnable {

	Goods goods;

	public Productor(Goods goods) {
		super();
		this.goods = goods;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// synchronized(goods){
			// if(goods.getNum() < 20){
			// notify();
			goods.add();
			// System.out.println("生产者生产一件商品，商品剩余：" + goods.getNum());
			// }else{
			// System.out.println("商品数量过剩，请停止生产！");
			// try {
			// wait();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
			// }
		}
	}
}

class Customer implements Runnable {
	Goods goods;

	public Customer(Goods goods) {
		super();
		this.goods = goods;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// synchronized (goods) {
			// if (goods.getNum() > 0) {
			// notify();
			goods.delete();
			// System.out.println("消费者消费一件商品，商品剩余:" + goods.getNum());
			// } else {
			// try {
			// System.out.println("商品数量不足，请等待！");
			// wait();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
			// }
		}
	}
}

class Goods {
	private int num;

	public Goods(int num) {
		super();
		this.num = num;
	}

	public void add() {
		synchronized (this) {
			if (num < 20) {
				this.num++;
				notify();
				System.out.println("生产者生产一件商品，商品剩余：" + num);
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void delete() {
		if (num > 0) {
			this.num--;
			notify();
			System.out.println("消费者消费一件商品，商品剩余：" + this.num);
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

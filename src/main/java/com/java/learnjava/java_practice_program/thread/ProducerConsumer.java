package com.java.learnjava.java_practice_program.thread;

class Company {
	int n;
	boolean f = false;

synchronized	public void produceItem(int n) throws InterruptedException {

		if (f) {
			wait();
		}

		this.n = n;
		System.out.println("Produced : " + this.n);
		f = true;
		notify();
	}

synchronized public int consumeItem() throws InterruptedException {
		if (!f) {
			wait();
		}
		System.out.println("consumed item = : " + this.n);

		f = false;
		notify();

		return this.n;

	}
}

class Producer extends Thread {

	Company c;

	public Producer(Company c) {
		this.c = c;
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {

			try {
				c.produceItem(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			i++;
		}
	}
}

class Consumer extends Thread {
	Company c;

	Consumer(Company c) {
		this.c = c;
	}

	@Override
	public void run() {
		while (true) {

			try {
				c.consumeItem();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		Company c = new Company();

		Producer p = new Producer(c);
		Consumer consumer = new Consumer(c);

		p.start();
		consumer.start();

	}

}

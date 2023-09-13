package com.java.learnjava.programs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BlockingQueue<E> {

	private Queue<E> queue;
	private int max = 16;

	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	BlockingQueue(int size) {

		queue = new LinkedList<>();
		this.max = size;

	}

	public void put(E e) throws InterruptedException {
		lock.lock();
		try {
			if(queue.size()==max) {
				notFull.await();
			}
			queue.add(e);
			notFull.signal();
		} finally {

			lock.unlock();
		}

	}

	public E take() throws InterruptedException {
		lock.lock();
		try {
			if (queue.size() == 0)
				notEmpty.await();
			E item = queue.remove();
			notEmpty.signal();
			return item;
		} finally {

			lock.unlock();
		}
	}

}


class Sender{
	private String message;
	
	public void send(String message) throws InterruptedException {
		System.out.println("sending message" + message);
		
		
		Thread.sleep(1000);
		System.out.println("Sent" + message);

		
		
		
	}
}

class SenderThread extends Thread{
	private String mess;
	Sender sender;
	
	SenderThread(String mess, Sender obj){
		this.mess = mess;
		sender =obj;
	}
	public  void run() {
		synchronized(sender) {
			try {
				sender.send(mess);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class ProducerAndConsumer {

	public static void main() throws InterruptedException {
		
		Sender sender = new Sender();
		
		SenderThread t1 = new SenderThread("Hi", sender);
		SenderThread t2 = new SenderThread("BY", sender);
t1.start();
t2.start();

t1.join();
t2.join();
		
HashMap<String, Integer> employee = new HashMap<>();
employee.put("mukesh",30);

/*hashcode =118
index =6
it will create 

int hashcode 
Key
value
Node next = null
*/
		





		System.out.println("hello");
	}
}

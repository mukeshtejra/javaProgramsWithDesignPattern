package com.java.learnjava.java_practice_program.thread;



class MyThread  implements Runnable{
	
	public void run() {
		
	}
}

class CustomThread extends Thread{
	
	public void run() {
		
	}
}



public class ThreadTest {
	
	
	public static int test() {
		try {
			
			int a = 30/0;
			return 1;
			
		}catch(Exception e) {
			return 2;
		}finally{
			//return 3;
		}
	}
	
	
	public static void main(String args[]) {
		System.out.println(ThreadTest.test());
		
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		
		
		//using Runnable
		MyThread obj = new MyThread();
		Thread t1 = new Thread(obj);
		t1.start();
		
		//using thread class
		CustomThread  t3 = new CustomThread();
		t3.start();
		
		
		
		
		
		
		
		
				
	}
}

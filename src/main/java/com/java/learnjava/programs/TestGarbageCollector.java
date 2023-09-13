package com.java.learnjava.programs;


public class TestGarbageCollector {

	@Override
	public void finalize() {
		System.out.println("invoked before the object garbage collected ");
	}
	
	public static void main() {
		TestGarbageCollector t1 = new TestGarbageCollector();
		TestGarbageCollector t2 = new TestGarbageCollector();
		
		t1=null;
		t2=null;
		System.gc();
		
		TestGarbageCollector t3 = new TestGarbageCollector();
		TestGarbageCollector t4 = new TestGarbageCollector();

		t3 = null;
		t2 = null;
		System.gc();
		

		
				
	}
}
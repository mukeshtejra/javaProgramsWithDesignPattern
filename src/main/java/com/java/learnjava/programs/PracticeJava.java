package com.java.learnjava.programs;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

enum Color {
	RED, BLACK;

	public static void main(String args[]) {

		C t = new C();
		t.show();

	}
}

class TestProgram {

	public synchronized void print(String message) {
		synchronized (message) {

		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Hello message = " + message + "thread id = " + Thread.currentThread().getId());
		}
	}
}

class ThreadExample extends Thread {

	TestProgram t;
	String message;

	ThreadExample(String message, TestProgram obj) {
		this.message = message;
		this.t = obj;
	}

	@Override
	public void run() {
		t.print(message);
	}

}

class Serial implements Serializable {

}

class MyException extends RuntimeException {
	MyException(String s) {
		super(s);
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Thread = " + Thread.currentThread().getId());
	}
}

class Task implements Callable<String> {

	private String message;

	Task(String message) {
		this.message = message;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Hi" + message;
	}

}

public class PracticeJava implements Cloneable {

	/*
	 * @Override public void show() { System.out.println(" PracticeJava "); }
	 */

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();

	}

	@Override
	public void finalize() {
		System.out.println("invoked before the object garbage collected ");
	}

	public void sum(int a, int b) {
		System.out.println("primitive");
	}

	public void sum(Integer a, Integer b) {
		System.out.println("Wrapper");
	}

	public static void main(String args[]) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, CloneNotSupportedException, IOException {

		// each char count
		Map<Character, Integer> countMap = new HashMap<>();
		String str = "abaacd";
		for (int i = 0; i < str.length(); i++) {
			if (countMap.containsKey(str.charAt(i))) {
				countMap.put(str.charAt(i), countMap.get(str.charAt(i)) + 1);
			} else {
				countMap.put(str.charAt(i), 1);
			}

		}

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "mukesh");
		map.put(2, "mukesh");
		map.put(3, "mukesh");
		map.put(null, null);
		map.put(null, null);

		for (Map.Entry<Integer, String> item : map.entrySet()) {
			System.out.println(item.getKey());
			// map.put(4, "Rakesh");
		}

		/*
		 * Iterator iterator = map.keySet().iterator();
		 * 
		 * while(iterator.hasNext()) { System.out.println(map.get(iterator.next()));
		 * map.put(4, "Rakesh");
		 * 
		 * 
		 * 
		 * }
		 */

		ThreadExample obj1 = new ThreadExample("Mukesh", new TestProgram());
		ThreadExample obj2 = new ThreadExample("Rakesh", new TestProgram());

		obj1.start();
		obj2.start();
		System.out.println("end thread");

		synchronized (PracticeJava.class) {

		}

		Thread tt = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});

		Runnable runnable = () -> {

		};

		// Producer and consumer
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

		Runnable producer = () -> {
			while (true) {
				try {
					queue.put(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(producer).start();
		new Thread(producer).start();

		Runnable consumer = () -> {
			while (true) {
				try {
					int i = queue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		// Tread class Runnable task
		MyThread t1 = new MyThread();
		t1.start();

		Task task = new Task("Geeks");

		// Executors -
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		// submit accept submit task
		List<Future> futureList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Future<String> result = executorService.submit(task);
			futureList.add(result);

		}
		// Execute accept runnable task
		executorService.execute(t1);

		try {
			for (int i = 0; i < 100; i++) {
				Future<String> result = futureList.get(i);
				result.get(); // it will block the main thread until result gets stored in future object. so
								// we need to be very careful.
				// we can use timeout in this case
			}

		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}

		Runnable runnableThread = () -> {
			for (int i = 0; i < 1000; i++)
				System.out.println("Thread = " + Thread.currentThread().getId() + i);

		};

		Runnable runnableThread1 = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++)
					System.out.println("Thread = " + Thread.currentThread().getId() + i);

			}

		};

		Thread obj4 = new Thread(runnableThread);
		obj4.start();

		try {
			throw new MyException("geeks");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		int a = 5;
		int b = 0;

		try {
			System.out.print(a / b);
			throw new NullPointerException("test");
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		/*
		 * Serial objSerail = new Serial(); FileOutputStream file = new
		 * FileOutputStream("test.txt"); ObjectOutputStream obj = new
		 * ObjectOutputStream(file); obj.writeObject(objSerail);
		 */

		new PracticeJava().sum(10, 10);

		// Object

		// Object create using Class.forname
		// TestGarbageCollector tt = (TestGarbageCollector)
		// Class.forName("TestGarbageCollector").newInstance();

		// Using clone class must implement Clonable interace else would not work
		PracticeJava objectClone = (PracticeJava) new PracticeJava().clone();

		// using constructor.forname
		// TestGarbageCollector constrcutorForname =
		// TestGarbageCollector.class.getConstructor().newInstance();

		// using deserialization

		// TestGarbageCollector deserialzeObject = (TestGarbageCollector) is.

		C t = new C();
		t.show();

		Course1 course = new Course1(1, "AWS course", "AWS");
		Course1 course1 = new Course1(3, "AWS course", "AWS");
		Course1 course2 = new Course1(2, "AWS course", "AWS");

		System.out.println(new Course1().toString());

		System.out.println("end here");

		List<Course1> courses = List.of(course, course1, course2, new Course1(3, "AWS course", "AWS"));

		Map<String, String> map1 = new HashMap<>();

		System.out.println(map1.put("mukesh", "kumar"));

		System.out.println(map1.put("mukesh", "kumar1"));

		System.out.print("test = ");

		System.out.print(courses.stream().collect(Collectors.toSet()));

		courses.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Course1::getId))));

		System.gc();
		// courses.stream().distinct().map(obj -> obj.getName()).collect(null)

		// courses.stream().sorted(Comparator.comparing(Course1::getId)).limit(2).skip(1).col;
		// HashSet<Course1> list = new HashSet<>();
		// courses.removeIf(e -> !list.add(e.getId()));

		// courses.stream().filter(emp ->
		// list.add(emp.getId())).collect(Collectors.toList());

		// System.out.print(courses.stream().distinct().collect(Collectors.toList()));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		MultiValueMap<String, String> test = new LinkedMultiValueMap<>();
		test.set("email", "test@gmail.com");

		HttpEntity<MultiValueMap<String, String>> map2 = new HttpEntity<MultiValueMap<String, String>>(test, headers);
		// HttpEntity<T>

		// Http
		RestTemplate rest = new RestTemplate();
		// rest.postForEntity("test.com", map, headers);

		// HttpEntity<String>

		// rest.postForObject(url, request,return);

	}

	// RestTemplate rest = new RestTemplate();

	// HttpEntity<String> request = new HttpEntity<>(null)

}

interface A {
	default void show() {
		System.out.println("A interface");
	}
}

interface B {

	default void show() {
		System.out.println("B interface");
	}
}

class C implements A, B {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		A.super.show();
	}

}

interface P1 {
	default void show() {
		System.out.println("hello P1");
	}
}

interface P2 extends P1 {

}

interface P3 extends P2 {

}

class Test1 implements P1, P2, P3 {
	public static void main() {
		Test1 t = new Test1();
		t.show();
	}
}

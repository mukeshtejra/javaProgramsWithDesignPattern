package com.java.learnjava.prototype_design_pattern;

public class Main {

	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		Network obj = new Network();
		obj.setIp("12.13.14.15");
		System.out.println(" loading data");

		obj.loadImportantData();
		
		Network obj2 = (Network) obj.clone();
		System.out.println("clone object created");
	}
}

package com.java.learnjava.factorydesignpattern;

public class AndroidDeveloper implements Employee{

	@Override
	public int salary() {
		System.out.println("Getting Android developer salary");
		return 50000;
	}

}

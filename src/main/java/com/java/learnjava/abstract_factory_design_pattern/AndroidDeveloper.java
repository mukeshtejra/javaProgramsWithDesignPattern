package com.java.learnjava.abstract_factory_design_pattern;

public class AndroidDeveloper implements Employee{

	@Override
	public int salary() {
		System.out.println("Getting Android developer salary");
		return 50000;
	}

	@Override
	public String name() {
		System.out.println("I  am Android developer ");
		return "Android Developer";
	}
	
	

}

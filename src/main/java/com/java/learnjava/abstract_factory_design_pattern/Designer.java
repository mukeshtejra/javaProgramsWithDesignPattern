package com.java.learnjava.abstract_factory_design_pattern;

public class Designer implements Employee {

	@Override
	public int salary() {
		System.out.println("this is Designer salary");
		return 60000;
	}

	@Override
	public String name() {
		System.out.println("I am designer");
		return "Designer";
	}

}

package com.java.learnjava.abstract_factory_design_pattern;

public class WebDeveloper implements Employee {
	
	public int salary() {
		System.out.println("Getting web developer salary");
		return 40000;
	}

	@Override
	public String name() {
		System.out.println("I am  web developer ");
		return "Web Developer";
	}

}

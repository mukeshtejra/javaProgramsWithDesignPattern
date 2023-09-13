package com.java.learnjava.abstract_factory_design_pattern;

public class Client {

	public static void main(String args[]) {
		Employee employee = EmployeeFactory.getEmployee(new AndroidAbstractFactory());
		employee.salary();
	}
}

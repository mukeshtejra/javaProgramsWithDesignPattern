package com.java.learnjava.abstract_factory_design_pattern;

//based on input param we are going to return that type of object
public class EmployeeFactory {

	public static Employee getEmployee(EmployeeAbstractFactory employeeAbstractFactory) {
		return employeeAbstractFactory.createEmployee();
		
	}
}

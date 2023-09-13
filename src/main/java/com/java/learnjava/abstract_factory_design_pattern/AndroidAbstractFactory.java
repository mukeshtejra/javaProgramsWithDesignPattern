package com.java.learnjava.abstract_factory_design_pattern;

public class AndroidAbstractFactory extends EmployeeAbstractFactory {

	@Override
	public Employee createEmployee() {
		return new AndroidDeveloper();
	}

}

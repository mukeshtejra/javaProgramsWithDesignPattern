package com.java.learnjava.abstract_factory_design_pattern;

public class WebdeveloperAbstractFactory extends EmployeeAbstractFactory {

	@Override
	public Employee createEmployee() {
		return new WebDeveloper();
	}

}

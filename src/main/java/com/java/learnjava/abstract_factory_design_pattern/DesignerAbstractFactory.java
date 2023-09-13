package com.java.learnjava.abstract_factory_design_pattern;

public class DesignerAbstractFactory extends EmployeeAbstractFactory{

	@Override
	public Employee createEmployee() {
		return new Designer();
	}

}

package com.java.learnjava.factorydesignpattern;

//based on input param we are going to return that type of object
public class EmployeeFactory {

	public static Employee getEmployee(String type) {
		if(type.trim().equals("ANDROID DEVELOPER")) {
			return new AndroidDeveloper();
		}else if(type.trim().equals("WEB DEVELOPER")) {
			return new WebDeveloper();

		}
		
		return null;
		
	}
}

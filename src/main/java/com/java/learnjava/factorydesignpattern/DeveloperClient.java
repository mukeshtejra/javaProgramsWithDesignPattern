package com.java.learnjava.factorydesignpattern;

public class DeveloperClient {
	
	public static void main(String args[]) {
		//this makes it tightly coupled and the purpose is getting solved so we use factory design pattern
		//based on input param we will create object.
		Employee emp = new AndroidDeveloper();
		
		
		//we will use Employee Factory based on type it will return respective object
		Employee androidEmployee = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
		System.out.println(androidEmployee.salary());
		
		Employee webEmployee = EmployeeFactory.getEmployee("WEB DEVELOPER");
		System.out.println(webEmployee.salary());


	}

}

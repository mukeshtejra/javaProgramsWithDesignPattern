package com.java.learnjava.builder_design_pattern;

public class Main {
	public static void main(String[] args) {
		User build = User.UserBuilder.builder().setName("Mukesh").setUserId(123).build();
		System.out.println(build);
	}
}

package com.java.learnjava.builder_design_pattern;

public class User {

	private final Integer userId;
	private final String name;
	
	private User(UserBuilder builder) {
		this.userId = builder.userId;
		this.name =builder.name;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	
	static class UserBuilder{
		private  Integer userId;
		private  String name;
		
		
		
		public static UserBuilder builder() {
			return new UserBuilder();
			
		}
		public UserBuilder setUserId(Integer userId) {
			this.userId = userId;
			return this;
		}
		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
		
		
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
	
	
	
	
}

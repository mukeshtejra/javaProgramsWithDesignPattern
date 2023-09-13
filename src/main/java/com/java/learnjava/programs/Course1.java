package com.java.learnjava.programs;

import java.util.Objects;


public class Course1 {


	private Integer id;
	private String name;
	private String author;
	public Course1() {
		
	}
	
	public Course1(Integer id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", Author=" + author + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj==null)
			return false;
		Course1 obj1 = (Course1)obj;
		if(obj1.id.intValue()!= id.intValue())
			return false;
		return true;
	}
	
	
	
}

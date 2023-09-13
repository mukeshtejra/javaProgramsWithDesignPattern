package com.java.learnjava.programs;

import java.util.HashMap;
import java.util.Set;

class HashSet<E>{
	private static final Object PRESENT = new Object();
	private HashMap map; 
	
	HashSet(){
		map = new HashMap<>();
	}
	
 public boolean add(E e) {
	 return map.put(e, PRESENT) ==null;
 }
	
	
}
public class CustomHashSet {

	public static void main() {
		Set<Integer> set = new java.util.HashSet<>();
	}
}

package com.java.learnjava.programs;

import java.util.HashMap;
import java.util.Map;

final class MyImmutableClass{
	private final  String name;
	
	private final Map<String,String> metadata;
	
	MyImmutableClass(String name, Map<String,String> metadata){
		
		this.name = name;
		
		Map<String, String> tempMap = new HashMap<>();
		
		for(Map.Entry<String, String> entryMap : metadata.entrySet()) {
			tempMap.put(entryMap.getKey(), entryMap.getValue());
		}
		
		this.metadata = tempMap;
		
	}
	
	public String getName() {
		return name;
	}
	
	public Map<String,String> getMetadata(){
		Map<String, String> tempMap = new HashMap<>();
		
		for(Map.Entry<String, String> entryMap : metadata.entrySet()) {
			
			tempMap.put(entryMap.getKey(), entryMap.getValue());
		}
		return tempMap;

		
	}
	
}

public class ImmutableClass {
	public static void main() {
		
	
	Map<String, String> map = new HashMap<>();
	 
     // Adding elements to Map object
     // using put() method
     map.put("1", "first");
     map.put("2", "second");

     MyImmutableClass s = new MyImmutableClass("ABC", map);
     
     System.out.println(s.getName());
     System.out.println(s.getMetadata());
     
     map.put("3", "third");

     
	}

}

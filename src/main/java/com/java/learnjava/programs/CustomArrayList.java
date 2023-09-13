package com.java.learnjava.programs;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

public class CustomArrayList<E> extends AbstractList<E>{

	private int size = 0;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private Object  elements[];
	
	
	public CustomArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	
	public CustomArrayList(int capacity) {
		elements = new Object[capacity];
	}
	
	
	@Override
	public int size() {
		return size;
	}

	
	public void add(E element, int index) {
		
		for(int i = size-1; i>=index; i--)
		{
			elements[i+1] =element;
		}
		
		elements[index] = element;
		size++;
		ensureCapacity();
		
	}
	private void ensureCapacity() {
		int newSize =  elements.length *2;
		elements = Arrays.copyOf(elements, newSize);
	}


	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		
		if(index >=size && index<0) {
			throw new IndexOutOfBoundsException("exception ");
		}
		
		 
		
		
		return (E) elements[index];
	}
	
	

}

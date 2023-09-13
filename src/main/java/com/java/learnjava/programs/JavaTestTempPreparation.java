package com.java.learnjava.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class MovieTest implements Comparable<MovieTest>{
	
	private int year;
	private int rating;
	private String name;
	
	
	@Override
	public int compareTo(MovieTest o) {
		return this.year - o.year;
		
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "year=" + year + ", rating=" + rating + ", name=" + name;
	}
	
	
	
	
	
}




class RatingsCompare implements Comparator<MovieTest>{
	
	@Override
	public int compare(MovieTest obj1, MovieTest obj2) {
		if(obj1.getRating() <= obj2.getRating()) {
			return -1;
		}
		if(obj1.getRating() >= obj2.getRating()) {
			return 1;
		}
		return 0;
	}
}

public class JavaTestTempPreparation {
	
	
	static public int getTicketLeft(int N, int a[]) {
		
        int totalTickets =30;
        int ticketMax = 6;

		for(int i=0;i<N;i++) {
		 
		        if (a[i] <= ticketMax && a[i] > 0) {
		 
		            if (a[i] <= totalTickets) {
		                totalTickets = totalTickets - a[i];
		 
		            }
		        }
		}
	    return totalTickets;
	}
	
	public static void main(String[] args) {
		List<MovieTest> testList = new ArrayList<>();
		MovieTest movie =  new MovieTest();
		movie.setName("gadar");
		movie.setRating(8);
		movie.setYear(10);
		
		MovieTest movie1 =  new MovieTest();

		movie1.setName("jawan");
		movie1.setRating(6);
		movie1.setYear(6);
		
		MovieTest movie2 =  new MovieTest();

		movie2.setName("gadar2");
		movie2.setRating(7);
		movie2.setYear(8);
		
		
		testList.add(movie2);
		testList.add(movie1);
		testList.add(movie);
		
		
		testList.stream().sorted(Comparator.comparing(MovieTest::getRating).reversed()).limit(2).skip(1);

		System.out.println(
		testList.stream().collect(Collectors.groupingBy(obj -> obj.getName()))
				);
		
		//testList.stream().collect(Collectors.groupingBy(obj -> obj.getName()), Collectors.maxBy(Comparator.comparing(MovieTest::getRating)));
		System.out.println(
		testList.stream().collect(Collectors.groupingBy(obj->obj.getName(),Collectors.maxBy(Comparator.comparing(MovieTest::getRating))))
				);
		
		testList.stream().collect(Collectors.groupingBy(MovieTest::getName, Collectors.mapping(MovieTest::getYear, Collectors.toList())));
		
		
		List<Integer> numberList = List.of(2,3,4,5);
		
		numberList.stream().reduce(0, (x,y) -> x+y);
		
		
		
		
		
		
		Collections.sort(testList);
		Collections.sort(testList,new RatingsCompare());
		
		
		Comparator<MovieTest> t = new Comparator<MovieTest>() {
			
			@Override
			public int compare(MovieTest o1, MovieTest o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Comparable<MovieTest> obj = new Comparable<MovieTest>() {
			
			@Override
			public int compareTo(MovieTest o) {
				
				return o.getYear();
			}
		};
	}

}

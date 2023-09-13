package com.java.learnjava.programs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie implements Comparable<Movie> {

	private double rating;
	private String name;
	private int year;

	public Movie(double rating, String name, int year) {
		this.rating = rating;
		this.name = name;
		this.year = year;
	}

	@Override
	public int compareTo(Movie o) {
		return this.year - o.year;
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

}

class RatingCompare implements Comparator<Movie>{
	
	@Override
	public int compare(Movie obj1, Movie obj2) {
		if(obj1.getRating() < obj2.getRating())
			return -1;
		if(obj1.getRating() > obj2.getRating())
			return -1;
		return 0;
			
	}
	
}

class NameCompare implements Comparator<Movie>{
	public int compare(Movie obj1, Movie obj2) {
		return obj1.getName().compareTo(obj2.getName());
	}
}

public class ComparableCustom {
 public static void main() {
	 Movie obj = new Movie(4, "gadar", 2023);
	 List<Movie> movieList = List.of(obj, new Movie(3, "bahubali", 2014), new Movie(1, "golmal", 2018));
	 
	 
	 Collections.sort(movieList);
	 
	 RatingCompare ratingCompare = new RatingCompare();
	 Collections.sort(movieList,ratingCompare);
	 
	 NameCompare nameCompare = new NameCompare();
	 Collections.sort(movieList,nameCompare);
	 
 }
	
	
}

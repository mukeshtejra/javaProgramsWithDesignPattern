package com.java.learnjava.programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Course{
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudent;
	
	
	
	public Course(String name, String category, int reviewScore, int noOfStudent) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudent = noOfStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	
	public String toString() {
		
		return name + ":" + noOfStudent + ":" + reviewScore;
	}
	
}

public class FuncProgramCustomClass {

	public static void main(String[] args) throws IOException {
		List<Course> courses = List.of(
				new Course("Spring", "framework", 98, 20000),
				new Course("Spring boot", "framework", 95, 18000),
				new Course("API", "microservices", 97, 22000),
				new Course("Microservices", "microservices", 96, 25000),
				new Course("Full stack", "full stack", 91, 14000),
				new Course("AWS", "cloud", 92, 21000),
				new Course("Azure", "cloud", 99, 21000),
				new Course("Docker", "cloud", 92, 20000),
				new Course("Kubernetes", "cloud", 91, 20000)

				);
		
		
		//allMatch noneMatch anyMatch
		
		//allMatch  - it will return true if all score > 95 else false
		Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
		courses.stream().allMatch(reviewScoreGreaterThan95);
		
		Predicate<Course> reviewScoreGreaterThan90 = course -> course.getReviewScore() > 90;
		courses.stream().noneMatch(reviewScoreGreaterThan90);
		
		Predicate<Course> reviewScoreGreaterThan92 = course -> course.getReviewScore() > 92;
		courses.stream().anyMatch(reviewScoreGreaterThan92);
		
		
		//Comparator - sort by no of student in increasing and decreasing order
		Comparator<Course> comparingNoOfStudentIncreasing = Comparator.comparing(Course::getNoOfStudent);
		
		//we can user ComparingInt which is efficient then boxing and unboxing
		//Comparator<Course> comparingNoOfStudentIncreasing = Comparator.comparingInt(Course::getNoOfStudent);

		System.out.println(courses.stream().sorted(comparingNoOfStudentIncreasing).collect(Collectors.toList()));

		//Decreasing order
		Comparator<Course> comparingNoOfStudentDecreasing = Comparator.comparing(Course::getNoOfStudent).reversed();
		
		System.out.println(courses.stream().sorted(comparingNoOfStudentDecreasing).collect(Collectors.toList()));

		//get highest no of student enrolled in course and it's highest review score
		Comparator<Course> comparingByNoOfStudentAndNoOfReviews = Comparator.comparing(Course::getNoOfStudent)
				.thenComparing(Course::getReviewScore).reversed();
		
		System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews));
		
		//get top 5 by using limit
		System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews).limit(5));
		
		//get top 5 by using limit
		System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews).limit(5));

		//second highest no of student
		System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews).limit(2).skip(1));

		
		System.out.println(courses.stream().sorted(Collections.reverseOrder()).limit(2).skip(1));
		
		//Max
		System.out.println(courses.stream().max(comparingByNoOfStudentAndNoOfReviews));

		//Min
		System.out.println(courses.stream().min(comparingByNoOfStudentAndNoOfReviews));
		
		//findFirst
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95).findFirst());
			
		//findAny
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95).findAny());
				
		
		//Get total number of student who got review score >95
		//Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
		System.out.println(
				courses.stream()
				//.filter(reviewScoreGreaterThan95)
				.filter(course -> course.getReviewScore() > 95)

				//.map(course -> course.getNoOfStudent())
				//.map(Course::getNoOfStudent)
				.mapToInt(Course::getNoOfStudent)
				.sum()
				);
		
		//Get average for number of student who got review score >95
				//Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
				System.out.println(
						courses.stream()
						//.filter(reviewScoreGreaterThan95)
						.filter(course -> course.getReviewScore() > 95)

						//.map(course -> course.getNoOfStudent())
						//.map(Course::getNoOfStudent)
						.mapToInt(Course::getNoOfStudent)
						.average()
						);
				
				//Get count who met specific criteria for number of student who got review score >95
				//Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
				System.out.println(
						courses.stream()
						//.filter(reviewScoreGreaterThan95)
						.filter(course -> course.getReviewScore() > 95)

						//.map(course -> course.getNoOfStudent())
						//.map(Course::getNoOfStudent)
						.mapToInt(Course::getNoOfStudent)
						.count()
						);
				
				//Get max for number of student who got review score >95
				//Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
				System.out.println(
						courses.stream()
						//.filter(reviewScoreGreaterThan95)
						.filter(course -> course.getReviewScore() > 95)

						//.map(course -> course.getNoOfStudent())
						//.map(Course::getNoOfStudent)
						.mapToInt(Course::getNoOfStudent)
						.max()
						);
				
				System.out.println("course category code starts");
				//Group courses based on category, category as key and values gets against it
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory))
						);
				
				
				//Group courses based on category, category as key and values would be count of courses
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
						);
				//{cloud=4, framework=2, full stack=1, microservices=2}
				
				
				//Group courses based on category, category as key and values would be based on highest review score
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
						);
				
				
				//Group by category as key and values would be list of course name against it
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, 
								Collectors.mapping(Course::getName, Collectors.toList()))
								)
						);
				
				courses.stream().map(obj ->{
					return obj.getName();
				}).collect(Collectors.toSet());
				
				//Joining by comma
				List<String> courseNames = List.of("Spring", "Spring Boot", "Hibernate");
				System.out.println(
				courseNames.stream().collect(Collectors.joining(","))
				);
				
				System.out.println(
						courseNames.stream().map(course -> course.split("")).collect(Collectors.toList())
				);
				//Output - [[Ljava.lang.String;@c818063, [Ljava.lang.String;@3f0ee7cb, [Ljava.lang.String;@75bd9247]

				
				//we want [s,p,r,i,n,g, s,p,r,i,n,g , b,o,o,t]
				System.out.println(
						courseNames.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
				);
				
				System.out.println(
						courseNames.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
				);
				
				
				
				
				
				// We can create common method which accept any review score which return Predicate
				Predicate<Course> reviewScoreGreaterThan95Predicate1 = createPredicateWithCustomOffReviewsScore(95);
				
				Predicate<Course> reviewScoreGreaterThan92Predicate2 = createPredicateWithCustomOffReviewsScore(90);
				
				
				//peek - use peek to know how internally works stream
				courseNames.stream().peek(System.out::println)
				.filter(course -> course.length()>10)
				.map(String::toUpperCase).peek(System.out::println).findFirst();		
				//Output 
				//Spring peek print it then check length >10 
				//Spring Boot again print and check length >10, it satisfy  then map it to upper case
				//SPRING BOOT -  peek print it as we used findfirst 
				
				
				
				//Parallel stream
				long time =  System.currentTimeMillis();
				
				//LongStream.range(0, 1000000000).sum();
				
				//Parallel stream takes less time as it run based on computer core processor
				LongStream.range(0, 1000000000).parallel().sum();

				
				System.out.println(System.currentTimeMillis() - time);
				
				//why we can not parallelize below structure code 
				// Sum variable's state keep changing so below code runs on single core
				int sum =0;
				for(int i=0; i< 1000000000; i++) {
					sum = sum+i;
				}

				
				
				List<String> nameOfCourse = List.of("Spring", "Spring Boot", "Hibernate");

				//It will throw error as List.of is immutable list, can not be modified.
				//nameOfCourse.replaceAll(str -> str.toUpperCase());
				
				//creating new modifiable list
				List<String> modifiableCourses = new ArrayList<>(nameOfCourse);
				
				modifiableCourses.replaceAll(str -> str.toUpperCase());
				
				modifiableCourses.removeIf(course -> course.length()>10);
				
				System.out.println(modifiableCourses);
				
				
				

				//FlatMap
				// we are having List of list and if we want to flatten it into single list we use flatMap
				List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(5,4,6));	
				
				System.out.println( 
				list.stream()
				.flatMap(obj ->obj.stream()).collect(Collectors.toList())
				);
				//[1, 2, 3, 5, 4, 6]
				
				//Read file
				Files.lines(Paths.get("file.txt"))
				 		.forEach(System.out::println);
				
				System.out.println("hahahahhah");
				
				
				Files.lines(Paths.get("file.txt"))
				.map(str -> str.split(" "))//it map into stream of stream
				.flatMap(Arrays::stream)//use flatmap to flatten into single stream
				.distinct()
				.sorted()
		 		.forEach(System.out::println);
				
				//print all files 
				Files.list(Paths.get("."))
					.forEach(System.out::println);
				
				//Filter out all of the directory 
				Files.list(Paths.get("."))
				.filter(Files::isDirectory)
				.forEach(System.out::println);
			
				
				
				//Thread
				Runnable runnable = new Runnable() {

					@Override
					public void run() {
						for(int i=0;i<100;i++) {
							System.out.println(Thread.currentThread().getId() + " : " + i);
									
						}
					}
					
				};
				
				//Using Labmda - as Runnable is functional interface and having one abstract method
				Runnable runnable1 = () -> {
					for(int i=0;i<100;i++) {
						System.out.println(Thread.currentThread().getId() + " : " + i);
								
					}
				};
				
				
				//Eliminate for loop Using Stream 
				Runnable runnable2 =()->{
					IntStream.range(0, 1000)
					.forEach(i -> System.out.println(Thread.currentThread().getId() + " : " + i));
				};
				
				Thread thread =  new Thread(runnable);
				thread.start();
				
				Thread thread1 =  new Thread(runnable);
				thread1.start();
				
				

	}
	//Higher order function return another function 
	private static Predicate<Course> createPredicateWithCustomOffReviewsScore(int cutOffReviewScore) {
		return course -> course.getReviewScore() > cutOffReviewScore;
	}

}

package com.java.learnjava.programs;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctinalProgramming {

	public static void main(String args[]) {
		//Java 9 introduced List.of and in java 8 we have Arrays.asList
		List<Integer> numbers = List.of(10,12,13,13,23,14);
		printAllNumbersInListStructured(numbers);
		
		printEvenNumbers(numbers);
		//Java8 having Arrays.asList
		//Arrays.asList(10,12,13,14);
		
	}

	private static void printEvenNumbers(List<Integer> numbers) {
		for(Integer n : numbers) {
			if(n%2==0) {
				System.out.println("even no= "+n);
			}
		}
		
		 
		
		//Using Stream -
		//numbers.stream().filter(n-> n%2==0).forEach(System.out::print);
		
		numbers.stream()
		.filter(FunctinalProgramming::isEven)// we can make even simpler from this
		.forEach(System.out::print);
		
		//To make it simpler we use Lambda here 
		numbers.stream()
		.filter(number -> number%2==0)
		.forEach(System.out::print);
		
		
		numbers.stream().filter(number -> number%2==0)
		.map(number -> number*number)
		.forEach(System.out::print);
		
		
		//map will map the values with lenth and forEach print it 
		List<String> course = List.of("Java","C", "python","mysql");
		course.stream().map(number -> number.length()).forEach(System.out::print);
		
		
		//Reduce will reduce value to one value 
		System.out.println(numbers.stream().reduce(0, FunctinalProgramming::sum));
		
		
		//we can convert above sum method to lambda first pass input param then add it using lambda
		numbers.stream().reduce(0,(x,y)-> x+y);
		
		
		numbers.stream().reduce(0, (x,y) -> x); // it will print 0 as passing 0,10  0,12 and so on 
		
		numbers.stream().reduce(0, (x,y) -> y); // it will print 15 as passing 0,10(x,y)  0,12 and so on
		
		//find greatest number we removed first argument as zero because it will return 0 as max in case of negative value
		numbers.stream().reduce((x,y)-> x>y ?x:y);
		
		
		//find square of each no and sum it.
		numbers.stream().map(x -> x*x).reduce((x,y) -> x+y);
		
		
		
		//predicate 
		Predicate<? super Integer> predicate = n -> n%2==1;
		numbers.stream().filter(predicate).reduce((x,y) -> x+y);
		//OR
		numbers.stream().filter(predicate).reduce(0,Integer::sum);

		
		numbers.stream().distinct().forEach(System.out::println);
		
		numbers.stream().sorted().forEach(System.out::println);
		
		numbers.stream().distinct().sorted().forEach(System.out::println);

		
		
		System.out.println("hhdffffff");
		
		System.out.println(numbers.stream().filter(predicate).reduce((x,y) -> x+y));
		
		Predicate<Integer> predicate1 = x-> x%2==1;
		System.out.println(predicate1.test(2));
		
		//Function - 
		Function<String, Integer> function = x-> x.length();
		System.out.println(function.apply("mukesh"));
		
		
		Consumer<Integer> consumerPrint = System.out::println;
		Consumer<Integer> consumerPrint1 = x -> System.out.print(x);
		
		/*List<Course> courses =  
				List.of(new Course(1, "Java", "Learn java"),
						new Course(1, "Python", "Learn Python"),
						new Course(1, "AWS", "Learn AWS"));
		
		Course course1 =  new Course(1, "Java", "Learn java");
		Consumer<Course> newCourseName = x -> course1.setAuthor("new author for java");
		newCourseName.accept(course1);*/
		
		/**
		 * Predicate , Function, Consumer
		 */
		
		numbers.stream().filter(number -> number%2==0)
		.map(number -> number*number)
		.forEach(System.out::print);
		
		//OR
		
		//Implement Predicate using lambda
		Predicate<Integer> isEvenPredicate = number -> number%2==0;
		
		//how internally predicate works
		Predicate<Integer> isEvenPredicate1 = new Predicate<Integer>() {
			public boolean test(Integer number) {
				return number%2==0;
			}
		};
		
		//Functions
		Function<Integer, Integer> squareFunction = number -> number*number;

		Function<Integer, Integer> squareFunction1  = new Function<Integer, Integer>() {
			
			public Integer apply(Integer number) {
				return number*number;
			}
		};
		
		
		//Consumer
		Consumer<Integer> sysoutConsumer = System.out::println;

		Consumer<Integer> sysoutConsumer1 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer number) {
				System.out.print(number);
			}
		};
		
		//Consumer<Integer> sysoutConsumer1 = x -> System.out.println(x);

		numbers.stream()
		.filter(isEvenPredicate1)
		.map(squareFunction1)
		.forEach(sysoutConsumer1);
		
		
		/**
		 * BinaryOperator functional interface
		 */
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		//using lambda - 
		BinaryOperator<Integer> sumBinaryOperator2 = (x,y) -> x+y;

		
		BinaryOperator<Integer> sumBinaryOperator1 = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer a, Integer b) {
				return a+b;
			}
		};
		
		numbers.stream().reduce(0, sumBinaryOperator);
		//OR
		numbers.stream().reduce(0, Integer::sum);
		
		
		//BiPredicate takes Two param return Boolean
		BiPredicate<Integer, String> biPredicate = (number,str) ->{
		
			return number <=5 && str.length()>5;
		};
		System.out.println(biPredicate.test(2, "mukesh"));
		
		//BiFunction takes two param and return any output 
		BiFunction<Integer, String, String> biFunction = (number,str)->{
			return number + " " +str;
		};
		System.out.println(biFunction.apply(2, "mukesh"));

		//BiConsumer takes two input param and return nothing
		BiConsumer<Integer, String> biConsumer = (number,str) ->{
			System.out.println(number);
			System.out.println(str);
		};
		
		//we can use funcitnal interface using primitive type as well
		IntBinaryOperator intBinaryOperator = (x,y) ->x+y;
		
		
		//using lambda - you can put type as well while passing param it will work
		BinaryOperator<Integer> sumBinaryOperator3 = (Integer x, Integer y) -> x+y;

		BinaryOperator<Integer> sumBinaryOperator4 = ( x,  y) -> x+y;

			
		
		/**
		 * Behaviour paramerization using functional interface
		 */

		//x -> x%2==0; passing this logic or behaviour as param to a method
		Predicate<Integer> predicate2 = x -> x%2==0;
		
		//in below method  passing logic as parameter  
		filterAndPrint(numbers, x -> x%2==0);
		
		//passing function interface as param
		List<Integer> squareList = mapAndPrint(numbers,x->x*x);
		
		List<Integer> cubeList = mapAndPrint(numbers,x->x*x*x);
		
		//Supplier - which takes no input and return something
		//This can be used for generating random no or creating object
		// NO inpurt - return something
		Supplier<Integer> randomNumberSupplier = () ->2;
		
		//OR
		Supplier<Integer> randomNumberSupplier1 = () ->{
			return 2;
		};

		//OR
		Supplier<Integer> randomNumberSupplier2 = () ->{
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		System.out.println(randomNumberSupplier.get());

		
		
UnaryOperator<Integer> unaryOperator = x -> 3*x;
System.out.println(unaryOperator.apply(10));





	}

	private static List<Integer> mapAndPrint(List<Integer> numbers, Function<Integer,Integer> function) {
		return numbers.stream()
		.map(function)
		.collect(Collectors.toList());
		
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate2) {
		numbers.stream()
		.filter(predicate2)
		.forEach(System.out::println);
	}

	private static int sum(int a,int b) {
		return a+b;
	}
	
	private static void print(Integer number) {
		System.out.println(number);
	}
	private static boolean isEven(Integer number) {
		return number%2==0;
	}
	
	private static void printAllNumbersInListStructured(List<Integer> numbers) {
//		for(Integer number : numbers) {
//			System.out.println(number);
//		}
		
		//Stream just Returns a sequential Stream 
		// for Example - [10,12,13,14], stream is going sequentially one by one number
		//then we perform what needs done for that number.
		//10
		//12
		// and so on
		numbers.stream().forEach(FunctinalProgramming::print);
		
		//Step1.
		//numbers.stream() - we are converting number list into stream like below
		//10
		//12
		//13
		//14
		
		//forEach -  for each element is coming out and what we want to do to call print method 
		//FunctinalProgramming::print - Method Reference
		
		// same can be achieved from below using System.out and method reference
		numbers.stream().forEach(System.out::print);
		numbers.stream().forEach(x -> System.out.println(x));

		
	}
	
}

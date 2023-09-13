package com.java.learnjava.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Practice {

	static public void swapTwoNumberWithoutThirdVariable() {
		int a = 10;
		int b = 15;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + "b = " + b);
	}

	static public void swapString() {
		// Declare two strings
		String a = "Hello";
		String b = "World";
		// Print String before swapping
		System.out.println("Strings before swap: a = " + a + " and b = " + b);

		// append 2nd string to 1st
		a = a + b;

		// System.out.println(a.substring(1));

		// store initial string a in string b
		b = a.substring(0, a.length() - b.length());

		// store initial string b in string a
		a = a.substring(b.length());

		// print String after swapping
		System.out.println("Strings after swap: a = " + a + " and b = " + b);

	}

	static void primeNumber(int n) {
		boolean prime = isPrime(n);
		if (prime) {
			System.out.println("prime number = " + n);
		} else {
			System.out.println("not a prime number = " + n);
		}
	}

	static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % 2 == 0) {
				return false;
			}

		}
		return true;
	}

	static void numberIsMultipeOf3And5(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				sum = sum + i;
			}
		}
		System.out.println(" number is multiple of 3 and 5 = " + sum);
	}

	static void palindromString(String str) {
		String temp = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			temp = temp + str.charAt(i);
		}

		if (temp.equals(str)) {
			System.out.println(str + " is  palindrome");

		} else {
			System.out.println(str +" is not palindrome");
		}
	}
	static void  Fibonacci(int n) {
		int a =0;
		int b=1;
		int count =0;
		while(count<n) {
			System.out.print(a +" ");
			int c = a+b;
			a =b;
			b=c;
			count = count+1;
		}
		//0 1 1 2  3  5 
		
	}
	
	static void checkPair(int n) {
		int a[] = {12, 3, 4, 1, 6, 13};
		int size = a.length;
		
		for(int i = 0; i<size-1; i++) {
			for(int j=i+1; j<size; j++) {
				if(a[i]+a[j] ==n) {
					System.out.println(a[i]+","+a[j] +" is pair");
				}
				
			}
		}
	}
	
	static void getElementsFromArrayBasedOnSum(int sum) {
		Integer a[] = {12, 3, 4, 1, 6, 9};
		Arrays.sort(a,Collections.reverseOrder());
		//int a[] = {12,9,6,4, 3, 1};

		int n = a.length;
		
		for (int i = 0; i < n; i++)
	    {
	 
	        // Check if the current element
	        // will be included or not
	        if ((sum - a[i]) >= 0)
	        {
	            sum = sum - a[i];
	            System.out.print(a[i] + " ");
	        }
	    }
		
	}
	
	static void factorial(int n) {
		int result = 1;
		for(int i=1;i<=n;i++) {
			result = result*i;
		}
		System.out.println("factorial of " +n +" is " + result);
	}
	
	static int calculateFactorial(int n) {
		
		if(n==0)
			return 1;
		
		return n* calculateFactorial(n-1);
	}
	
	static  void factorialRecursive(int n) {
		int result = calculateFactorial(n);
		System.out.println("factorial of " +n +" is " + result);
	}
	
	
	static void findSequenceInArray() {
		
		int a[] = {5, 1, 22, 25, 6, -1, 8, 10};

		int count = 0;
		int sequence[] = {1, 6, -1, 10};
		for (int i = 0; i < sequence.length; i++) {
			for(int j=0;j<a.length;j++) {
				if(sequence[i] == a[j]) {
					count = count+1;
					break;
				}
			}
			
		}
		
		if(count == sequence.length) {
			System.out.println("sequence is exist in array");
		}else {
			System.out.println("sequence is not exist in array");

		}
		
	}
	
	static void thirdLargestNo() {
		int a[] = {5, 1, 22, 25, 6, 30, 8, 10};
		
		int first = a[0];
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {

			if(a[i]> first) {
				third = second;
				second = first;
				first = a[i];
				
			}else if(a[i]> second) {
				third = second;
				second = a[i];
			}else if(a[i]> third) {
				third = a[i];
			}
			
		}
		System.out.println("third largest no = " + third);

 
	}
	
	static void getOccuranceOfCharByHashMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		
		for(Map.Entry<Character, Integer> mapResult : map.entrySet()) {
			System.out.println(mapResult.getKey() + " = "+ mapResult.getValue());
		}
		
	}
	
	static void getOccuranceOfChar(String str) {
		//ASCII SIZE
		int count[] = new int[256];
		
		int len = str.length();
		for(int i=0; i< len;i++) {
			//System.out.println(count[str.charAt(i)]);

			count[str.charAt(i)]++;
			System.out.println(count[str.charAt(i)]);
		}
		
		// Create an array of given String size
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
 
                // If any matches found
                if (str.charAt(i) == ch[j])
                    find++;
            }
 
            if (find == 1)
                System.out.println(
                    "Number of Occurrence of "
                    + str.charAt(i)
                    + " is:" + count[str.charAt(i)]);
        }
	}

}

public class ProgramsJava {
	public static void main(String[] args) {
		Practice.swapTwoNumberWithoutThirdVariable();

		Practice.swapString();

		Practice.isPrime(13);

		Practice.numberIsMultipeOf3And5(15);

		Practice.palindromString("abba");
		
		Practice.Fibonacci(6);
		
		Practice.checkPair(25);
		
		Practice.getElementsFromArrayBasedOnSum(24);
		
		Practice.factorial(5);
		
		Practice.findSequenceInArray();
		
		Practice.thirdLargestNo();
		
		Practice.getOccuranceOfCharByHashMap("aabbcccc");
		
		Practice.getOccuranceOfChar("aabbbnnnmkl");

		
	}
}

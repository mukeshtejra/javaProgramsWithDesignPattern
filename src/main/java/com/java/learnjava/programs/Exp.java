package com.java.learnjava.programs;
import java.util.regex.Pattern;
public class Exp {
 
    // Method to reverse words of a String
    static String reverseWords(String str)
    {
 
        // Specifying the pattern to be searched
        Pattern pattern = Pattern.compile("\\s");
 
        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        // is whitespace and store in temp array.
        String[] temp = pattern.split(str);
        String result = "";
 
       // System.out.print(temp.toString());
        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        return result;
    }
    
    static String reverseWords1(String str)
    {
    	
    	String[] listStr = str.split(" ");
    	
    	for(int i=0;i<listStr.length;i++) {
    		System.out.println(listStr[i]);
    	}
    	
    	return null;
    }
    
    
    
    
 
   



	// Driver methods to test above method
    public static void main(String[] args)
    {
        String s1 = "Welcome to geeksforgeeks";
        System.out.println(reverseWords(s1));
 
        String s2 = "I love Java Programming";
        System.out.println(reverseWords(s2));
        
		System.out.println(reverseWords1(s2));
		
    }
}
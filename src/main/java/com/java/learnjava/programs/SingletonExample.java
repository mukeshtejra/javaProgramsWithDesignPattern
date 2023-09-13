package com.java.learnjava.programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.Remote;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

enum SingetonByEnum{
	INSTANCE;
	public void show() {
		System.out.println("you can not create multiple object of enum");
	}
}

class Singleton implements Serializable, Cloneable {
	
private static Singleton singleInstance=null;
	
	public String s;
	
	private Singleton() {
		s ="I am starting part of singlton";
		if(singleInstance!=null)
			throw new RuntimeException("you are trying to create new object by reflection api");
	}
	
	public static synchronized Singleton getInstance() {
		if(singleInstance==null) {
			singleInstance = new Singleton();
		}
		return singleInstance;
	}
	
	// the above method is not good as it will lock entire method we can use synchronized block
	public static Singleton getSingletonInstanceByMultipleThreads() {
		
		if(singleInstance ==null) {
			synchronized(Singleton.class) {
				if(singleInstance ==null) {
					singleInstance = new Singleton();
				}
			}
		}
		return singleInstance;

	}
	
	//to make sure only one instance created while using serialization as 
	//we deserialization using readObject it will create new object and hashcode would be different
	//using below readResolve make sure it will create only one object at time.
	protected Object readResolve() {
		return singleInstance;
	}
	
	
	
	//Using Cloning we can create duplicate object of Singleton class
	//to avoid this we have to override clone
	
	 @Override
	    protected Object clone()
	        throws CloneNotSupportedException
	    {
	        return super.clone();
	    }
	 
	 
	
	
}
@Service
public class SingletonExample {

	// Main driver method
    public static void main(String args[]) throws Exception
    {
        // Instantiating Singleton class with variable x
        Singleton x = Singleton.getInstance();
  
        // Instantiating Singleton class with variable y
        Singleton y = Singleton.getInstance();
  
        // Instantiating Singleton class with variable z
        Singleton z = Singleton.getInstance();
  
        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of x is "
                           + x.hashCode());
        System.out.println("Hashcode of y is "
                           + y.hashCode());
        System.out.println("Hashcode of z is "
                           + z.hashCode());
  
        // Condition check
        if (x == y && y == z) {
  
            // Print statement
            System.out.println(
                "Three objects point to the same memory location on the heap i.e, to the same object");
        }
  
        else {
            // Print statement
            System.out.println(
                "Three objects DO NOT point to the same memory location on the heap");
        }
        
       
        //Using clone break singleton
        Singleton obj1 = Singleton.getInstance();
        System.out.println(obj1.hashCode());

        Singleton cloneObj = (Singleton) obj1.clone();
        System.out.println(cloneObj.hashCode());

        
        
        
        //using deserialization singleton can be broken, we must implement serializable
        Singleton obj = Singleton.getInstance();
        System.out.println(obj.hashCode());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
        oos.writeObject(obj);
        
        System.out.println("Serialization Done..");
        
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test.txt"));
        Singleton singleObj = (Singleton)inputStream.readObject();
        System.out.println(singleObj.hashCode());
        
        System.out.println("deSerialization Done..");

        
        
        
        
        //Break Singleton using Reflection API - using Reflection API we can change properties of class runtime
        Constructor<Singleton> declaredConstructor = Singleton.class.getDeclaredConstructor();
        //change private access to public for constructor
        declaredConstructor.setAccessible(true);
        Singleton newInstance = declaredConstructor.newInstance();
        System.out.println(newInstance.hashCode());
        
        
        //solution - throw runtime exception from private constructor if object !=null
        // another solution to create enum 
        
        
        
        SingetonByEnum instance = SingetonByEnum.INSTANCE;
        instance.show();

    }
	
	
}




/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_Ice4;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * class ICE4
 * 
 * experience with analyzing algorithm complexity
 * by using empirical analysis to measure the time it takes for programs to run.
 * 
 */
public class Ice4 {

	public static void main(String[] args) {
		// Write a Java program Ice4.java that asks the user for the value of val and initial n. 
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Enter a value for val: ");
			int val = scanner.nextInt();
			System.out.print("Enter a value for initial n: ");
			int n = scanner.nextInt();
 
			for(int i=n; i <= 3200; i *= 2) {
				 final long startTime = System.nanoTime();
		         System.out.print("foo(" + i+","+val+ ")");
				    foo(i, val);		    
				    final long endTime = System.nanoTime();
				    System.out.print(" " +(endTime - startTime) / 1000000000.0 + " seconds\n");
			}
			
			System.out.print("\nCalculation T(6400).....\n");
			 final long startTime = System.nanoTime();
	         System.out.print("foo(" +6400+","+val+ ")");
			    foo(6400, val);		    
			    final long endTime = System.nanoTime();
			    System.out.print(" " +(endTime - startTime) / 1000000000.0 + " seconds\n");

			
		}catch (InputMismatchException e){
			System.out.println("That's not a number!!!");
		}
        finally {
        	scanner.close();
        }

		
	}
	
	/**
	 * Mystery function.
	 * @param n   mystery argument 1
	 * @param val mystery argument 2
	 */
	private static void foo(long n, long val) {
	    long b = 0;
	    long c = 0;
	    for (long j = 4; j < n; j++) {
	        for (long i = 1; i < j; i++) {
	            b = b * val;
	            for (long k = 1; k <= n; ++k) {
	                c = b + c;	              
	            }
	        }	        
	    }
	    try {
            Thread.sleep(1);  // handicap it so that it takes 100 extra milliseconds each time through loop
        } catch (InterruptedException e) {
            // ignore
        }
	}

}

/*
 * Sam Borhan 
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_ICE1;

public class ICE1 {

	
	/* 
	 * 1- Write a recursive function that computes the sum of all numbers from 1 to n, 
	 * where n is given as parameter. A helper function may be used.
	 * return the sum 1+ 2+ 3+ ...+ n
	 */
	public static int sum( int n ) {

        if (n == 1 ) {

            return 1;

       }else {

           return sum(n-1) + n;

      }

}
	
	
	/*
	 * 2- Write a recursive function that finds
	 * and returns the minimum element in an array, 
	 * where the array is given as parameter. 
	 * A helper function may be used.
	 * 	//return the minimum element in a[]
	 */
	public static int findMin(int[] a) {
		 
		if(a.length == 0) {
			throw new IllegalArgumentException("cannot find min of empty array!");
		}

	      return findMin( a,0,Integer.MAX_VALUE);

	  }

	private static int findMin( int[] a, int i, int min ) {

	     if( i == a.length ) {

	        return min;

	    }else {

	         if( a[i] < min ) {

	          min = a[i];

	        }

	     return findMin(a, i+1, min);

	   }

	}
	 
	 
	 /*
	  * 3- Write a recursive function that computes 
	  * and returns the sum of all elements in an array,
	  * where the array is given as parameter. 
	  * A helper function may be used.
      *return the sum of all elements in a[]
	  */
	public static int findSum(int[] a) {

		if(a.length == 0) {
			throw new IllegalArgumentException("cannot sum of empty array!");
		}
	      return findSum( a,0,0);

	  }

	private static int findSum( int[] a ,int i ,int sum ) {

	     if(i == a.length) {

	      return sum;

	      }else {

	      sum += a[i];

	  return findSum( a ,i+1 ,sum );

	  }

	}
	 
	 
	 
	 /*
	  * Testing the methods for ICE1
	  */
	 public static void main(String[] args) {
		 
			int[] arr = {7,9,2,8,1,4,6,0,3,5,10};
			
			System.out.println(sum(10));
			System.out.println("Minimum element is : "+findMin(arr));
			System.out.println("Sum of all element is : "+findSum(arr));
	
	}
}

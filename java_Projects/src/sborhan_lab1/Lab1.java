
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_lab1;

import java.util.Scanner;

/**
 * Class Lab1
 * 
 * Read,store and sort values in non-descending order into an array 
 * Search for the provided value and Display the index of founded value
 * Use Binary search algorithm - one recursive version,
 * And one iterative version
 * 
 * @author SAM BORHAN
 * @version 1.0
 *
 */
public class Lab1 {

	// Array of integers with constant size
    private final static int[] arr =new int[22];
	
    /**
     * Method sort
     * sorting the arrays elements in ascending order
     * @param arr : array of integers
     */
	public static void sort(int[] arr) {
	   	for(int i=0 ;i< arr.length-1;i++) { 
	   		
		  if(arr[i] > arr [i+1]) {
			int temp = arr[i] ;
			arr[i] = arr[i+1];
			arr [i+1] = temp;
			i=-1;
		  }
	   }
	 }
	
	
	/**
	 * Method recursiveSearch
	 * search for a value in an array using recursive
	 * and return the index of founded value
	 * 
	 * @param n : value for searching
	 * @return index of founded value or -1 if not found
	 */
	public static int recursiveSearch(int n) {
		return recursiveSearch(arr,0,arr.length-1,n);
	}
	
	/**
	 * Overload Method recursiveSearch
	 * Search for a value in an array using recursive
	 * and return the index of founded value
	 * 
	 * @param arr : arrays of integers
	 * @param first : first value in array
	 * @param last  : last  value in array
	 * @param n : value for searching
	 * @return index of founded value or -1 if not found
	 */
	private static int recursiveSearch(int[]arr,int first,int last,int n) {
		int mid = (first + last) / 2;
		if(first > last) {
			return -1;
		}else if(arr[mid] == n) {
			return mid;
		}else if(n < arr[mid] ) {
			return recursiveSearch(arr,first,mid-1,n);
		}else {
			return recursiveSearch(arr,mid+1,last,n);
		}	
	}
	
	/**
	 * Method iterativeSearch
	 * search for value in an array using iterative
	 * and return the index of founded value
	 * 
	 * @param n : value for searching
	 * @return index of founded value or -1 if not found
	 */
	public static int iterativeSearch(int n) {
		return iterativeSearch(arr,0,arr.length-1,n);
	}
	
	/**
	 * Overload Method iterativeSearch
	 * Search for a value in an array using iterative
	 * and return the index of founded value
	 * 
	 * @param arr : arrays of integers
	 * @param first : first value in array
	 * @param last  : last  value in array
	 * @param n     : value for searching
	 * @return index of founded value or -1 if not found
	 */
	private static int iterativeSearch(int[]arr,int first,int last,int n) {
	
		while(first <= last) {
			int mid = (first + last) / 2;
			if(arr[mid] < n) {
				first = mid + 1;
			}else if(arr[mid] > n) {
				last = mid - 1;
			}else {
				return mid;
			}
		}
	  return -1;
	}
	
		

	/**
	 * Method userInputValidation
	 * validating user input and insert it into the Array
	 * @param scanner : Scanner
	 * @param arr : array of integers reading from scanner
	 */
	private static void userInputValidation(Scanner scanner,int[] arr) {
		
		  int input;
		  
		  for(int i = 0;i< arr.length ;i++) {  	   
	       	 System.out.print("enter your number("+(i+1)+") :");
	       	 if(scanner.hasNextInt()) {
	  		        input = scanner.nextInt();
	       	    	arr[i]= input;
	       	 }else {
	       		 System.out.println("That's not a number!\n");
	       		 i--;
	       		 scanner.next();
	       	 }  	    	 
	      }	      
	}
	

	
	/**
	 * Method userInputToSearch
	 * Ask user to search a value,validate and return that value
	 * @param scanner : Scanner instance variable
	 * @return :integer value which user wants to search,reads from scanner
	 */
	private static int userInputToSearch(Scanner scanner) {
			int input ;
			System.out.print("\nEnter a value u want to search: "); 
	   
	    while(!scanner.hasNextInt()) { 
		      System.out.println("That's not a number!\n"); 
		   	  System.out.print("Enter a value u want to search: "); 
		    	if(scanner.hasNextInt()){
		    		input = scanner.nextInt(); 
                    return input;
		    	}else {
		    		 scanner.next();
		    	}
	     } 
	  input = scanner.nextInt();    
	  return input;
    }
		
	
	
	/**
	 * Method main
     *
     * Displays user inputs ,sorted array elements
     * And index of founded value if exists
     * 
     * @param args A string array containing the command line arguments.
     */ 
	public static void main(String[] args) {
		 int valueToSearch ;
         Scanner scanner = new Scanner(System.in);
         
         System.out.println("\n==== Welcome to binary search application ===== ");  
    	 System.out.println("\nPlease provide 22 numbers....\n");
       
    	 //getting integer values from user
    	 Lab1.userInputValidation(scanner,arr);
    	 //sorting array elements
    	 Lab1.sort(arr);
    	 
    	 //displaying array elements
   	     System.out.print("\nArray elements: ");
         for(int i=0;i<arr.length;i++) {
        	 System.out.print(arr[i]+"|");
         }
         //get a value from user to search
   	     valueToSearch = userInputToSearch(scanner);
   	     System.out.println("\nSearching for value " + valueToSearch+"...");
   	     
   	     //check if the value is exists and display the index using recursive binary search
         if(Lab1.recursiveSearch(valueToSearch) != -1) {
            System.out.println("\nfound at indext(recursive version): "+
            Lab1.recursiveSearch(valueToSearch));
         }else{
             System.out.print("\nfound at indext(recursive version): "+" Not found! ");
         }
         
   	     //check if the value is exists and display the index using iterative binary search
         if(Lab1.iterativeSearch(valueToSearch) != -1){
             System.out.println("\nfound at indext(iterative version): "+
             Lab1.iterativeSearch(valueToSearch));
         }else {
             System.out.print("\nfound at indext(iterative version): "+" Not found! ");  
         }
         
         System.out.println("\n\n==== Thanks for using our binary search application ===== ");  

         
		scanner.close();
	}

}

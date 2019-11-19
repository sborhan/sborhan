
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_lab6;

import java.util.Arrays;
import java.util.Random;

//Test performance for different sort algorithms
public class Lab6 {

  public static void main(String[] args) {
		Sort sort = new Sort();
		Random random = new Random();	
		
		int [] originalArray = new int[16_384_003];
		
		int[] trialCapacity = {125,250,500,1000,2000,4000,8000,16000,32000,64000,128000,
			                   256000,512000, 1024000,2048000,4096000,8192000,16384000};
	
		int[] InsertionSortCapacity = {125,250,500,1000,2000,4000,8000,16000,32000,64000
				                      ,128000};
		 
		System.out.println("\nPerforming timing test starts to have a larger n:"); 
		System.out.println("\nwill start in a few second......\n"); 
	 
	 for(int j=0 ; j<3 ; j++) {
		System.out.println("\nTrial: "+(j+1)); 
		System.out.println("--------------------------------"); 

	   
		   for(int i=0 ; i<=16384000 ; i++) {
		     originalArray[i] = random.nextInt(555) +1;
		   }
		 
		 System.out.print("\nArray.sort Timing....\n");
		   for(int i : trialCapacity) {
		     int[] array = new int[i];
			 createUnsortedArray(array,originalArray);
		     printArraySortTiming(array,i);
		   }
		
		 System.out.print("\nQuick Sort Timing....\n");
		    for(int i : trialCapacity) {
			  int[] array = new int[i];
			  createUnsortedArray(array,originalArray);
			  printQuickSortTiming(array,sort,i);
		    }   
		   
		   
		 System.out.print("\nMerg Sort Timing....\n");
	        for(int i : trialCapacity) {
		      int[] array = new int[i];
		      createUnsortedArray(array,originalArray);
		      printMergSortTiming(array,sort,i);
	        }
		
	    
	     System.out.print("\nHeap Sort Timing....\n");
	        for(int i : trialCapacity) {
			  int[] array = new int[i];
			  createUnsortedArray(array,originalArray);
			  printHeapSortTiming(array,sort,i);
		    }
	    
	    
		 System.out.print("\nInsertion Sort Timing....\n");
	        for(int i : InsertionSortCapacity) {
			  int[] array = new int[i];
			  createUnsortedArray(array,originalArray);
			  printInsertionSortTiming(array,sort,i);
		    }
	 }
		
   }
	
   public static void createUnsortedArray(int[] array,int[] originalArray) {
	       for(int i = 0 ; i < array.length ; i++) {
		     array[i] = originalArray[i];
		 }	   
   }
   
   public static void printMergSortTiming(int[] array, Sort sort,int i) {
	    final long startTime = System.nanoTime();
	    sort.mergeSort(array,0,array.length-1);	    
	    final long endTime = System.nanoTime();
	    System.out.print("n:"+array.length+"  "+
	                     (endTime - startTime) / 1000000000.0 + " seconds\n");

   }
   
   public static void printHeapSortTiming(int[] array, Sort sort,int i) {
	    final long startTime = System.nanoTime();
	    sort.heapSort(array);	    
	    final long endTime = System.nanoTime();
	    System.out.print("n:"+array.length+"  "+
	                     (endTime - startTime) / 1000000000.0 + " seconds\n");

   }
   
   public static void printQuickSortTiming(int[] array, Sort sort,int i) {
	   final long startTime = System.nanoTime();
	   sort.quickSort(array);    
	   final long endTime = System.nanoTime();
	   System.out.print("n:"+array.length+"  "+
	                     (endTime - startTime) / 1000000000.0 + " seconds\n");

   }
   
   public static void printInsertionSortTiming(int[] array, Sort sort,int i) {
	   final long startTime = System.nanoTime();
	   sort.insertionSort(array);    
	   final long endTime = System.nanoTime();
	   System.out.print("n:"+array.length+"  "+
	                     (endTime - startTime) / 1000000000.0 + " seconds\n");

   }
   
   public static void printArraySortTiming(int[] array,int i) {
	   final long startTime = System.nanoTime();
	   Arrays.sort(array);    
	   final long endTime = System.nanoTime();
	   System.out.print("n:"+array.length+"  "+
	                     (endTime - startTime) / 1000000000.0 + " seconds\n");

   } 
   
}

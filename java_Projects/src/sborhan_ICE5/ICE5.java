
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package sborhan_ICE5;

import java.util.Random;

// Main driver program (test at least 30 integers to input)
public class ICE5 {

	public static void main(String[] args) {
		Random random = new Random();
		Heap heap = new Heap(10);
		System.out.println("\nInserting into the heap:");

		for(int i = 0 ; i < 35 ; i++) {
			heap.enqueue(random.nextInt(35)-15);
		}	
		
		System.out.print(heap+"\n");	
    	System.out.println("heap is empty (false expected): "+ heap.empty());

    	
		System.out.println("\nExtracting minimums from the heap:");	
		for(int i = 0 ; i < 35 ; i++) {
		   System.out.print(heap.peek()+" ");
		   heap.dequeue();   
		}
	    System.out.println("\nheap is empty (true expected): "+ heap.empty());	
	}
}

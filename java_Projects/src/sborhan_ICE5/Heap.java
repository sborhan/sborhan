
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_ICE5;

import java.util.Arrays;
import java.util.EmptyStackException;

//Construct a heap
public class Heap implements PriorityQueueADT<Integer> {
	  private Integer[] data;
	  private int size;
	  private int capacity;
	
	  // takes in the capacity
	  // creates a min heap based on the capacity
	  public Heap(int capacity) {
		  this.capacity = capacity;
		  data = new Integer[this.capacity];	
		  size = 0;
	  }
	  
	  //determines if the heap is empty or not
	  public boolean empty() { 	 
		  return size <= 0;	  
      }
	  
	  // returns the minimum value of the heap
	  public Integer peek() {
		  if(size == 0) {
			throw new EmptyStackException(); 
		  }
		  if(!empty()) {
			  return data[0];     
		  }
	    return null;
	  }
	  
	  //takes in a value; inserts the value into the heap
	  public void enqueue(Integer elem) {
		  // add to end of array
		  // increase size
		  // create a recursive helper, percolateUp,
		  // that allows you puts the inserted val 
		  // in the right place
		  if(size == capacity) {
			  ensureCapacity(size);
		  }
		   data[size] = elem;
		   size++;
		   percolateUp(size-1);      
	  }

	  //removes the minimum value from the heap and returns it
	  public Integer dequeue() {
		    // get last val in heap, copy value to index 0
		    // decrease size     
		    // create a recursive helper, percolateDown,
		    // that allows you move the removed val 
		    // in the right place
		  
		  if (size == 0) 
			  throw new EmptyStackException();
	        int item = data[0];        
	        data[0] = data[size - 1]; 
	        size--;
	        percolateDown(0);             
	    return item;
	  }
	 

	  //returns the heap values, delimited by spaces
	  public String toString() { 
		  String str="";
		  for(int i=0; i< size; i++)
			   str += data[i]+" ";
		  return str;
	  }
	  
	  // Dynamically increasing size of array
	  private void ensureCapacity(int newCapacity) {
			 data = Arrays.copyOf(data, newCapacity * 2);
			 this.capacity = newCapacity * 2;
		 }
  
	  private void percolateUp(int index) { 
	
		  if(index != 0) {	
			  if(hasParent(index) && parent(index) > data[index]) {
				  swap(parentIndex(index) ,index );
				  index = parentIndex(index);
				  percolateUp(index);
			  }		  
		  }	  
	  }
	  
	  private void percolateDown(int index) {  
		
		  if(hasLeft(index)) {
			  int smallerChildIndex = leftIndex(index);     
	           if (hasRight(index) && right(index) < left(index)) {               
	                smallerChildIndex = rightIndex(index);
	           }
	           if(data[index] >= data[smallerChildIndex]) {
	                swap(index, smallerChildIndex);               
	                index = smallerChildIndex;  
	                percolateDown(index);                        
	          }
          }		  
      }
	  
	  private void swap(int indexOne, int indexTwo) {
	        int temp = data[indexOne];
	        data[indexOne] = data[indexTwo];
	        data[indexTwo] = temp;
	  }
	  private boolean hasParent(int childIndex) {
		  return parentIndex(childIndex) >= 0;
	  }
	  private boolean hasLeft(int parentIndex) { 
		  
		  return leftIndex(parentIndex) < size;
	  }
	  private boolean hasRight(int parentIndex) {
		  return rightIndex(parentIndex) < size;
	 }
	  private int left(int parentIndex) {
		  return data[leftIndex(parentIndex)];
	  }
	  private int right(int parentIndex) { 
		  return data[rightIndex(parentIndex)];
	  }
	  private int parent(int childIndex) { 
		  return data[parentIndex(childIndex)];
	  }
	  
	  private int parentIndex(int chileIndex) {
		  return (chileIndex-1)/2;
	  }
	  
	  private int rightIndex(int parentIndex) { 
		  return parentIndex * 2 + 2;
	  }
	  
	  private int leftIndex(int parentIndex) { 
		  return parentIndex * 2 + 1;
	  }
}

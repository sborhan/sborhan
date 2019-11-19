package sborhan_p2x;


/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * class PatientPriorityQueue
 * Hospital triage system implemented using a heap.
 * @author  Sam Borhan
 * @version 01
 */
public class PatientPriorityQueue {
   //**** All private fields *****
	private ArrayList<Patient> patients; // heap property is always satisfied
    private int nextPatientNumber;       // num assigned to next added patient
    
    
   //***** All class methods *****
    /**
     * Constructor
     * Creates an empty triage system with no patients.
     */
    public PatientPriorityQueue() {
        this.patients = new ArrayList<Patient>();
        this.nextPatientNumber = 1;
    }

    /**
     * method getPatientList
     * Gets the list of patients currently in the waiting room
     * @return the list of patients that have not been called
     */
    public ArrayList<Patient> getPatientList() {
        return patients;
    }

    /**
     * method size
     * @return int:display the number patients in the waiting list
     */
    public int size() {
        return patients.size();
    }

    
    /**
     * method peek
     * display the Highest priority patient to be called next
     * @return Patient
     */
    public Patient peek() {
		if(patients.size() == 0)  
        	throw new EmptyStackException();
	
      return patients.get(0);
    }
     
    
    /**
     * method addPatient
     * adding patients into the waiting area list
     * @param priorityCode :represents the triage of patients 
     * @param patientName
     */
    public void addPatient(int priorityCode, String patientName) {
    	if(patientName.isEmpty()) {
    		throw new IllegalArgumentException();
    	}
    	Patient	newPatient = new Patient(priorityCode,nextPatientNumber,patientName);
    	patients.add(newPatient);
    	nextPatientNumber++;
	    percolateUp(patients.size()-1);  
    }
    
    /**
     * overload method addPatient
     * adding patients into the waiting area list
     * @param priorityCode
     * @param patientName
     * @param nextPatientNum
     */
    public void addPatient(int priorityCode, String patientName,int nextPatientNum) {
    	if(patientName.isEmpty()) {
    		throw new IllegalArgumentException();
    	}
    	Patient	newPatient = new Patient(priorityCode,nextPatientNum,patientName);
    	patients.add(newPatient);
	    percolateUp(patients.size()-1); 
	    if(nextPatientNum>=nextPatientNumber)
	    	nextPatientNumber= nextPatientNum+1;
    }
    
    
    /**
     * method dequeue
     * Display the patient who will now be seen
     * and remove it from the list
     * @return Patient 
     */
    public Patient dequeue() {
    	if(patients.size() == 0) 
			throw new EmptyStackException();
    	
    	Patient p = patients.get(0);        
    	patients.set(0,patients.get(patients.size()-1));
    	patients.remove(patients.size()-1);
	    percolateDown(0);             
	  return p;
    }
    
    /**
     * helper method percolateDown
     * looking to it's children for lower patient values to swap
     * @param index:represnts the first patient's index in the list
     */
    public void percolateDown(int index) {   
    	//check priorityCode
      if(hasLeft(index)) {
     	 int smallerChildIndex = leftIndex(index);
     	 // checking for higher priority between left and right children   
        if(hasRight(index) &&
          left(index).getPriorityCode() > right(index).getPriorityCode()  ||
          hasRight(index) &&
   	      left(index).getPriorityCode() == right(index).getPriorityCode() &&
   	      left(index).getArrivalOrder() > right(index).getArrivalOrder()) {
   	    				
   	    		 smallerChildIndex = rightIndex(index);   				
   	    } 
         //checking if parent needs to swap with one of the child
        isHigherPriority(index, smallerChildIndex);	
      }
    }
    
    
    /**
     * helper method percolateUp
     * looking to it's parents for lower patient values to swap
     * @param index:represnts the last patient's index in the list
     */
    public void percolateUp(int index) { 
    	
	 if(index != 0) {	
	   if( parent(index).getPriorityCode() == patients.get(index).getPriorityCode()){
		  if(hasParent(index) &&
		     parent(index).getArrivalOrder() > patients.get(index).getArrivalOrder()) {		    	
			    swap(parentIndex(index) ,index );
				index = parentIndex(index);
				percolateUp(index);				  
		  }	
	   }else{		
		 if(hasParent(index) &&
	         parent(index).getPriorityCode() > patients.get(index).getPriorityCode()) {				    	
				swap(parentIndex(index) ,index );
				index = parentIndex(index);
				percolateUp(index);						  
	     }
	   }
	 }
   }

    
  
    /**
     * helper method isHigherPriority
     * checking if second parameter is Higher Priority 
     * @param smallerChildIndex
     * @param index
     * @return boolean :return true if smallerChildIndex lower than index
     */
    private boolean isHigherPriority(int index, int smallerChildIndex) {
    	
       if(patients.get(index).getPriorityCode() == 
        patients.get(smallerChildIndex).getPriorityCode()) { 
    	 
        if(patients.get(index).getArrivalOrder() >
          patients.get(smallerChildIndex).getArrivalOrder()){ 	
    	   
          swap(index, smallerChildIndex);               
  	      index = smallerChildIndex;  
  	      percolateDown(index); 
  	      
        return true;      
  	   }	  
      }  
       
      if(patients.get(index).getPriorityCode() >
       patients.get(smallerChildIndex).getPriorityCode()){   
    	
       swap(index, smallerChildIndex);               
       index = smallerChildIndex;  
       percolateDown(index);
       
       return true;
      }	
      
    return false;
   }
    
   /**
    * helper method swap
    * swapping the values of two index
    * @param indexOne
    * @param indexTwo
    */
   private void swap(int indexOne, int indexTwo) {
       Patient temp = patients.get(indexOne);
       patients.set(indexOne, patients.get(indexTwo));
       patients.set(indexTwo, temp);
   }
   
   /**
    * helper method hasParent
    * @param childIndex
    * @return boolean : checking if has parent
    */
   private boolean hasParent(int childIndex) {
	  return parentIndex(childIndex) >= 0;
   }
   
   /**
    * helper hasLeft
    * @param parentIndex
    * @return boolean : checking if has left child
    */
   private boolean hasLeft(int parentIndex) { 	  
	  return leftIndex(parentIndex) < patients.size();
   }
   
   /**
    * helper hasRight
    * @param parentIndex
    * @return boolean : checking if has right child
    */
   private boolean hasRight(int parentIndex) {
	  return rightIndex(parentIndex) < patients.size();
   }
   
   /**
    * helper method left
    * @param parentIndex
    * @return Patient :represents left patient 
    */
   private Patient left(int parentIndex) {
	 return patients.get(leftIndex(parentIndex));
   }
   
   /**
    * helper method right
    * @param parentIndex
    * @return Patient :represents right patient
    */
   private Patient right(int parentIndex) { 
	 // return data[rightIndex(parentIndex)];
	  return patients.get(rightIndex(parentIndex));
   }
   
   /**
    * helper method parent
    * @param childIndex
    * @return Patient :represents parent patient
    */
   private Patient parent(int childIndex) { 
	  //return data[parentIndex(childIndex)];
	 return patients.get(parentIndex(childIndex));
   }
  
   /**
    * helper method parentIndex
    * @param chileIndex
    * @return integer:represents parent patient index
    */
   private int parentIndex(int chileIndex) {
	  return (chileIndex-1)/2;
   }
  
   /**
    * helper method rightIndex
    * @param parentIndex
    * @return represents right patient index
    */
  private int rightIndex(int parentIndex) { 
	  return parentIndex * 2 + 2;
  }
  
  /**
   * helper method leftIndex
   * @param parentIndex
   * @return represents left patient index
   */
  private int leftIndex(int parentIndex) { 
	  return parentIndex * 2 + 1;
  }
}


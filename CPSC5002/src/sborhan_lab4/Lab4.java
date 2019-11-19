
/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/*  
 * 
 * This program reads the file lab4.dat and 
 * inserts the elements into a linked list in nondescending order.
 * The contents of the linked list are then displayed to the user in column form.
 * 
*/


package sborhan_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// class Lab4 -> 
public class Lab4 {
	
	
  
  //====== Inner class Node =======
    private class Node {
    	
     //======= Inner class Fields ======
    	
         /*
          * store value -> int data type
         */
        public int data;
        
         /*
          * store address -> Node instance variable
         */
        public Node next;
   
     //====== Inner class Method ======
        
         /*
          * constructor
          * 
          * @param data : integer
          * @param next : Node
          * 
          */
        public Node(int data, Node next) {
         
       this.data = data;
       this.next = next;
            
        }
        
    }

    //===== Lab4 LinkedList class private fields ======
    
    /*
     * Store address -> Node instance variable
     * 
     */
    private Node head;
    
    /*
     * store value -> String data type
     * static field
     * Constant value
     */
    final private static String FILENAME = "lab4.dat";

    
  //======== Lab4 LinkedList class Methods =========
    
    /*
     * NO argument Constructor
     */
    public Lab4() {
    	
        head = null;      
    }

   /*
    * method sortFile
    * Remove Duplicate
    * Reading file & 
    * sorting data in the file by using private method putInOrder &
    * Display the result by using private method printValues
    * 
    * @return : void
    */
    private void sortFile() throws FileNotFoundException {
        Scanner file = new Scanner(new File(FILENAME));
        while (file.hasNext()) {
            putInOrder(file.nextInt());
        }
        printValues();
        System.out.println("\n======= Thanks for using the linked list application! ======= ");
        file.close();
    }

    /*
     * method putInorder 
     * sort value from the smallest to the largest
     * @return : void
     */
    private void putInOrder(int n) {
    	    /* check if it's first node or
    	     * check if parameter value is smaller than current head value
    	     */	    
        if (head == null || head.data > n) {
            // become head in the linked list
            head = new Node(n, head);
        } else {
            
            Node p = head;
            
            // loop ends when reach null or find larger node value  
            while (p.next != null && p.next.data < n) {         
            	p = p.next;
            }
            
            
            // Remove DUplicate
           if(p.next == null && p.data!=n  || p.data!=n && p.next.data!=n)
           {
        	   /* new Node siting between smaller and larger node value
                *  or siting at the end of list
                */ 
            p.next = new Node(n, p.next);
           }
           
        }

    }

    /*
     * method printValues
     * displays list's contents
     * @return : void
     */
    private void printValues() {
        System.out.println("Linked list contents:");
        for (Node p = head; p != null; p = p.next)
            System.out.println(p.data);
    }

     // static main method for testing purposes Only
    public static void main(String[] args) throws FileNotFoundException {
        
    	Lab4 myList = new Lab4();
    	System.out.println("===== Welcome to the Linked List Application ======\n");
        System.out.println("This program reads the file lab4.dat and\n"
        		           + "Displays the content of list from smallest to largest in column form.\n");
        
        myList.sortFile();
        
    }
}



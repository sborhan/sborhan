
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
 * Duplicates are then removed, and the contents are displayed again.
 * 
*/

package sborhan_lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Description of Lab5 
 * @author Sam Borhan
 * @version 1.0
 */
public class Lab5 {
	
	
  
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

    //===== Lab5 LinkedList class private fields ======
    
    /*
     * Store address -> Node instance variable
     * 
     */
    private Node head;
    private Node head2;
 //   private Node head3;
    
    /*
     * store value -> String data type
     * static field
     * Constant value
     */
    final private static String FILENAME = "lab4.dat";

    
  //======== Lab5 LinkedList class Methods =========
    
    /*
     * NO argument Constructor
     */
    public Lab5() {
    	
        head = null;
        head2 = null;
    }

   /*
    * method sortFile
    * 
    * Reading file &
    * Sorting data in the file by using private method putInOrder &
    * Removing Duplicate values by using private method removeDuplicates &
    * Displaying the Sorted data by using private method printValues & 
    * Displaying the Sorted data by using private method printNoDuplicateValues
    * 
    * @return : void
    */
    private void sortFile() throws FileNotFoundException {
    	
    	File file1= new File(FILENAME);
    	String path = file1.getAbsolutePath();
    	String pathh = file1.getParent();
    	
        Scanner file = new Scanner(new File(FILENAME));
        while (file.hasNext()) {
            putInOrder(file.nextInt());
        	deleteData(4);

        }
      

        printValues();
        
        Scanner file2 = new Scanner(new File(FILENAME));
        while (file2.hasNext()) {
        	removeDuplicates(file2.nextInt());

        }
        
        //deleteData(10);
        printNoDuplicateValues();
       
        System.out.println("\n======= Thanks for using the linked list application! ======= ");
        file.close();
        file2.close();
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
    }else{
        
        Node p = head;
        
        // loop ends when reach null or find larger node value  
        while (p.next != null && p.next.data < n) {         
        	p = p.next;
        }
        
      
    	   /* new Node siting between smaller and larger node value
            *  or siting at the end of list
            */ 
        p.next = new Node(n, p.next);
       
       
    }

}
    
    /*
     * method removeDuplicates 
     * sort value from the smallest to the largest
     * remove Duplication
     * @return : void
     */
    
    private void deleteData(int n) {
    	
    	   Node p1 = null;;
    	   Node p  = head;
    	      while(p.next != null && p.data != n) {
    	    	  p1 =p;
    	    	  p = p.next;
    	      }
    	      if(p.data == n) {
    	    	  p1.next =p1.next.next;
    	      }  	
        
    }
    
    private void removeDuplicates(int n) {
	    /* check if it's first node or
	     * check if parameter value is smaller than current head value
	     */	    
    if (head2 == null || head2.data > n) {
        // become head in the linked list
        head2 = new Node(n, head2);
    }else{
        
        Node p = head2;
        
        // loop ends when reach null or find larger node value  
        while (p.next != null && p.next.data < n) {         
        	p = p.next;
        }
        
        
        /* 
         * Remove Duplicate from the head node and tail node
         * Remove Duplicate in between nodes 
         */
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
    
    /*
     * method printNoDublicateValues
     * displays No Dublicate Values list's contents
     * @return : void
     */
    private void printNoDuplicateValues() {
        System.out.println("\nLinked list contents with no duplicates:");
        for (Node p = head2; p != null; p = p.next)
            System.out.println(p.data);
    }

     // static main method for testing purposes Only
    public static void main(String[] args) throws FileNotFoundException {
        
    	Lab5 myList = new Lab5();
    	System.out.println("===== Welcome to the Linked List Application ======\n");
        System.out.println("This program reads the file lab4.dat then\n"+
        		           "Displays the content of list from smallest to largest in column form.\n"+
        		           "Duplicates are then removed, and the contents are displayed again.\n");
        
        myList.sortFile();
        
    }
}



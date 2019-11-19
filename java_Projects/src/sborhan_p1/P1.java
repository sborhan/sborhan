
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * class P1
 * 
 *  testing implementation of generic BST class
 * @author SAM BORHAN
 * @version 01
 *
 */
public class P1 {
	
	//private static final String FILENAME ="integers.txt";
	public static void main(String[] args)  throws FileNotFoundException  {
		Scanner file = new Scanner(System.in);
		BST<Integer> bst = new BST<>();


		System.out.println("\n======= Welcome to the BST test program ========\n"); 
				
		System.out.print("Load file (Enter blank to use predefined data): ");
		String fileName = file.nextLine();
		
		//////////////////////
	    System.out.print("\nTESTING empty method: check before insert\n");
	    System.out.print("Tree is empty: "+ bst.empty()+"\n");

	   try {
		   
		if(!fileName.equals("")) {
	         file = new Scanner(new File(fileName));
	         while (file.hasNext()) {
	        	int i =file.nextInt();
	        	bst.insert((i));
	        }
	        
            //////////////////////
            System.out.print("\nTESTING empty method: check after insert\n");
            System.out.print("Tree is empty: "+ bst.empty()+"\n");

		    System.out.println("\n");
		    System.out.print(bst);
		    System.out.println("\n");
            System.out.print("\nTESTING getTreeHeight method:  -> ");
		    System.out.println("Tree hight is:  "+bst.getTreeHeight());
            System.out.print("\nTESTING size method:  -> ");
		    System.out.println("Number of elements:  "+bst.size());
            System.out.print("\nTESTING getLeafNodeCount method: -> ");
		    System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");
		    
	 		   //////////////////////////////////////////////
	            System.out.print("TESTING getPreOrderTraversal Method:\n");  
	            for(int i : bst.getPreOrderTraversal()) {
	            	System.out.print(i+", ");
	            }
	            
	            System.out.print("\n\nTESTING getInOrderTraversal Method:\n");  
	            for(int i : bst.getInOrderTraversal()) {
	            	System.out.print(i+", ");
	            }
	            
	            System.out.print("\n\nTESTING getPostOrderTraversal Method:\n");  
	            for(int i : bst.getPostOrderTraversal()) {
	            	System.out.print(i+", ");
	            }
	 		    
	 		    

		    ////////////////////////////////////////////////
		    System.out.println("\n\n\nTESTING INSERT Method: inserting elements in this order:" + 
		    		         " 66,25,2,31,13,99,-2,59,43 \n");  
		    bst.insert((66));
        	bst.insert((25));
        	bst.insert((2));
        	bst.insert((31));
        	bst.insert((13));
        	bst.insert((99));
        	bst.insert((-2));
        	bst.insert((59));
        	bst.insert((43));

        	
 		    System.out.print(bst);
 		    System.out.println("\n");
            System.out.print("\nTESTING getTreeHeight method:  -> ");
 		    System.out.println("Tree hight is:  "+bst.getTreeHeight());
            System.out.print("\nTESTING size method:  -> ");
 		    System.out.println("Number of elements:  "+bst.size());
            System.out.print("\nTESTING getLeafNodeCount method: -> ");
 		    System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");

		   
 		 
 		    
 		    
		  //////////////////////////////////////////////////
		    System.out.print("\n\n\nTESTING REMOVE Method: removing elements in this order:" + 
   		         " 6,13,99,-2,65,43\n");	   
        	bst.remove((6));
        	bst.remove((13));
        	bst.remove((99));
        	bst.remove((-2));
        	bst.remove((65));
        	bst.remove((43));
		    
		    
		    
		
        	System.out.println("\n");
 		    System.out.print(bst);
 		    System.out.println("\n");
            System.out.print("\nTESTING getTreeHeight method:  -> ");
 		    System.out.println("Tree hight is:  "+bst.getTreeHeight());
            System.out.print("\nTESTING size method:  -> ");
 		    System.out.println("Number of elements:  "+bst.size());
            System.out.print("\nTESTING getLeafNodeCount method: -> ");
 		    System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");
 
		     
             ////////////////////////////////////////////////
               System.out.print("\nTESTING INSERT Method After Remove: Reinserting elements in this order:" + 
             " 6,99,65,-2 \n"); 
               bst.insert((6));
               bst.insert((99));
               bst.insert((65));
               bst.insert((-2));
               



                 System.out.println("\n");
                 System.out.print(bst);
                 System.out.println("\n");
                 System.out.println("Tree hight is:  "+bst.getTreeHeight());
                 System.out.println("Number of elements:  "+bst.size());
                 System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");
		     
		     //////////////////////////////////////////////
                 System.out.print("\nTESTING contains Method:\n");
                 System.out.print("\nShould contain these..\n");
                 System.out.print("contain(20): "+bst.contains(40)+"\n"); 
                 System.out.print("contain(40): "+bst.contains(40)+"\n");
                 System.out.print("contain(10): "+bst.contains(40)+"\n"); 
                 System.out.print("contain(70): "+bst.contains(40)+"\n"); 

                 System.out.print("\nShould Not contain these..\n");
                 System.out.print("contain(27): "+bst.contains(27)+"\n"); 
                 System.out.print("contain(47): "+bst.contains(47)+"\n");
                 System.out.print("contain(17): "+bst.contains(17)+"\n"); 
                 System.out.print("contain(77): "+bst.contains(77)+"\n"); 


                 //////////////////////////////////////////////
                 System.out.print("\nTESTING getElementLevel Method:\n");
                 System.out.print("getElementLevel(43)): "+bst.getElementLevel(43)+"\n"); 
                 System.out.print("getElementLevel(0): "+bst.getElementLevel(0)+"\n"); 
                 System.out.print("getElementLevel(-2): "+bst.getElementLevel(-2)+"\n");
                 System.out.print("getElementLevel(33): "+bst.getElementLevel(33)+"\n"); 
                 System.out.print("getElementLevel(99): "+bst.getElementLevel(99)+"\n"); 

                 //////////////////////////////////////////////
                 System.out.print("\nTESTING getAncestorsOf Method: ");
                	
                 System.out.print("\ngetAncestorsOf(43): "); 
                  if(bst.getAncestorsOf(43) == null) {
                	  System.out.print("Not Exist!");
                  }else {
           	         for(int i : bst.getAncestorsOf(43)) {
           	         System.out.print(i+" ");
           	       }
                  }
                  System.out.print("\ngetAncestorsOf(40): "); 
                  if(bst.getAncestorsOf(40) == null) {
                	  System.out.print("Not Exist!");
                  }else {
           	         for(int i : bst.getAncestorsOf(40)) {
           	         System.out.print(i+" ");
           	       }
                  }
                  System.out.print("\ngetAncestorsOf(8): "); 
                  if(bst.getAncestorsOf(8) == null) {
                	  System.out.print("Not Exist!");
                  }else {
           	         for(int i : bst.getAncestorsOf(8)) {
           	         System.out.print(i+" ");
           	       }
                  }                	  
                  System.out.print("\ngetAncestorsOf(14): "); 
                  if(bst.getAncestorsOf(14) == null) {
                	  System.out.print("Not Exist!");
                  }else {
           	         for(int i : bst.getAncestorsOf(14)) {
           	         System.out.print(i+" ");
           	       }
                  }
                  System.out.print("\ngetAncestorsOf(33): "); 
                  if(bst.getAncestorsOf(33) == null) {
                	  System.out.print("Not Exist!");
                  }else {
           	         for(int i : bst.getAncestorsOf(33)) {
           	         System.out.print(i+" ");
           	       }
                  }
                  System.out.print("\ngetAncestorsOf(66): "); 
                  if(bst.getAncestorsOf(66) == null) {
                	  System.out.print("Not Exist!");
                  }else {
           	         for(int i : bst.getAncestorsOf(66)) {
           	         System.out.print(i+" ");
           	       }
                  }
                  System.out.print("\ngetAncestorsOf(6): "); 
                  if(bst.getAncestorsOf(6) == null) {
                	  System.out.print("Not Exist!");
                  }else {
           	         for(int i : bst.getAncestorsOf(6)) {
           	         System.out.print(i+" ");
           	       }
                  }
                	

     		     //////////////////////////////////////////////
                      System.out.print("\n\nTESTING getElementLevel Method:");
                      System.out.print("\ngetElementLevel(43): "+bst.getElementLevel(43)+"\n"); 
                      System.out.print("getElementLevel(40): "+bst.getElementLevel(40)+"\n"); 
                      System.out.print("getElementLevel(25): "+bst.getElementLevel(25)+"\n"); 
                      System.out.print("getElementLevel(60): "+bst.getElementLevel(60)+"\n"); 
                      System.out.print("getElementLevel(6): "+bst.getElementLevel(6)+"\n"); 

               
               
                      
		    }else{
				System.out.print("\n****** predefined data ******\n\n");

				bst.insert((40));
				bst.insert((20));
				bst.insert((10));
				bst.insert((30));
				bst.insert((60));
				bst.insert((50));
				bst.insert((70));
				
                 //////////////////////
                 System.out.print("\nTESTING empty method: check after insert\n");
                 System.out.print("Tree is empty: "+ bst.empty()+"\n");

				 System.out.println("\n");
				 System.out.print(bst);
				 System.out.println("\n");
		         System.out.print("\nTESTING getTreeHeight method:  -> ");
				 System.out.println("Tree hight is:  "+bst.getTreeHeight());
		         System.out.print("\nTESTING size method:  -> ");
				 System.out.println("Number of elements:  "+bst.size());
		         System.out.print("\nTESTING getLeafNodeCount method: -> ");
				 System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");

				 
				 //////////////////////////////////////////////
		         System.out.print("TESTING getPreOrderTraversal Method:\n");  
		          for(int i : bst.getPreOrderTraversal()) {
		            	System.out.print(i+", ");
		          }
		            
		            System.out.print("\n\nTESTING getInOrderTraversal Method:\n");  
		          for(int i : bst.getInOrderTraversal()) {
		            	System.out.print(i+", ");
		          }
		            
		            System.out.print("\n\nTESTING getPostOrderTraversal Method:\n");  
		          for(int i : bst.getPostOrderTraversal()) {
		            	System.out.print(i+", ");
		          }
		 		    
		 		    

			    ////////////////////////////////////////////////
			    System.out.println("\n\n\nTESTING INSERT Method: inserting elements in this order:" + 
			    		         " 66,25,2,31,13,99,-2,59,43 \n");  
			    bst.insert((66));
	        	bst.insert((25));
	        	bst.insert((2));
	        	bst.insert((31));
	        	bst.insert((13));
	        	bst.insert((99));
	        	bst.insert((-2));
	        	bst.insert((59));
	        	bst.insert((43));

	        	
	 		    System.out.print(bst);
	 		    System.out.println("\n");
	            System.out.print("\nTESTING getTreeHeight method:  -> ");
	 		    System.out.println("Tree hight is:  "+bst.getTreeHeight());
	            System.out.print("\nTESTING size method:  -> ");
	 		    System.out.println("Number of elements:  "+bst.size());
	            System.out.print("\nTESTING getLeafNodeCount method: -> ");
	 		    System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");

			   
	 		 
	 		    
	 		    
			  //////////////////////////////////////////////////
			    System.out.print("\n\n\nTESTING REMOVE Method: removing elements in this order:" + 
	   		         " 6,13,99,-2,65,43,60\n");	   
	        	bst.remove((6));
	        	bst.remove((13));
	        	bst.remove((99));
	        	bst.remove((-2));
	        	bst.remove((65));
	        	bst.remove((43));
	        	bst.remove((60));

			    
			    
			    
			
	        	System.out.println("\n");
	 		    System.out.print(bst);
	 		    System.out.println("\n");
	            System.out.print("\nTESTING getTreeHeight method:  -> ");
	 		    System.out.println("Tree hight is:  "+bst.getTreeHeight());
	            System.out.print("\nTESTING size method:  -> ");
	 		    System.out.println("Number of elements:  "+bst.size());
	            System.out.print("\nTESTING getLeafNodeCount method: -> ");
	 		    System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");
	 
			     
	             ////////////////////////////////////////////////
	               System.out.print("\nTESTING INSERT Method After Remove: Reinserting elements in this order:" + 
	             " 6,99,65,-2 \n"); 
	               bst.insert((6));
	               bst.insert((99));
	               bst.insert((65));
	               bst.insert((-2));
	               



	                 System.out.println("\n");
	                 System.out.print(bst);
	                 System.out.println("\n");
	                 System.out.println("Tree hight is:  "+bst.getTreeHeight());
	                 System.out.println("Number of elements:  "+bst.size());
	                 System.out.println("Number of leafs :  "+bst.getLeafNodeCount()+"\n");
			     
			     //////////////////////////////////////////////
	                 System.out.print("\nTESTING contains Method:\n");
	                 System.out.print("\nShould contain these..\n");
	                 System.out.print("contain(20): "+bst.contains(40)+"\n"); 
	                 System.out.print("contain(40): "+bst.contains(40)+"\n");
	                 System.out.print("contain(10): "+bst.contains(40)+"\n"); 
	                 System.out.print("contain(70): "+bst.contains(40)+"\n"); 

	                 System.out.print("\nShould Not contain these..\n");
	                 System.out.print("contain(27): "+bst.contains(27)+"\n"); 
	                 System.out.print("contain(47): "+bst.contains(47)+"\n");
	                 System.out.print("contain(17): "+bst.contains(17)+"\n"); 
	                 System.out.print("contain(77): "+bst.contains(77)+"\n"); 


	                 //////////////////////////////////////////////
	                 System.out.print("\nTESTING getElementLevel Method:\n");
	                 System.out.print("getElementLevel(43)): "+bst.getElementLevel(43)+"\n"); 
	                 System.out.print("getElementLevel(0): "+bst.getElementLevel(0)+"\n"); 
	                 System.out.print("getElementLevel(-2): "+bst.getElementLevel(-2)+"\n");
	                 System.out.print("getElementLevel(33): "+bst.getElementLevel(33)+"\n"); 
	                 System.out.print("getElementLevel(99): "+bst.getElementLevel(99)+"\n"); 

	                 //////////////////////////////////////////////
	                 System.out.print("\nTESTING getAncestorsOf Method: ");
	                	
	                 System.out.print("\ngetAncestorsOf(43): "); 
	                  if(bst.getAncestorsOf(43) == null) {
	                	  System.out.print("Not Exist!");
	                  }else {
	           	         for(int i : bst.getAncestorsOf(43)) {
	           	         System.out.print(i+" ");
	           	       }
	                  }
	                  System.out.print("\ngetAncestorsOf(40): "); 
	                  if(bst.getAncestorsOf(40) == null) {
	                	  System.out.print("Not Exist!");
	                  }else {
	           	         for(int i : bst.getAncestorsOf(40)) {
	           	         System.out.print(i+" ");
	           	       }
	                  }
	                  System.out.print("\ngetAncestorsOf(8): "); 
	                  if(bst.getAncestorsOf(8) == null) {
	                	  System.out.print("Not Exist!");
	                  }else {
	           	         for(int i : bst.getAncestorsOf(8)) {
	           	         System.out.print(i+" ");
	           	       }
	                  }                	  
	                  System.out.print("\ngetAncestorsOf(14): "); 
	                  if(bst.getAncestorsOf(14) == null) {
	                	  System.out.print("Not Exist!");
	                  }else {
	           	         for(int i : bst.getAncestorsOf(14)) {
	           	         System.out.print(i+" ");
	           	       }
	                  }
	                  System.out.print("\ngetAncestorsOf(33): "); 
	                  if(bst.getAncestorsOf(33) == null) {
	                	  System.out.print("Not Exist!");
	                  }else {
	           	         for(int i : bst.getAncestorsOf(33)) {
	           	         System.out.print(i+" ");
	           	       }
	                  }
	                  System.out.print("\ngetAncestorsOf(66): "); 
	                  if(bst.getAncestorsOf(66) == null) {
	                	  System.out.print("Not Exist!");
	                  }else {
	           	         for(int i : bst.getAncestorsOf(66)) {
	           	         System.out.print(i+" ");
	           	       }
	                  }
	                  System.out.print("\ngetAncestorsOf(6): "); 
	                  if(bst.getAncestorsOf(6) == null) {
	                	  System.out.print("Not Exist!");
	                  }else {
	           	         for(int i : bst.getAncestorsOf(6)) {
	           	         System.out.print(i+" ");
	           	       }
	                  }
	                	

	     		     //////////////////////////////////////////////
	                 System.out.print("\n\nTESTING getElementLevel Method:");
	                 System.out.print("\ngetElementLevel(43): "+bst.getElementLevel(43)+"\n"); 
	                 System.out.print("getElementLevel(40): "+bst.getElementLevel(40)+"\n"); 
	                 System.out.print("getElementLevel(25): "+bst.getElementLevel(25)+"\n"); 
	                 System.out.print("getElementLevel(60): "+bst.getElementLevel(60)+"\n"); 
	                 System.out.print("getElementLevel(6): "+bst.getElementLevel(6)+"\n"); 

			}
		 
		}catch(FileNotFoundException e) {
			System.out.print("\n***** File is Not found! ******\n");
		
		}finally{
	   
	        System.out.println("\n======= Thanks for using the BST test program."
				+ " Goodbye! ========\n");
	        file.close();
		}
	}
}
	

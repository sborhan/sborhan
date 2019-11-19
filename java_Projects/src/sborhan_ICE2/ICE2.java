/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_ICE2;

import java.io.FileNotFoundException;

public class ICE2 {

	public static void main(String[] args) throws FileNotFoundException {
		BST bst = new BST();
		 //checking add method
		
		bst.add(13);
		bst.add(11);
		bst.add(15);
		bst.add(10);
		bst.add(12);
		bst.add(9);
		bst.add(16);
		bst.add(14);


		
		bst.getAncestorsOf(14);
		bst.printAncestors(14);
		
		
		//Printing and Traversing BST with inorder && preorder && postorder methods
		System.out.print("inorder : ");
		bst.inorder();
		System.out.println("\n========================");
		System.out.print("preorder : ");
		bst.preorder();
		System.out.println("\n========================");
		System.out.print("postorder : ");
		bst.postorder();
		System.out.println("\n========================\n");

		//checking delete method
		System.out.print("\n10,13,14,16 are deleted..." );
		bst.delete(10);
		bst.delete(13);
	 	bst.delete(14);
	 	bst.delete(16);
		

		//check has method
		System.out.print("\nis 4 availabe in BST: "+bst.has(4)+"\n" );
		bst.add(4);
		System.out.print("\n4 is added..." );

		System.out.print("\nis 4 availabe in BST: "+bst.has(4)+"\n" );

		
		
		//Printing and Traversing BST with inorder && preorder && postorder methods
		System.out.print("inorder : ");
		bst.inorder();
		System.out.println("\n========================");
		System.out.print("preorder : ");
		bst.preorder();
		System.out.println("\n========================");
		System.out.print("postorder : ");
		bst.postorder();
		System.out.println("\n========================\n");

		
		
		
		BST bst1 = new BST();
		// reading file and insert the values in the BST
		System.out.print("\nreading file and insert the values in the BST...\n" );

		bst1.sortFile();
		
		
		//Printing and Traversing BST with inorder && preorder && postorder methods
		System.out.print("inorder : ");
		bst1.inorder();
		System.out.println("\n========================");
		System.out.print("preorder : ");
		bst1.preorder();
		System.out.println("\n========================");
		System.out.print("postorder : ");
		bst1.postorder();
		

	}

}

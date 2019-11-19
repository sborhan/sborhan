
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_ICE2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import sborhan_p1.BST.Node;

public class BST {

	private static final String FILENAME = "integers.dat";

	private Node root;
	
	//reading file
	public void sortFile() throws FileNotFoundException {
        Scanner file = new Scanner(new File(FILENAME));
        while (file.hasNext()) {
            add(file.nextInt());
        }
      file.close();
    } 
	
	//////////////////////////////
	
	 public ArrayList<Integer> getAncestorsOf(int val){
	    	List<Integer> list = new ArrayList<>();
	    	boolean bool = getAncestorsOf(root, val,list);
	    	
	    	return (bool != false) ? (ArrayList<Integer>) list : null;
	    }
	    private boolean getAncestorsOf(Node node, int val,List<Integer> list) {
	    	//base case
	    	if(node == null) {
	    		return false;
	    	}
	    	//return true if value is found
	    	if (node.key == val) {
	    		return true;
	    	}
	    	
	    	//search value in left of tree
	    	boolean left =getAncestorsOf(node.left,val,list);
	    	 
	    	//seach value in right of tree
	    	boolean right = false;
	    	if(!left) {
	    		right = getAncestorsOf(node.right,val,list);
	    	}
	    	//if value is found in either left or right side of tree
	    	//current value is an ancestor of given value
	    	if(left || right) {
	    		list.add(node.key);
	    	}
	    	
	    	//return true if node is found
	    	return left || right;   		
	    	
	    }
	    
	   public void printAncestors(int value) {
		   ArrayList<Integer> list =  getAncestorsOf(value);
		  for (int i : list){
			   System.out.print(i+" ,");
		   }
		   System.out.print("\n");

	   }

	
	
	//////////////////
	
	
	
	
	
	
	//Displaying BST in inorder style
	public void inorder() {
		inorder(root);
	}
	private void inorder(Node node) {
		if(node != null) {
		  inorder(node.left);
		  System.out.print(node.key+",");
		  inorder(node.right);
		}
	}
	
	//Displaying BST in preorder style

	public void preorder() {
		preorder(root);
	}
	private void preorder(Node node) {
		if(node != null) {
		  System.out.print(node.key+",");
		  preorder(node.left);
		  preorder(node.right);
		}
	}
	
	//Displaying BST in postorder style
	public void postorder() {
		postorder(root);
	}
	private void postorder(Node node) {
		if(node != null) {
		  postorder(node.left);
		  postorder(node.right);
		  System.out.print(node.key+",");

		}
	}
	
	//inserting value
	public void add(int key) {
		root = add(root,key);
	}
	private Node add(Node node,int key) {
		Node newNode = new Node(key);
		
		if(node == null) {
			node = newNode;
			return node;
		}
		
		if( key < node.key) {
			node.left = add(node.left,key);
		}else {
			node.right = add(node.right,key);
		}
		return node;
	}
	
	// searching a value
	public boolean has(int key) {
		Node node = has(root,key);
		return node == null ? false : true;
	}
	private Node has(Node node,int key) {
		if(node == null || node.key == key) {
			return node;
		}else if(key < node.key) {
			return has(node.left,key);
		}else if (key > node.key) {
			return has(node.right,key);
		}
		return null;
	}
	
	// deleting a value
	public Node findMin(Node node) {
		return node.min();
	}
	public void delete(int key) {
		
		root = delete(root,key);
		
	}
	private Node delete(Node node,int key) {
		if(node == null) {
			return null;
		}else if(key < node.key) {
			node.left = delete(node.left,key);
		}else if(key > node.key) {
			node.right = delete(node.right,key);
		}else { // this is the node we want to delete
			    // case 1 : No child
			if (node.left == null && node.right == null) {
				node = null;
				
				//case 2 : One child
			}else if(node.left == null) {
				node = node.right;
				//case 3 : Two children
			}else if(node.right == null) {
				node = node.left;
				//case 3 : Two children
			}else {
				//Find the minimum node on the right(could also max the left)
				Node minRight = findMin(node.right);
				
				//duplicate it by copying its value here
				node.key = minRight.key;
				//Now delete the node we just duplicated
				node.right = delete(node.right,node.key);
			}
			
		}
		return node;
	}

}

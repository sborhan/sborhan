
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_ICE2;

public class Node {

	Node left;
	Node right;
	int key;
	
	
	public Node(int key) {
		this.key= key;
		right = null;
		left  = null;
	
	}
	
	public Node min() {
		if(left == null) {
			return this;
		}else {
			return left.min();
		}
	}
	
}


/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package sborhan_p1x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * class BSTX
 * 
 * Implementation of a generic BSTX class
 * Implement a batch constructor.
 * Implement a copy constructor.
 * Implement equalsTree(BSTX<E> other)
 * Implement getElementsInRange()
 * 
 * @author SAM BORHAN
 * @param <E>
 * @version 01
 */

public class BSTX<E extends Comparable<E>> {

	
	
	/**
	 * Nested class Node
	 * Implementation of a generic Node class
	 *
	 * @author SAM Borhan
	 *
	 * @param <E> : generic <E> value
	 */
	private static class Node<E extends Comparable<E>> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        /**
         * constructor of Inner class Node
         * @param value : <E> type generic
         */
        private Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        
        /**
         * method isLeaf
         * @return boolean : return true if No children
         */
        private boolean isLeaf() {
        	return left == null ? right == null : false; 
       }
	}
	
	
	    //private fields of BST class
		private Node<E> root;
	    private int count;
	    
       /**
        * testing extra implementations in BSTX :
        * Implement a batch constructor.
        * Implement a copy constructor.
        * Implement equalsTree(BSTX<E> other)
        * Implement getElementsInRange()
        * @param args
        */
        public static void main(String[] args) {
	    	
	    	Integer[] list = {5,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};
	    	BSTX<Integer> bstx = new BSTX<>(list);
	    	
	    	System.out.println("\nTesting batch loading with sorted array..");
	    	System.out.println("5 10 20 30 40 50 60 70 80 90 100 110 120 130 140 150\n");
	    	System.out.println("\nTree after batch loading: ");
	    	
	    	System.out.println(bstx);
	    	
	    	
	    	///////////
	    	System.out.println("\nTesting range operations...");
	    	System.out.print("\nbstx.getElementsInRange(0,1) :"+bstx.getElementsInRange(0,1));
	    	System.out.print("\nbstx.getElementsInRange(5,20) :"+bstx.getElementsInRange(5,20));
	    	System.out.print("\nbstx.getElementsInRange(48,95) :"+bstx.getElementsInRange(48,95));

	    	System.out.println("\n\n\nTesting copy and equality operations..");
	    	System.out.println("Created a copy of the BST:\n");

	    	BSTX<Integer> bstx2 = new BSTX<>(bstx);;
	    	System.out.println(bstx2);

	    	System.out.println("\nTrees are equal (expect true): "+bstx.equalsTree(bstx2));
	    	System.out.println("\nRemoving an element from the copy: 5 ");
	    	bstx2.remove(5);
	    	System.out.println(bstx2);

	    	System.out.println("\nTrees are equal (expect false): "+bstx.equalsTree(bstx2));
	    	
	    	BSTX<Integer> bstx3 = new BSTX<>(list);
	    	BSTX<Integer> bstx4 = new BSTX<>(list);
	    	System.out.println("\nTwo empty trees are equal (expect true): "+bstx3.equalsTree(bstx4));
	  	
	    }
	    
       
	    /**
		 * Batch loading ctor. The data must be sorted, and without duplicates.
		 * @param sortedElements data to load. Assumes that the elements are
		 *                       sorted.
		 */
		public BSTX(E[] sortedElements) {
		    this.count = 0;
		    int lftDataIdx = 0;
		    int rgtDataIdx = sortedElements.length-1;   // exclusive right bound
		    this.root = createBalancedNodeFrom(sortedElements, lftDataIdx, rgtDataIdx);
		}

		/**
		 * TODO: Implement this recursive helper method.
		 * @param elements TODO
		 * @param lftIdx TODO
		 * @param rgtIdx (exclusive) TODO
		 * @return a balanced Node from the range of data, null if range is empty
		 */
		private Node<E> createBalancedNodeFrom(E[] elements, int lftIdx, int rgtIdx) {
		    // TODO: Implement
			
			 /* Base Case */
		    if (lftIdx > rgtIdx)  
		    return null;  
		  
		    /* Get the middle element and make it root */
		    //int mid = (lftIdx + rgtIdx)/2;
		    int mid=lftIdx + ((rgtIdx+1)-lftIdx)/2;
		    
		    Node<E> root = new Node<>(elements[mid]);  
		  
		    /* Recursively construct the left subtree  
		    and make it left child of root */
		    root.left = createBalancedNodeFrom(elements, lftIdx,  
		                                    mid - 1);  
		  
		    /* Recursively construct the right subtree  
		    and make it right child of root */
		    root.right = createBalancedNodeFrom(elements, mid + 1, rgtIdx); 
	
			return root;
		}
	
	    
	    /**
	     * Copy constructor. Makes a deep copy of the passed object.
	     * @param other BSTX object to deep copy.
	     */
	    public BSTX(BSTX<E> other) {
	       this.root = getSubtreeDeepCopy(other.root);
	       this.count = other.count;
	    }

	    /**
	     * TODO: Implement this recursive helper method that returns a deep
	     * copy of the given subtree rooted at the node.
	     * using pre-order traversal.
	     * @param node :Node<E> 
	     * @return Node<E> :a deep copy of the given subtree rooted at the node
	     */
	    private Node<E> getSubtreeDeepCopy(Node<E> node) {
	    	if (node == null)
	        {
	            return null;
	        }
	        Node<E> newNode = new Node<>(node.value);
	        newNode.left= getSubtreeDeepCopy(node.left);
	        newNode.right= getSubtreeDeepCopy(node.right);
	        return newNode;
	    }

     
	    /**
	     * Class BSTX constructor
	     * 
	     */
	    public BSTX() {
	    	root = null;
	    	count =0;
	    }
	
	    
	   
	    /**
	     * Determine the elements present in the tree within the given inclusive
	     * range. Returns the elements in order.
	     * @param lowLimit  inclusive low limit of the range
	     * @param highLimit inclusive high limit of the range
	     * @return ArrayList of elements present within the given range, in order.
	     */
	    public ArrayList<E> getElementsInRange(E lowLimit, E highLimit) {
	        ArrayList<E> list = new ArrayList<E>();
	        addElementsInRange(this.root, lowLimit, highLimit, list);
	        return list;
	    }

	    /**
	     * TODO: Implement this recursive helper function.
	     * @param n    :  Node<E>
	     * This method stores all the values in an ArrayList 
	     * which in the given range (low , high).  
	     * 
	     * @param low  :  <E> generic value
	     * @param high : <E> generic value
	     * @param list : ArrayList<E>
	     */
	      
	    private void addElementsInRange(Node<E> n, E low, E high,ArrayList<E> list) {  
	     /* base case */
	     if ( n == null )  
	         return;  
	       
	     /*   
	         recurse for left subtree first  
	         If node value is greater than low,  
	         then only we can get values  
	         in left subtree */
	     if ( low.compareTo(n.value) < 0 )  
	    	 addElementsInRange(n.left, low, high,list);  
	       
	     /* if node value is in range,  
	     then store node value */
	     if ( low.compareTo(n.value) <= 0 && high.compareTo(n.value) >= 0 )  
	    	 list.add(n.value);  
	       
	     // If node value is smaller than high, 
	     // then get values in right subtree 
	     if ( high.compareTo(n.value) > 0 )  
	      	 addElementsInRange(n.right, low, high,list);  
	    }  
	    
	
	  
	    /**
	     * Indicates whether the other BST has the same structure as this object,
	     * and each node value of the other tree equals this object's node value.
	     * @param   other   the reference BST object with which to compare.
	     * @return  true if the contents of the other tree have the same
	     * structure and values as this tree.
	     */
	    public boolean equalsTree(BSTX<E> other) {
	        if (other == null || other.count != this.count) {
	            return false;
	        }
	        return subtreesAreEqual(this.root, other.root);
	    }

	    /**
	     * TODO: Implement this recursive helper function.
	     * @param t1 Tree rooted at the given node
	     * @param t2 Tree rooted at the given node
	     * @return true when the two subtrees are equal in structure and values
	     */ 
	    private boolean subtreesAreEqual(Node<E> t1, Node<E> t2) {
	        boolean rootEqual = false;
	        boolean lEqual = false;
	        boolean rEqual = false;    

	        if (t1 == null && t2 == null) {
	            return true;
	        }
	        if (t1 != null && t2 != null) {
	        	//check if both values are equal
	            rootEqual = t1.value.equals(t2.value);

	            if (t1.left !=null && t2.left != null) {
	                // compare the left
	                lEqual = subtreesAreEqual(t1.left, t2.left);
	            }
	            else if (t1.left == null && t2.left == null) {
	            	//if reach here means all lefts are equal
	                lEqual = true;
	            }
	            if (t1.right != null && t2.right != null) {
	                // compare the right
	                rEqual = subtreesAreEqual(t1.right, t2.right);
	            }
	            else if (t1.right == null && t2.right == null) {
	            	//if reach here means all rights are equal
	                rEqual = true;
	            }
                   // check all conditions if true
	            return (rootEqual && lEqual && rEqual);
	        }
	        return false;
	    } 

	
	/**
	 * getLeafNodeCount method to calculate number of leaf node in binary tree.
	 * using helper method
	 * @param node Node<E>
	 * @return Integer:  count of leaf nodes.
	 */ 
	 public int getLeafNodeCount() { 
		 
		return getLeafNodeCount(root);
	 } 
	 
	 /**
		 * overLoad method getLeafNodeCount
		 * getLeafNodeCount method to calculate number of leaf node in binary tree.
		 * @param node :Node<E>
		 * @return Integer: count of leaf nodes.
		 */
	 private int getLeafNodeCount(Node<E> node){ 
	  if (node == null) 
		  return 0;
	  if (node.isLeaf()) 
	   { 
		return 1; 
	   }
	 else { 
	   return getLeafNodeCount(node.left) + getLeafNodeCount(node.right); 
	 } 
	}
     
	
    
        /**
    	 * method insert
    	 * inserting value in BST
    	 * @param key: <E> generic Type
    	 */
    	public void insert(E insertValue) {
            root = insert(insertValue, root);
        }

    	/**
    	 * overLoad method add
    	 * @param v : <E> generic type value
    	 * @param curr : Node<E>
    	 * @return : Node<E>
    	 */
        private Node<E> insert(E v ,Node<E> curr) {
            if (curr == null) {
                count++;
                return new Node<E>(v);
            }
            if (( v.compareTo(curr.value) < 0))
                curr.left = insert(v, curr.left);
            else if (v.compareTo( curr.value) > 0)
                curr.right = insert(v, curr.right);
            else
            // this does nothing since keys are not a reference type,
            // but we'll keep it in to demonstrate
                curr.value   = v; 
            return curr;
        }

        /**
    	 * method contains
    	 * using helper method
    	 * @param searchValue : <E> generic type 
    	 * @return boolean to check if key exists
    	 */
        public boolean contains(E searchValue) {
    		return contains(searchValue, root);
    		 
    	}
    	/** 
    	 * overLoad method contains
    	 * 
    	 * @param v :<E> generic type
    	 * @param curr : Node<E>
    	 * @return boolean
    	 */
    	private boolean contains(E v, Node<E> curr) {
    	        if (curr == null)
    	            return false;
    	        else if (v.compareTo(curr.value) < 0)
    	            return contains(v, curr.left);  // Search the left branch
    	        else if (v.compareTo(curr.value) > 0)
    	            return contains(v, curr.right); // Search the right branch
    	        else // if (x == curr.value)
    	            return true;
    	    }
    		
    	
    	
    	
    	/**
         * method getMax
         * 
         * @param curr : Node<E>
         * @return :right branch Node<E> if available
         */
       private Node<E> getMax(Node<E> curr) {
           while (curr.right != null)
               curr = curr.right;
           return curr;
       }
    	
    	 	
    	/**
         * method remove
         * 
         * removing data from BST
         * using helper method
         * @param searchValue : <E> generic type value
         */
    	 public void remove(E searchValue) {
    	        root = remove(searchValue, root);
    	    }

    	 /**
    	  * overLoad method remove
          * removing data from BST
    	  * @param v: <E> generic type value
    	  * @param  Node<E> : curr
    	  * @return Node<E> 
    	  */
    	 private Node<E> remove(E v, Node<E> curr) {
    	        if (curr == null)
    	            return null; // x is not in the BST, so we "succeeded" before we even started

    	        if (v.compareTo(curr.value) < 0) {
    	            curr.left = remove(v, curr.left);
    	            return curr;
    	        } else if (v.compareTo(curr.value) > 0) {
    	            curr.right = remove(v, curr.right);
    	            return curr;
    	        } else {
    	            // x == curr.key, so remove this one
    	            if (curr.left == null) {
    	                count--;
    	                return curr.right;  // works also if curr is a leaf, since this would return null
    	            } else if (curr.right == null) {
    	                count--;
    	                return curr.left;
    	            } else {
    	                // has both right and left, so we need to swap with predecessor node
    	                // the predecessor is the max Node from left (equally could use successor node: min value from right)
    	               Node<E> rightMax = getMax(curr.left);
    	                // and then remove the node that had the predecessor
    	               curr.value = rightMax.value;
    	               
    	                curr.left = remove(curr.value, curr.left);
    	                return curr;
    	            }
    	        }
    	    }
 	 
    	 
    	 /**
    	     * method empty
    	     * @return boolean : return true if BST is empty
    	     */
    	    public boolean empty() {
    	        return count == 0;
    	    }
    	    
    	    /**
    	     * method size
    	     * @return integer : number of elements in BST
    	     */
    	    public int size() {
    	        return count;
    	    }   
    	    
    	    /**
    	     * method getPreOrderTraversal
    	     * Like preorder, we want all the keys in sorted order, but
    	     * instead of printing them out, return them in a list.
    	     *
    	     * @return ArrayList<E> :<E> generic type sorted list of keys from BST
    	     */
    	    public ArrayList<E> getPreOrderTraversal() {
    	        List<E> ret = new ArrayList<E>();
    	        preOrderTraversal(ret, root);
    	        return (ArrayList<E>) ret;
    	    }

    	    /**
    	     * method preOrderTraversal
    	     * @param ret  :List<E>
    	     * @param curr : Node<E>
    	     */
    	    private void preOrderTraversal(List<E> ret, Node<E> curr) {
    	    	 if (curr != null) {
     	             ret.add(curr.value);
     	            preOrderTraversal(ret,curr.left);
     	            preOrderTraversal(ret,curr.right);
    	         }
    	    }

    	    
    	
    	    
    	    /**
    	     * method getInOrderTraversal
    	     * Like inorder, we want all the keys in sorted order, but
    	     * instead of printing them out, return them in a list.
    	     *
    	     * @return ArrayList<E> :<E> generic type sorted list of keys from BST
    	     */
    	    public ArrayList<E> getInOrderTraversal() {
    	        List<E> ret = new ArrayList<E>();
    	        inOrderTraversal(ret, root);
    	        return (ArrayList<E>) ret;
    	    }

    	    /**
    	     * method inOrderTraversal
    	     * @param ret  :List<E>
    	     * @param curr : Node<E>
    	     */
    	    private void inOrderTraversal(List<E> ret, Node<E> curr) {
    	    	 if (curr != null) {
    	    		 inOrderTraversal(ret,curr.left);
    	             ret.add(curr.value);
    	             inOrderTraversal(ret,curr.right);
    	         }
    	    }
    	    
    	    
    	    
    	    
    	    /**
    	     * method getPostOrderTraversal
    	     * Like postorder, we want all the keys in sorted order, but
    	     * instead of printing them out, return them in a list.
    	     *
    	     * @return ArrayList<E> :<E> generic type sorted list of keys from BST
    	     */
    	    public ArrayList<E> getPostOrderTraversal() {
    	        List<E> ret = new ArrayList<E>();
    	        postOrderTraversal(ret, root);
    	        return (ArrayList<E>) ret;
    	    }

    	    /**
    	     * method postOrderTraversal
    	     * @param ret  :List<E>
    	     * @param curr : Node<E>
    	     */
    	    private void postOrderTraversal(List<E> ret, Node<E> curr) {
    	    	 if (curr != null) {
    	    		 postOrderTraversal(ret,curr.left);
    	    		 postOrderTraversal(ret,curr.right);
    	             ret.add(curr.value);

    	         }
    	    }
    	    
    	  
    	    /**
    	     * methodgetAncestorsOf
    	     * @param val :<E> generic type
    	     * @return :ArrayList<E> return list of ancestors if available
    	     */
    	    public ArrayList<E> getAncestorsOf(E val){
    	    	List<E> list = new ArrayList<>();
    	    	boolean bool = getAncestorsOf(root, val,list);
    	    	
    	    	return (bool != false) ? (ArrayList<E>) list : null;
    	    }
    	    
    	    /**
    	     * overLoad method getAncestorsOf
    	     * @param node :Node<E>
    	     * @param val : <E> generic type
    	     * @param list :List<E>
    	     * @return : boolean
    	     */
    	    private boolean getAncestorsOf(Node<E> node, E val,List<E> list) {
    	    	//base case
    	    	if(node == null) {
    	    		return false;
    	    	}
    	    	//return true if value is found
    	    	if (node.value == val) {
    	    		return true;
    	    	}
    	    	
    	    	//search value in left of tree
    	    	boolean left =getAncestorsOf(node.left, val,list);
    	    	
    	    	//seach value in right of tree
    	    	boolean right = false;
    	    	if(!left) {
    	    		right = getAncestorsOf(node.right,val,list);
    	    	}
    	    	//if value is found in either left or right side of tree
    	    	//current value is an ancestor of given value
    	    	if(left || right) {
    	    		list.add(node.value);
    	    	}
    	    	
    	    	//return true if node is found
    	    	return left || right;	    		
    	    	
    	    }
    	    
    	    /**
    	     * method getTreeHeight
    	     * 
    	     * the height is the number of levels it contains. 
    	     * A tree with 1 element has the height of 0.
    	     * 
    	     * @return integer : returns height of the tree. 
    	     */
    	
    	    public int getTreeHeight () {
    	    	return getTreeHeight(root);
    	    }
    	    
    	    private int getTreeHeight(Node<E> node) {
    	        if (node == null) {
    	            return -1;
    	        }

    	        int lefth = getTreeHeight(node.left);
    	        int righth = getTreeHeight(node.right);

    	        if (lefth > righth) {
    	            return lefth + 1;
    	        } else {
    	            return righth + 1;
    	        }
    	    }
    
    	 
    	 /**
    	  * method getElementLevel
    	  * 
    	  * using helper method 
    	  * @param target : <E> generic type
    	  * @return integers : returns the level of a given item in the tree
    	  *  if the item is not present in the tree, returns -1.
    	  */
    	 public int getElementLevel(E target) {
    		 return getElementLevel(root,target,1);
    	 }
    	 
    	 /**
    	  * overLoad method getElementLevel
    	  * 
    	  * @param key  : <E> generic type
    	  * @param level: integer
    	  * @param  node: Node<E>
    	  * @return integers : returns the level of a given item in the tree
    	  *  if the item is not present in the tree, returns -1.
    	  */
    	 private int getElementLevel(Node<E> node,E key,int level){
    			if(node == null)
    				return -1;
    			if(node.value == key)
    				return level;
    	 
    			int result=getElementLevel(node.left,key,level+1) ;
    			if(result != -1)
    			{ 
    				// If found in left subtree , return 
    				return result;
    			}
    			result= getElementLevel(node.right,key,level+1);
    	 
    		  return result;
    		}
    	    
 
    		/**
    		 * method toString
    	     * Returns a string representation of the BST object.
    	     * @return a string representation of the BST object
    	     */
    	    @Override
    	    public String toString() {
    	        return new TreePrinter().getStringReprOf(this.root);
    	    }
    	    /**
    	     * class TreePrinter
    	     * Helper to aid in printing the tree.
    	     */
    	    private class TreePrinter {

    	        /**
    	         * Generates the string representation of the given tree rooted at the
    	         * node
    	         * @param node tree to represent
    	         * @return String representation of the given tree rooted at the node
    	         */
    	        private String getStringReprOf(Node<E> node) {
    	            if (node == null) {
    	                return "(empty)";
    	            }

    	            Block blk = getBlock(node);
    	            StringBuilder sb = new StringBuilder();
    	            for (StringBuilder line : blk.lines) {
    	                sb.append(line).append('\n');
    	            }
    	            return sb.toString();
    	        }

    	        private Block getBlock(Node<E> node) {
    	            // min spacing between left and right blocks
    	            final int SP = 2;

    	            // base case
    	            if (node == null) {
    	                return null;
    	            }

    	            Block lft = getBlock(node.left);
    	            Block rgt = getBlock(node.right);
    	            boolean hasLft = lft != null;
    	            boolean hasRgt = rgt != null;

    	            // root value and root length
    	            String val = node.value.toString();
    	            int len = node.value.toString().length();

    	            // how much the right block needs to be shifted and the width of all
    	            int rgtShift = hasLft ? (lft.width + SP) : 0;
    	            int width = rgtShift + (hasRgt ? rgt.width : 0);

    	            // where should the root attach if there is left blk?
    	            int rootIdx = hasLft ? lft.toIdx + 1 : 0;

    	            // where should the root be positioned if also have right blk?
    	            if (hasRgt) {
    	                int rgtRootAttachIdx = rgt.fmIdx + rgtShift - 1 - len;
    	                if (rgtRootAttachIdx < rootIdx) {
    	                    // the right block needs to move right more
    	                    int moreShift = rootIdx - rgtRootAttachIdx;
    	                    rgtShift += moreShift;
    	                    width += moreShift;
    	                } else {
    	                    // the root needs to be positioned in-between
    	                    rootIdx = rootIdx + (rgtRootAttachIdx - rootIdx) / 2;
    	                }
    	            } else {
    	                width = Math.max(width, rootIdx + len);
    	            }

    	            // build the line with the root
    	            StringBuilder line = new StringBuilder();
    	            padUntil(line, ' ', rootIdx);
    	            line.append(val);
    	            padUntil(line, ' ', width);

    	            // start building a new block
    	            Block result = new Block();
    	            result.lines.add(line);

    	            // build the line with the leads if have children
    	            if (hasLft || hasRgt) {
    	                line = new StringBuilder();
    	                if (hasLft) {
    	                    padUntil(line, ' ', lft.toIdx);
    	                    padUntil(line, '_', rootIdx - 1);
    	                    line.append('/');
    	                }
    	                if (hasRgt) {
    	                    padUntil(line, ' ', rootIdx + len);
    	                    line.append('\\');
    	                    padUntil(line, '_', rgt.fmIdx + rgtShift);
    	                }
    	                padUntil(line, ' ', width);
    	                result.lines.add(line);
    	            }

    	            // add combined children lines
    	            result.lines.addAll(combinedLines(lft, rgt, rgtShift));
    	            result.width = width;
    	            result.fmIdx = rootIdx;
    	            result.toIdx = rootIdx + len;
    	            return result;
    	        }

    	        /**
    	         * Combines the children blocks with the given shift
    	         * @param lft Left Block to combine
    	         * @param rgt Right Block to combine
    	         * @param shift amount to shift the right block
    	         * @return combined lines
    	         */
    	        private ArrayList<StringBuilder> combinedLines(Block lft, Block rgt,
    	                                                       int shift) {
    	            ArrayList<StringBuilder> lines = new ArrayList<StringBuilder>();
    	            if (lft == null) {
    	                if (rgt != null) {
    	                    for (StringBuilder sb : rgt.lines) {
    	                        StringBuilder line = new StringBuilder();
    	                        padSpUntil(line, shift);
    	                        line.append(sb);
    	                        lines.add(line);
    	                    }
    	                }
    	                return lines;
    	            } else if (rgt == null) {
    	                return lft.lines;
    	            }

    	            final Iterator<StringBuilder> lftIt = lft.lines.iterator();
    	            final Iterator<StringBuilder> rgtIt = rgt.lines.iterator();

    	            while (lftIt.hasNext() || rgtIt.hasNext()) {
    	                StringBuilder sb =
    	                    lftIt.hasNext() ? lftIt.next() : new StringBuilder();
    	                padSpUntil(sb, shift);
    	                if (rgtIt.hasNext()) {
    	                    sb.append(rgtIt.next());
    	                }
    	                lines.add(sb);
    	            }
    	            return lines;
    	        }

    	        /**
    	         * Helper to add multiple characters to the StringBuilder
    	         * @param sb  StringBuilder to append to
    	         * @param c   character to add
    	         * @param len add until sb is this length
    	         */
    	        private void padUntil(StringBuilder sb, char c, int len) {
    	            while (sb.length() < len) {
    	                sb.append(c);
    	            }
    	        }

    	        /**
    	         * Helper to add multiple characters to the StringBuilder
    	         * @param sb  StringBuilder to pad
    	         * @param len add until sb is this length
    	         */
    	        private void padSpUntil(StringBuilder sb, int len) {
    	            while (sb.length() < len) {
    	                sb.append(' ');
    	            }
    	        }

    	        /**
    	         * Print Block
    	         */
    	        private class Block {
    	            // String lines
    	            ArrayList<StringBuilder> lines = new ArrayList<StringBuilder>();
    	            int fmIdx = 0;  // index of the root value start on 1st line
    	            int toIdx = 0;  // index of the root value end on 1st line
    	            int width = 0;  // how wide the lines are
    	        }
    	    }

    	}


    
 


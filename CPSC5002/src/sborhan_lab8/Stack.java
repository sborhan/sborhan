

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab8;


/*
 *class Stack
 *
 *making generic <T> stack.
 *
 * @author Sam Borhan
 * @version 1.0
 */

public class Stack<T>
{
	

    //====== Inner class Node =======
   private class Node {

   	//======= Inner class Fields ======
       public Node next ;
       // value has a generic <T>  type
       public T value;
       

       /*
        * Inner class constructor
        * 
        * @param value : <T> generic type
        * @param next : Node
        * 
        */
       public Node(T value, Node next) {
          
           this.value = value;
           this.next = next;
       }
       
   }
	
	
	
	//======== class Stack private fields =============

   private Node top;
	

/*
 *  Constructor
 *  
*/
	
  public Stack ()
  {
	  
	  top =null;
 }

/*
 * The empty method checks for an empty stack.
 * @return true if stack is empty.
*/

 public boolean empty() 
 { 
	return(top== null);
       
 }

/*
 *  The push method pushes a value onto the stack.
 *  @param v:<T> generic type.. T
*/

 public void push(T v) 
 {
     top = new Node(v,top);
     
     System.out.println(top.value+":pushed");
                    
 }


/*  
  *The pop method pops a value off the stack.
  *
  * @return : <T> generic type value popped.
  * @exception EmptyStackException When the 
  * stack is empty.
*/
 public T pop()
 {
    if (empty()) {
    	throw new IllegalArgumentException("too many operators!");
    	
    }
    else
    {
    	T data = top.value;
        System.out.println("\n"+top.value+": poped");

    	top = top.next;
       return data;
    }
 }

/*
 * top of the stack.
 *  @return <T> generic type value at top of the stack.
 *	@exception EmptyStackException When the 
 *	stack is empty.
*/
 public T peek()
  {
    if (empty()) {
    	throw new IllegalArgumentException("empty stack!");
    }
    else
    {
        return top.value;
    }
  }
 
 /*
  * method equals
  * check if 2 stacks are equals
  * @param stack :Stack<T>
  * @return boolean
  */
 
 public boolean equals(Stack<T> stack){
 	Stack<T> copyofOrig=this.copy();
 	
     boolean bool = false;
 	 if(copyofOrig.empty()) {
		 return false;
	 }
	 
 	for(Node p =stack.top;p != null;p=p.next) {
 		if(!copyofOrig.empty()) {
		    if(p.value == copyofOrig.pop()) {
			    bool=true;
		    }else {
			  return false;
		    }
		    System.out.println("\n copy is empting out\n");
 		}
 		
	 }
	
 	if(copyofOrig.empty())    	
    	 return bool;
     	
     	else
     		return false; 
 	}
 
 
 
 
 
 
 /*
  * copy method
  * using private reverseCopy method
  *  @return <T> generic copy of a stack.
  *	
 */
 public Stack<T> copy(){
	 
	 Stack<T> copyStack = new Stack<>();
	 
	 
	 for(Node p = reverseCopy().top;p != null;p=p.next) {
		 copyStack.push(p.value);
	 }
 
	 return copyStack;
 }
 
 /*
  * reverseCopy method
  * will use in to the copy method to make the value be in stack style
  *  @return <T> generic copy of a stack.
  *	
 */
private Stack<T> reverseCopy(){
	 
	 Stack<T> copyStack = new Stack<>();
	 
	 
	 for(Node p = top;p != null;p=p.next) {
		 copyStack.push(p.value);
	 }
     System.out.println("\nmaking reversing of List:.....\n");

	 return copyStack;
 }
 
 
 
 
 
 /*
  * method toString
  * 
  * String representation of the queue with generic <T> type contents.
  *
  * @return: string representation
  */
 public String toString()
 {	  
	  StringBuilder builder = new StringBuilder();
	  Node p = top;
	  builder.append("List :");
	 while(p != null) {
	   builder.append(p.value+" | ");
	   p=p.next;
	 }
	 builder.append("\npeek is :"+peek());
	 
	 return builder.toString();
 }
 
 
}
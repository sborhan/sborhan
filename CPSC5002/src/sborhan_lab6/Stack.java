

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab6;





/*
 *class Stack
 *
 *Array Implementation of a stack.
 *
 * @author Sam Borhan
 * @version 1.0
 */

public class Stack
{
	//======== class Stack private fields =============
    private double [] s;  // Holds stack elements
	private int top;   // Stack top pointer
	private int size;

/*
 *  Constructor
 *  @param capacity The capacity of the stack.
*/
	
  public Stack (int capacity)
  {
	size= capacity;
    s = new double[size];
    top = -1;
 }

/*
 * The empty method checks for an empty stack.
 * @return true if stack is empty.
*/

 public boolean empty() 
 { 
	return(top==-1);
       
 }

/*
 *  The push method pushes a value onto the stack.
 *  @param x The value to push onto the stack.
 *	@exception StackOverflowException When the 
 *	stack is full.
*/

 public void push(double x) 
 {
    if (top == s.length) 
    {
    	throw new IllegalArgumentException("full stack!");
    }
    
    
    else
    {
       s[++top] = x;
                 
    }         
 }

/*
 * method getTop
 * get the index of top
 * 
 * @return :integer
 */
 public int getTop() {
	return top;
 }

/*  
  *The pop method pops a value off the stack.
  *
  * @return The value popped.
  * @exception EmptyStackException When the 
  * stack is empty.
*/

 public double pop()
 {
    if (empty()) {
    	throw new IllegalArgumentException("too many operators!");
    	
    }
    else
    {
       return s[top--];
    }
 }

/*
 *  The peek method returns the value at the
 * top of the stack.
 *  @return value at top of the stack.
 *		@exception EmptyStackException When the 
 *		stack is empty.
*/

  double peek()
  {
    if (empty()) {
    	throw new IllegalArgumentException("empty stack!");
    }
    else
    {
        return s[top];
    }
  }
 /*
  * method getSize
  * return the size of the array(stack capacity)
  * @return : integer
  * 
  */
  int getSize()
  {
	 return size;
  }
 
}
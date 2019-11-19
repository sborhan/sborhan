

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab6;



/*
 *class RPN
 *
 * doing all the calculation using evaluate method
 *
 * @author Sam Borhan
 * @version 1.0
 */
public class RPN
{
	// ========class RPN private fields========
	private String[] userInput;
	private boolean isFirstOperator;
	private boolean hasOperator;
	private int digitCounter;
	
	
	/*
     *  constructor
     *@param str : String
     */
	public RPN (String str) {
		
		userInput =str.split(" ");
		isFirstOperator = true;
		hasOperator = false;
		digitCounter = 0;
		
	}
	
	/*
     * method evaluate
     *
     *Doing all the calculation 
     *pushing and popping in the Stack class
     *
     * @exception StackOverflowException when too many operators and
     * not enough and unknown operators entered by user
     *
     *@return : double
     */
	public double evaluate() 
	{
		Stack stack = new Stack(11);

		for(int i=0;i<userInput.length;i++)
		{
			
			if (digitCounter > stack.getSize()-1) {
				System.out.print("--> Number of operands can Not be more than ");
		 		return 10;
			}
              // using isNumeric method to check if input is digit number
			if( isNumeric(userInput[i]) && digitCounter <= stack.getSize())
			{
				digitCounter++;
				stack.push(Double.parseDouble(userInput[i]));
			}
			
            // using isOperator method to check if input is operator
			else if(isOperator(userInput[i]))
			{
			  if(stack.getTop() >= 1 && isFirstOperator)
			  {
				 hasOperator = true;
				
					
				 isFirstOperator = false;
					
				 //two pop and calculate and then push back
				 double operand2 = stack.pop();
				 double operand1 = stack.pop();
				 
				 //using calculation method to do operations on the operands
				 double result = calculation(operand1,operand2,userInput[i]);
							
				 stack.push(result);
						
			     }
				
			     else 
			    	 
			    { 
				    if(!stack.empty() ) 
				    {

						double operand2 = stack.pop();
						double operand1 = stack.pop();
						double result = calculation(operand2,operand1,userInput[i]);
						stack.push(result);
				    }
				    
				    else
				    {
						throw new IllegalArgumentException("Too many operators!");

				     }
			     }				
			}
			
		    else   
			{
		    	
				throw new IllegalArgumentException("Unknown operator: "+userInput[i]);
				
			}
		}
		
		if((hasOperator || stack.getTop() == 0) &&  stack.getTop() == 0)
		{
		  return  stack.pop();
		
		}
		
		else 
		{
			throw new IllegalArgumentException("Not enough operator!");
		}
	}
	
	
	
	
	/*
	 * method isNumeric
	 * 
	 * check to see if the parameter value is digit number
	 * @param str : string
	 * @return boolean
	 */
	public static boolean isNumeric(String str) 
	{ 
		  try 
		  {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	/*
	 * method isOperator
	 * 
	 * check to see if the parameter value is operator
	 * @param str : c
	 * @return boolean
	 */
	public static boolean isOperator(String c)
	{
		if(c.length() ==1 && ( c.equals("+") || c.contentEquals("-") || c.contentEquals("*") || c.contentEquals("/")))
			return true;
		else
			return false;
					
	}
	
	/*
	 * method calculation
	 * 
	 * doing the operation on the operands with desired operator
	 * @param  operator  : string
	 * @return  operand1 : double
	 * @return  operand2 : double
	 * 
	 */
	public static double calculation(double operand1,double operand2,String operator)
	{
		double result=0;
		switch(operator)
		{
		  case "+":
			  result= operand1 + operand2;	
			  break;
		  case "-":
			  result= operand1 - operand2;
			  break;
		  case "*":
			  result= operand1 * operand2;
			  break;
		  case "/":
			  result= operand1 / operand2;

		}
		
		return result;
		
	}

}

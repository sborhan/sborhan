

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab6;

import java.util.Scanner;



/*
 *class RPNCalculator
 *
 *Contains the main() method
 * printing the result of calculation to console is done in this class
 *All of user input from the keyboard is performed in this class
 *
 * @author Sam Borhan
 * @version 1.0
 */
public class RPNCalculator {

	/*
	 * main Method
	 * testing purposes & user interface
	 * 
	 * @param args : String[]
	 * @return : void
	 *
	 */
	public static void main(String[] args) {
		String userInput;
		//instance variable with type of RPN class
		RPN rpn ;	
		Scanner scanner = new Scanner(System.in);
   	
		System.out.println("RPN Calculator\n\n");
		System.out.println("(blank line to quit)");
		System.out.print("calc> ");
		
		//reading user input
		userInput=scanner.nextLine();
		
		//quit loop by hitting enter button
		while(!userInput.isEmpty()) {			
        rpn = new RPN(userInput);
      //  double test =  rpn.evaluate();
        System.out.println(rpn.evaluate()+"\n");
        System.out.print("calc> ");
		userInput=scanner.nextLine();      
		}
         System.out.println("\n\nbye!");
		
		scanner.close();
	}
}

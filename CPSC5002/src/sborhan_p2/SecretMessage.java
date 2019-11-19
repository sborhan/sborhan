/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */




package sborhan_p2;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;



 /*
  *class SecretMessage
  *
  *Contains the main() method
  *All of printing to console must be done in this class
  *All of user input from the keyboard must be performed in this class
  *Uses the public methods of your MessageDecoder class to accomplish the decoding.
  *
  * @author Sam Borhan
  * @version 1.0
  */
public class SecretMessage {

	
	/*
	 * main Method
	 * testing purposes & user interface
	 * 
	 * @param args : String[]
	 * @return : void
	 * @throws : FileNotFoundException
	 */
   public static void main(String[] args)throws FileNotFoundException {
	  
	   // instance variable message
	    MessageDecoder message;
	    
		boolean quit = false;
		String fileName ="";
		String PlainTextMessage ="";
		String sInput="";
		
		//Scanner object to read user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n======== Welcome to message decoder application =========\n");

		System.out.println("\nThis program reads an encoded message from a file supplied by the user and\n" + 
			            	"displays the contents of the message before it was encoded.\n" + 
			            	"");
		//while loop till user wants to exit the application
	  while(!quit) {
		System.out.print("Enter a valid secret file name: ");
		fileName = scanner.nextLine();
		//while loop till user enter a valid file using isValidFile method
		while(!isValidFile(fileName)){
			System.out.print("\nEnter a valid secret file name: ");
			fileName = scanner.nextLine();
		}
		
		/*
		 * creating MessageDecoder new object
		 * using MessageDecoder object, getPlainTextMessage method to Display messages
		 */
		 message = new MessageDecoder();
		
		PlainTextMessage = message.getPlainTextMessage(fileName);
		
		//if file is empty 
    	if(PlainTextMessage.equals("")) {
            System.out.print("No decoding is Available...your file is Empty!");
    	}else if(PlainTextMessage.equals("invalid")){
    		System.out.print("The file format is not valid.");
    	
    	}else {
    		System.out.print("Decoded : "+PlainTextMessage);	   
    	}
    	
		System.out.print("\n\nWould you like to try again? (Y/N): ");
		//reading user input
		 sInput = scanner.nextLine();
		 quit =userValidation( sInput, scanner);
      }

	scanner.close();
  }
	
  // =============== Methods =====================

	
	/*
	 * Checks to see that the user-specified file name refers to a valid
	 * file on the disk and not a directory. Displays an error message to the
	 * user if that is not the case.
	 * @param fname file name string to check
	 * @return true if file exists on disk and is not a directory
	 */
	private static boolean isValidFile(String fname) {
	    File path = new File(fname);
	    boolean isValid = path.exists() && !path.isDirectory();
	    if (!isValid) {
	    	System.out.println("\nfile is Not exists!...\n");   
	    }
	    return isValid;
	}
	

    //check to see if a string is numeric or not
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

   

    /* method userValidation for validation
     * Validate user input and check user input
     * 
     * @param sInpu t : String
     * @param scanner : Scanner
     * 
     * @return userValidation : boolean
     */
    public static boolean userValidation(String sInput, Scanner scanner) {
    	
    	boolean quit = false;
    	char userInput;
    	
    	if (sInput.isEmpty()) {
            sInput = "empty";
        }
         userInput = sInput.toUpperCase().charAt(0);
        
        //while loop till user enter correct input
        while (userInput != 'N' && userInput != 'Y') {
            System.out.println("Invalid input!");
    		System.out.print("\n\nWould you like to try again? (Y/N): ");
            sInput = scanner.nextLine();
            if (sInput.isEmpty()) {
                sInput = "empty";
            }
            userInput = sInput.toUpperCase().charAt(0);
        }
         if (userInput == 'N') {
            quit = true;
        	System.out.println("\n=========== Thanks for using decoder application ===========");
         } else if (userInput == 'Y') {
            System.out.println("Alright, Let's continue.....\n");
         }       
      return quit;
    }
}



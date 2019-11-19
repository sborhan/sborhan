


/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package sborhan_p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 *class MessageDecoder
 *
 *Responsible for converting a scrambled message file into plain text.
 *Contains a public method getPlainTextMessage() that returns the String object.
 *The scrambled file must be scanned only once and must be scanned inside this class.
 *Must utilize the linked list data structure to accomplish the decoding work. (See Lab 4 & Lab 5)
 *Does not call any methods of SecretMessage class
 *
 * @author Sam Borhan
 * @version 1.0
 */
public class MessageDecoder {

    //====== Inner class Secret =======
    private class Secret {
    	/*
         * store value -> integer data type
         */
        public int digitValue;
        /*
         * store value -> char data type
         */
        public char charValue;
        
        /*
         * constructor
         *
         * @param digitValue : integer
         * @param charValue : char
         *
         */
        public Secret(int digitValue, char charValue) {
            this.charValue = charValue;
            this.digitValue = digitValue;
        }
    }


    //====== Inner class Node =======
    private class Node {

        //======= Inner class Fields ======

        /*
         * store value -> Secret class data type
         */
        public Secret data;

        /*
         * store address -> Node instance variable
         */
        public Node next;

        //====== Inner class Method ======
        /*
         * constructor
         *
         * @param data : Secret class data type
         * @param next : Node   class data type 
         *
         */
        public Node(Secret data, Node next) {

            this.data = data;
            this.next = next;
        }
    }
    
  // class MessageDecoder private fields
    private String plainTextMessage;
    private Node head;

    //====== class MessageDecoder Methods ======
   
    /*
     * no argument constructor
     *
     */ 
    public MessageDecoder() {
    	
    	plainTextMessage = "";
        head = null;
    }

   
    /*
     * method getPlainTextMessage
     * displays  Secret Text Message
     * using readFile method to read file
     * using plainTextMessage private field to store textMessages
     * @param fileName : String
     * 
     * @throws : FileNotFoundException
     * @return : String
     * 
     */
    public String getPlainTextMessage(String fileName) throws FileNotFoundException {
    	
    	   Boolean validFile = readFile(fileName);
    	   if(!validFile){
    		   plainTextMessage = "invalid";
    	   }
    	   else {
    		   
           for (Node p = head; p != null; p = p.next) {
        	   
        	   //storing all character in the file inside plainTextMessage private field
        	   plainTextMessage += p.data.charValue;

           }
    	   }
    	
        return plainTextMessage;
    }
    
    
    /*
     * method readFile
     * Read the file and sort them with putInOrder method
     * 
     * @param fileName :String
     * 
     * @return: void
     * @throws : FileNotFoundException
     *
     */
    private Boolean readFile(String fileName) throws FileNotFoundException {
    	
        Boolean validFile = true;
    	Secret secret;
    	Scanner file;
    	String str;
    	char secretChar;
    	 int number;
    	 
        //Scanning files
         file = new Scanner(new File(fileName));
         
        //while loop till file contains null
        while (file.hasNext() && validFile ==true) {
        	 try {
             str = file.nextLine();
             secretChar = str.charAt(0);
            
            //parsing String digit number to integer 
             number = Integer.parseUnsignedInt(str.substring(2));
            
            // creating Secret class object with private filed value of file digit number and character
             secret = new Secret(number, secretChar);
            
            //sorting file contents with putInOrder method  
            putInOrder(secret);
        	 }catch (Exception e) {
        	    
        	    	validFile = false;
        	   }
        }
   
        file.close();
        return validFile;
    }



    /*
     * method putInOrder
     * sort digit number from the smallest to the largest
     * @param secret : Secret class data type
     * @return : void
     */
    private void putInOrder(Secret secret) {
    	
    	Node p;
    	
        /* check if it's first node or
         * check if parameter value is smaller than current head value
         */
        if (head == null || head.data.digitValue > secret.digitValue) {
            // become head in the linked list
            head = new Node(secret, head);
        } else {

            p = head;

            // loop ends when reach null or find larger node value  
            while (p.next != null && p.next.data.digitValue < secret.digitValue) {
                p = p.next;
            }

            /* new Node siting between smaller and larger node value
             *  or siting at the end of list
             */
            p.next = new Node(secret, p.next);

        }
    }
}

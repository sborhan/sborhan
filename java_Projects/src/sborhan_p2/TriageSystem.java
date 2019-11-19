/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package sborhan_p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * class TriageSystem
 * contains the main entry point of the program
 * responsible for the user interface
 * @author SAM BORHAN
 * @version 01
 */
public class TriageSystem {
    private static final String MSG_WELCOME = welcomeMessage();  
    private static final String MSG_GOODBYE = goodbyeMessage();   
    private static final String MSG_HELP    = helpMessage(); 
    private static boolean keepAsking = true;

    /**
     * method main
     * Entry point of the program
     * @param args not used
     */
    public static void main(String[] args) {
        System.out.println(MSG_WELCOME);

        Scanner console = new Scanner(System.in);
        PatientPriorityQueue priQueue = new PatientPriorityQueue();
        while (keepAsking) {
            System.out.print("\ntriage> ");
            String line = console.nextLine();
            processLine(line, priQueue);
        }

        System.out.println(MSG_GOODBYE);
        console.close();
    }

    /**
     * method processLine
     * Process the line entered from the user or read from the file
     * @param line     String command to execute
     * @param priQueue Priority Queue to operate on
     */
    private static void processLine(String line,
                                    PatientPriorityQueue priQueue) {
     try {
           Scanner lineScanner = new Scanner(line); // Scanner to extract words
           String cmd = lineScanner.next();         // The first is user's command

           // A switch statement could be used on strings, but not all have JDK7
           if (cmd.equals("help")) {
               System.out.println(MSG_HELP);
           } else if (cmd.equals("add")) {
               addPatient(lineScanner, priQueue);
           } else if (cmd.equals("peek")) {
               peekNextPatient(priQueue);
           } else if (cmd.equals("next")) {
               dequeueNextPatient(priQueue);
           } else if (cmd.equals("list")) {
               showPatientList(priQueue);
           } else if (cmd.equals("load")) {
               executeCommandsFromFile(lineScanner, priQueue);
           } else if (cmd.equals("debug")) {
               System.out.println(priQueue.toString());
           } else if (cmd.equals("quit")) {
               keepAsking = false;
           } else {
               System.out.println("Error: unrecognized command: " + line);
           }
           
         }catch(Exception e) {
            System.out.println("Error: unrecognized command: " + line);

         }
    }

    /**
     * method executeCommandsFromFile
     * Reads a text file with each command on a separate line and executes the
     * lines as if they were typed into the command prompt.
     * @param lineScanner Scanner remaining characters after the command `load`
     * @param priQueue    priority queue to operate on
     */
    private static void executeCommandsFromFile(Scanner lineScanner,
                                                PatientPriorityQueue priQueue) {
        // read the rest of the line into a single string
        String fileName = lineScanner.nextLine().trim();

        try {
            Scanner file = new Scanner(new File(fileName));
            while (file.hasNext()) {
                final String line = file.nextLine();
                System.out.println("\ntriage> " + line);
                processLine(line, priQueue);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.printf("File %s was not found.%n", fileName);
        }
    }

    /**
     * method peekNextPatient
     * Displays the next patient in the waiting room that will be called.
     * @param priQueue priority queue to operate on
     */
    private static void peekNextPatient(PatientPriorityQueue priQueue) {
    	
    	try{	
    		
            System.out.println("Highest priority patient to be called next : "+
    	    priQueue.peek().getName()); 
            
        }catch (EmptyStackException e){
            System.out.println("There are no patients in the waiting area.");
    	}
    }

    /**
     * method showPatientList
     * Displays the list of patients in the waiting room.
     * @param priQueue priority queue to operate on
     */
    private static void showPatientList(PatientPriorityQueue priQueue) {
    	
        System.out.println("# patients waiting: " + priQueue.size() + "\n");
        System.out.println("  Arrival #   Priority Code   Patient Name\n" +
                           "+-----------+---------------+--------------+");
        fillThePatientList (priQueue); 
    }
    
    /**
     * method fillThePatientList
     * Fill the list of patients in the waiting room.
     * @param priQueue priority queue to operate on
     */
    private static void fillThePatientList (PatientPriorityQueue priQueue) {
    	
      for(Patient p : priQueue.getPatientList()) {
        String priorityCode =
              (p.getPriorityCode() == 1) ? "immediate" :
              (p.getPriorityCode() == 2) ? "emergency" :
              (p.getPriorityCode() == 3) ?    "urgent" :
              (p.getPriorityCode() == 4) ?   "minimal" :"unknown";  
             
             System.out.printf("   %03d\t\t",p.getArrivalOrder());
             System.out.printf("%-15s",priorityCode);
             System.out.printf("%-15s\n",p.getName());      
      }
    }

    /**
     * method dequeueNextPatient
     * Removes a patient from the waiting room and displays the name on the
     * screen.
     * @param priQueue priority queue to operate on
     */
    private static void dequeueNextPatient(PatientPriorityQueue priQueue) {
    	
    	try {		
             System.out.println("This patient will now be seen: "+
                                 priQueue.dequeue().getName());     
    	}catch(EmptyStackException e) {
            System.out.println("There are no patients in the waiting area.");
    	}
    }

    /**
     * method addPatient
     * Adds a patient to the waiting room.
     * @param lineScanner Scanner with remaining chars after the command
     * @param priQueue    priority queue to operate on
     */
    private static void addPatient(Scanner lineScanner,
                                   PatientPriorityQueue priQueue) {
     try {
    	   String userInput = lineScanner.nextLine();
    	   //Splitting user input by spaces
    	   String[] splitUserInputs =userInput.split(" ");
    	   String name ="";
    	
    	   // extracting patient name
    	   for(int i = 2 ;i < splitUserInputs.length ;i++) {
    	    	name += splitUserInputs[i]+" ";
    	   }
    	
    	   addedToListMessage(splitUserInputs[1],name);  	
    	   addPriorityAndName(splitUserInputs[1],name,priQueue);
    	
        }catch(IllegalArgumentException e) {
    	System.out.println("Error: No patient Name! ");
        }	   
    }
    
    /**
     * method addPriorityAndName
     * Adds name and priority order of a patient
     * @param userInput : String data type
     * @param name      : String data type
     * @param priQueue  : priority queue to operate on
     */
    private static void addPriorityAndName(String userInput,String name,
    		                               PatientPriorityQueue priQueue) {
    	switch(userInput) {
   	      case "immediate":
   		    priQueue.addPatient(1, name);
   		    break;
   	     case "emergency":
   		    priQueue.addPatient(2, name);
   		    break;
   	     case "urgent":
   		    priQueue.addPatient(3, name);
   	        break;
   	     case "minimal":
   		    priQueue.addPatient(4, name);
   		    break;
         default:
	        System.out.print("Error: unrecognized priority code: "+
	    		             userInput+"\n");
	        break;
       }     	
    }
    
    /**
     * method addedToListMessage
     * Display a message when a patient
     * Added to the list.  
     * @param priorityCode : String data type
     * @param PatientNAme  : String data type
     */
    private static void addedToListMessage(String priorityCode,
    		                               String PatientNAme) {
      if(!PatientNAme.isEmpty()) {
    	if(priorityCode.equals("immediate") || 
    	   priorityCode.equals("emergency") ||
    	   priorityCode.equals("minimal")   || 
    	   priorityCode.equals("urgent")) {
    	    		
    	  System.out.print("Added patient "+"\""+PatientNAme+"\""+
    	                   " to the priority system\n");  	
        }
      }
    	
    }
    
    /**
     * method welcomeMessage
     * Display welcome Message
     * @return String
     */
    private static String welcomeMessage() {
     String message =
      "\n===== Welcome to hospital triage"+
      " priority queue system =====\n"+
      "\n......To review all your options type help : triage> help\n";
     return message;
    }
    
    /**
     * method goodbye Message
     * Display goodbye Message 
     * @return String
     */
    private static String goodbyeMessage() {
     String message =
      "\n===== Thanks for using hospital triage"+
      " priority queue system, Goodbye! =====";

     return message;
    }
    
    /**
     * method helpMessage
     * Display help Message
     * @return String
     */
    private static String helpMessage() {
     String message = 
      "\n---------------------------------------------------------------------------"+
      "\nadd <priority-code> <patient-name>\n"+
      "\n\t    Adds the patient to the triage system.\n"+
      "\t    <priority-code> must be one of the 4 accepted priority codes:\n"+
      "\t\t 1. immediate 2. emergency 3. urgent 4. minimal\n"+
      "\t    <patient-name>: patient's full legal name (may contain spaces)\n"+
      "---------------------------------------------------------------------------\n"+
      "next        Announces the patient to be seen next. Takes into account the \n"+
      "\t    type of emergency and the patient's arrival order.\n"+
      "---------------------------------------------------------------------------\n"+
      "peek        Displays the patient that is next in line, but keeps in queue\n"+
      "---------------------------------------------------------------------------\n"+
      "list        Displays the list of all patients that are still waiting\n"+
      "\t    in the order that they have arrived.\n"+
      "---------------------------------------------------------------------------\n"+
      "load <file>\n            Reads the file and executes the command on each line\n"+
      "---------------------------------------------------------------------------\n"+
      "help        Displays this menu\n"+
      "---------------------------------------------------------------------------\n"+
      "quit        Exits the program\n" +
      "---------------------------------------------------------------------------\n";

   return message;
  }
    
}

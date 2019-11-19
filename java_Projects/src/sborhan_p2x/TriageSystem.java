package sborhan_p2x;

import java.io.BufferedWriter;

/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        }else if (cmd.equals("save")) {
        	saveList(lineScanner, priQueue);
        }else if (cmd.equals("change")) {
        	changePatientStatus(lineScanner, priQueue);
        }  else if (cmd.equals("add")) {
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
                
                
             	//Splitting user input by spaces
             	String[] splitUserInputs =line.split(" ");
             	String name = nameProcessor(splitUserInputs);
             	
             	String[] nameOrder = name.split("\\|");
             	String lineTemp = splitUserInputs[0]+" "+splitUserInputs[1]+" "+nameOrder[0];
               
                
                System.out.println("\ntriage> " + lineTemp);
                processLine(line, priQueue);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.printf("File %s was not found.%n", fileName);
        }
    }

    /**
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
     * Fill the list of patients in the waiting room.
     * @param priQueue priority queue to operate on
     */
    private static void fillThePatientList (PatientPriorityQueue priQueue) {
      for(Patient p : priQueue.getPatientList()) {
        String priorityCode =
              (p.getPriorityCode() == 1) ? "immediate" :
              (p.getPriorityCode() == 2) ? "emergency" :
              (p.getPriorityCode() == 3) ?    "urgent" :
              (p.getPriorityCode() == 4) ?   "minimal" :"unknown!!";  
             
             System.out.printf("   %03d\t\t",p.getArrivalOrder());
             System.out.printf("%-15s",priorityCode);
             System.out.printf("%-15s\n",p.getName());      
      }
    }

    /**
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
     * method changePatientStatus
     * Allows to change patient's priority.
     * @param lineScanner
     * @param priQueue
     */
     private static void changePatientStatus(Scanner lineScanner,
                                           PatientPriorityQueue priQueue) {
    	int prioritycode;
        boolean isFound = false;
        int wrongCommand =0;
        String name ="";

    	String userInput = lineScanner.nextLine();
    	//Splitting user input by spaces
    	String[] splitUserInputs =userInput.split(" ");
    	
    	prioritycode =  splitUserInputs[2].equals("immediate") ? 1 :
	                    splitUserInputs[2].equals("emergency") ? 2 :
	                    splitUserInputs[2].equals("urgent")    ? 3 :
	                    splitUserInputs[2].equals("minimal")   ? 4 : -1;
    	
    	for(int i=0;i<priQueue.size();i++) {
    		if(priQueue.getPatientList().get(i).getArrivalOrder() ==
    		   Integer.parseInt(splitUserInputs[1])){
    			
    		 if(splitUserInputs[2].equals("immediate") || 
    			splitUserInputs[2].equals("emergency") ||
    			splitUserInputs[2].equals("minimal")   || 
    			splitUserInputs[2].equals("urgent")) {
    				
             
    		   priQueue.getPatientList().set(i,new Patient(prioritycode,
    					                     priQueue.getPatientList().get(i).getArrivalOrder(),
    					                     priQueue.getPatientList().get(i).getName()));
    		  isFound = true;
    		  name = priQueue.getPatientList().get(i).getName();
    		  priQueue.percolateUp(i);
    		  priQueue.percolateDown(i);
    		  break;
    		}else {
    		   wrongCommand++;
    		   System.out.print("Error: unrecognized priority code: "+
                                splitUserInputs[2]+"\n");    		  
    	    }
    	  }
    	}
    	if(isFound == true ) { 
    			
            System.out.println("Changed "+"\" "+name+"\""+"'s priority to "+splitUserInputs[2] +"\n");

    	}else {
    		if(wrongCommand == 0)
    		System.out.print("Error: no patient with the given id was found\n");
    	}
	
    }
    
    /**
     * method saveList
     * allows to save the patient list to be reloaded later.
     * @param lineScanner
     * @param priQueue
     * @throws IOException
     */
     private static void saveList(Scanner lineScanner,
             PatientPriorityQueue priQueue) throws IOException { 
    	 
    	 String userInput = lineScanner.nextLine();
     	//Splitting user input by spaces
     	String[] splitUserInputs =userInput.split(" ");
     	
    	 String patientList ="";
     	for(int i=0;i<priQueue.size();i++) {
     		String priorityCode =
     	       priQueue.getPatientList().get(i).getPriorityCode() == 1 ? "immediate" :
     		   priQueue.getPatientList().get(i).getPriorityCode() == 2 ? "emergency" :
     		   priQueue.getPatientList().get(i).getPriorityCode() == 3 ? "urgent" :
         	   priQueue.getPatientList().get(i).getPriorityCode() == 4 ? "minimal" : "Unknown!";
			
     		patientList +="add "+priorityCode+" "+priQueue.getPatientList().get(i).getName()+"|"+priQueue.getPatientList().get(i).getArrivalOrder()+"\n";
     	}
     	

         BufferedWriter output = null;
         try {
             File file = new File(splitUserInputs[1]);
             output = new BufferedWriter(new FileWriter(file));
             output.write(patientList);
             System.out.print("Saved "+ priQueue.size() +
            		          " patients to "+splitUserInputs[1]+"\n" );
             
         } catch ( IOException e ) {
             e.printStackTrace();
         } finally {
           if ( output != null ) {
        	   
             output.close();
           }
         }
    	 
     }
     

     /**
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
     	String name = nameProcessor(splitUserInputs);
     	
     	// extracting patient name
     	//for(int i = 2 ;i < splitUserInputs.length ;i++) {
     	//	name += splitUserInputs[i]+" ";
     	//}
     	
     	String[] nameOrder = name.split("\\|");
     	
     	
     	addToListMessage(splitUserInputs[1],nameOrder[0]); 
     	
     	addPriorityAndName(splitUserInputs[1],name,priQueue);
     	
       }catch(IllegalArgumentException e) {
     	System.out.println("Error: No patient Name! ");
      }
 	   
     }
     
     private static String nameProcessor(String[] splitUserInputs)
     {
    	 String name ="";
      	
    	// extracting patient name
      	for(int i = 2 ;i < splitUserInputs.length ;i++) {
      		name += splitUserInputs[i]+" ";
      	}
      	
      	return name;
     }
     
     /**
      * method addPriorityAndName
      * Adds name and priority order of a patient
      * @param userInput
      * @param name
      * @param priQueue
      */
     private static void addPriorityAndName(String userInput,String name,
     		                               PatientPriorityQueue priQueue) {
    	 String[] nameOrder = name.split("\\|");
    	 int order = nameOrder.length <= 1 ? 0: Integer.parseInt(nameOrder[1].replaceAll("\\s", ""));
     	switch(userInput) {
    	      case "immediate":
    	    	  if(order==0)
    	    		  priQueue.addPatient(1, name);
    	    	  else
    	    		  priQueue.addPatient(1, nameOrder[0],order);
    	    	  
    		    break;
    	     case "emergency":
   	    	  if(order==0)
	    		  priQueue.addPatient(2, name);
	    	  else
	    		  priQueue.addPatient(2, nameOrder[0],order);
    		    break;
    	     case "urgent":
   	    	  if(order==0)
	    		  priQueue.addPatient(3, name);
	    	  else
	    		  priQueue.addPatient(3, nameOrder[0],order);
    	        break;
    	     case "minimal":
   	    	  if(order==0)
	    		  priQueue.addPatient(4, name);
	    	  else
	    		  priQueue.addPatient(4, nameOrder[0],order);
    		    break;
          default:
 	        System.out.print("Error: unrecognized priority code: "+
 	    		             userInput+"\n");
 	        break;
        }     	
     }
     
     /**
      * Method addToListMessage
      * Display a message when adding a patient
      * to the list.  
      * @param priorityCode
      * @param PatientNAme
      */
     private static void addToListMessage(String priorityCode,
     		                          String PatientNAme) {
       if(!PatientNAme.isEmpty()) {
     	if(priorityCode.equals("immediate") || 
     	   priorityCode.equals("emergency") ||
     	   priorityCode.equals("minimal")   || 
     	   priorityCode.equals("urgent")) {
     	    		
     	  System.out.print("Added patient "+"\" "+PatientNAme+"\""+
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
      "\t    Adds the patient to the triage system.\n"+
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
      "---------------------------------------------------------------------------\n"+
     "change <arrivalID><newPriority>\n"+
     "           Changes the patient's priority code status\n"+
     "           <arrivalID> represents the patient's arrival number that is"+
     "\n           listed when you execute the list command.\n" + 
     "           <newPriority> is the priority keyword that is in the table\n"+
                             
     "---------------------------------------------------------------------------\n"+
     "save <fileName>        \n"
     + "           Save the patient list to be reloaded later\n" + 
     "---------------------------------------------------------------------------\n";


   return message;
  }
    
}

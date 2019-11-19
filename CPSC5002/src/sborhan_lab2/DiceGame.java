/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/*  
 * regular six-sided dice.
 *  but 30% of the time the computer's die will roll a 6 and
 *  the other 70% of the time it will be a uniform random value between 1 and 6.
 *  and 30% of the time the user's die will roll a 1 and
 *  the other 70% of the time it will be a uniform random value between 1 and 6.
*/

package sborhan_lab2;

import java.util.Scanner;


public class DiceGame {

    public static void main(String[] args) {
    	
    	LoadedDie die3 = new LoadedDie(2,40);
    	LoadedDie die3Copy = new LoadedDie(die3);

      // check when to Exit the application
        boolean quit = false;
        String sInput;
        Scanner scanner = new Scanner(System.in);

      // do-while loop to let user play as much as he/she wants to.
        do {      
            playGame();
           
            System.out.print("\n\nDo you want to Play one more time (Y/N): ");
            sInput = scanner.nextLine();
            if( sInput.isEmpty()) {
            	 sInput = "empthy";
            }
                
            char userInput = sInput.toUpperCase().charAt(0);
             
      // user validation
            while (userInput != 'N' && userInput != 'Y' ) {
                System.out.println("Invalid input!");
                
                scanner = new Scanner(System.in);

                System.out.print("\n\nDo you want to Play one more time (Y/N): ");
                sInput = scanner.nextLine();
                if( sInput.isEmpty()) {
             	    sInput = "empthy";
                }
               
                userInput = sInput.toUpperCase().charAt(0);
            }
            if (userInput == 'N') {
                quit = true;
                System.out.println("\n*****  Thanks for Using Roll Dice Application!  *****");
            } else if (userInput == 'Y') {
                System.out.println("\nAlright, Let's continue.....\n");
            }
        } while (!quit);
        scanner.close();
    }

    // =========== Methods ============
    
    //In this method dice will roll
    public static void playGame() {
    	 int userWins = 0;
         int computerWins = 0;
         int tiesGame = 0;
         int numberOfROlls = 10;
         Scanner scanner = new Scanner(System.in);

       
         // creating two object instances for user and computer
        LoadedDie userDie = new LoadedDie(1,30);
        LoadedDie computerDie = new LoadedDie(6,30);

        //Printing result for each roll and final result
        for (int i = 1; i <= numberOfROlls; i++) {
        	
            int computerRollValue = computerDie.roll();
            int userRollValue = userDie.roll();
            
            System.out.println("\nRoll " + i + " of " + numberOfROlls + ": ");
            System.out.println("Computer rolled a (" + computerRollValue + ")...");
            
            System.out.print("Press Enter to roll your Die: ");
            scanner.nextLine();
            
            System.out.print("You rolled a (" + userRollValue + ")...");

            if (userRollValue > computerRollValue) {
                ++userWins;
            } else if (userRollValue < computerRollValue) {
                ++computerWins;
            } else {
                ++tiesGame;
            }
            
            System.out.print("\nUser wins: " + userWins + " time(s)! ");
            System.out.print("Number of tied game: " + tiesGame + " time(s)! && ");
            System.out.print("Computer wins: " + computerWins + " time(s)!\n");
        }
        
        if (computerWins > userWins) {
            System.out.println("\nGrand winner is computer!");

        } else if (computerWins == userWins) {
            System.out.println("\nNo Winners!");

        } else {
            System.out.println("\nGrand winner is User!");
        }
        
       // scanner.close();
    }
}


 
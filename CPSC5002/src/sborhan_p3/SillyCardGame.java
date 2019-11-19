

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_p3;

import java.util.Scanner;

/*
 * class SillyCardGame
 * 
 * Contains main method
 * 
 * All of the output to the screen and reading from the keyboard
 * 
 */
public class SillyCardGame {

	/*
	 * main method
	 * 
	 * testing and user interface purpose
	 * 
	 * @param args: String[]
	 * @return: void
	 */
	public static void main(String[] args) {
		
		String sInput ;
	    Scanner scanner = new Scanner(System.in);
	    boolean quit = false;
		
	 
        System.out.println("\n*****  Welcome to Silly Card Game Application!  *****\n\n");

     //while loop till user wants to quit the game
	while(!quit) {
		 GameModel game = new GameModel ();
	 game.shuffleDeck();
	 game.printDeckOfCards();
	 game.printDiscardPileStack();
     game.redRobinDealing();  
     game.printPlayersCards(1);
     game.printPlayersCards(2);
     System.out.println("\n=======================================\n");

          
          boolean isGameFinished = false;
          
          //while loop till some one win the game
          while(!isGameFinished)
          {  
        	  game.printDealStack();
              game.playerTurnStart();
              sInput = scanner.nextLine();          
        	  isGameFinished = game.playerPlay();
        	  
        	 //  game.printDeckOfCards();
        	  game.printDiscardPileStack();
        	  
          }
      
          
          System.out.print("Play Again: (Y/N): ");
          sInput = scanner.nextLine();
          quit = userValidation(sInput, scanner);
	}      
	 scanner.close();
   }
	
	
	/*
	 * method userValidation
	 * 
	 * validation user inputs 
	 * 
	 * @param sInput:String
	 * @param scanner:Scanner
	 * @return :boolean
	 * 
	 */
	public static boolean userValidation(String sInput, Scanner scanner) {
        if (sInput.isEmpty()) {
            sInput = "empty";
        }

        char userInput = sInput.toUpperCase().charAt(0);
        boolean quit = false;
        
        while (userInput != 'N' && userInput != 'Y') {
            System.out.println("Invalid input!");
            System.out.print("Ready to play again(Y/N)?");
            sInput = scanner.nextLine();
            if (sInput.isEmpty()) {
                sInput = "empty";
            }
            userInput = sInput.toUpperCase().charAt(0);
        }
         if (userInput == 'N') {
            quit = true;
            System.out.println("\n*****  Thanks for Using Silly Card Game Application!  *****");
         } else if (userInput == 'Y') {
            System.out.println("Alright, Let's continue.....\n\n");
         }       
      return quit;
    }
 }

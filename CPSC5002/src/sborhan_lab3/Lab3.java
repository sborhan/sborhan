/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/*
 * The computer should choose a "random" number within a given range (chosen by you)
 *  and give the user a chance to guess the number.
 *  The user should be given an unlimited number of guesses
 *  and on each guess should be told whether their guess is too high, too low or correct.
 *  The entire game should be repeated as many times as the user wishes.
 */
package sborhan_lab3;

import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {

        //creating a new object instance
        GuessGame game = new GuessGame(1, 10);
        //set a target to guess with object method
        game.newTarget();

        boolean isCorrectAnswer = false;
        boolean quit = false;
        String sInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*****  Welcome to Guessing Game Application!  *****");
        System.out.println("\nIn this game you will guess a number\n" +
                "and I tell you if it is too low or too high...");
        //this while loop let user play as much as he/she wants.
        while (!quit) {
            // this while loop let user have unlimited guess to find the answer.
            while (!isCorrectAnswer) {
                System.out.print("\nGuess a number between "
                        + game.getRangeMinimum() + " and " + game.getRangeMaximum() + " : ");

                String input = scanner.nextLine();
                //Testing isCorrectAnswer boolean result inside userValidation method
                isCorrectAnswer = userValidation(input, game);
            }
            //display number of guesses
            game.displayStatistics();
            //set a new random number to play for the next game.
            game.newTarget();

            System.out.print("\nReady to play again(Y/N)?");
            sInput = scanner.nextLine();
            
            //user input validation
            quit = userValidation(sInput, scanner);
            
           // reset the boolean value for the next game
            isCorrectAnswer = false;
        }
        scanner.close();
    }


    // =============== Methods =====================

    //check to see if a string is numeric or not
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    //user input validation 
    //check whether user hit non digit or empty space or white space
    public static boolean userValidation(String input, GuessGame game) {

        boolean isCorrectAnswer = false;
        if (isNumeric(input) && !input.isEmpty()) {
            int userGuess = Integer.parseInt(input);
            //check whether user entered a number in the specified range
            if (userGuess < game.getRangeMinimum() || userGuess > game.getRangeMaximum()) {
                System.out.println("Invalid input!");
            } else {
                isCorrectAnswer = game.guess(userGuess);
            }
        } else {
            System.out.println("Invalid input!");
        }
        return isCorrectAnswer;
    }
    
    

    // Overload method userValidation for validation
    public static boolean userValidation(String sInput, Scanner scanner) {
        if (sInput.isEmpty()) {
            sInput = "empthy";
        }

        char userInput = sInput.toUpperCase().charAt(0);
        boolean quit = false;
        
        while (userInput != 'N' && userInput != 'Y') {
            System.out.println("Invalid input!");
            System.out.print("\nReady to play again(Y/N)?");
            sInput = scanner.nextLine();
            if (sInput.isEmpty()) {
                sInput = "empthy";
            }
            userInput = sInput.toUpperCase().charAt(0);
        }
         if (userInput == 'N') {
            quit = true;
            System.out.println("\n*****  Thanks for Using Guessing Game Application!  *****");
         } else if (userInput == 'Y') {
            System.out.println("Alright, Let's continue.....");
         }       
      return quit;
    }
}



/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


/*
 * Tic-Tac-Toe game
 * The game is for two players.
 * One player places the X pieces and
 * the other player places the O pieces.
 * The board should be displayed after each turn
 * Users should indicate where to place their pieces
 * by using a numbering or lettering system for each row and column.
 * no player may place two pieces in a row
 * The game ends as soon as one player has filled one row or one column or
 * one full diagonal or if all the spaces have been filled.
 *
 */

package sborhan_p1;

import java.util.Scanner;


public class P1X {
    /*
     * main Method
     * @param args : String[]
     * @return : void
     */
    public static void main(String[] args) {
        /*
         * @param playerXwins :int -> save number of player 'X' wins
         */
        int playerXwins = 0;

        /*
         *@param playerYwins :int -> save number of player 'Y' wins
         */

        int playerOwins = 0;

        /*
         *@param tieGames :int ->save number of games which get tied
         */
        int tieGames = 0;

        /*
         *@param count : int -> counter
         */
        int count = 0;

        /*
         * @param player : String ->indicates player
         * initialized with "X"
         */
        String player = "X";

        /*
         *@param sInput : String -> String type user input
         */
        String sInput = "";

        /*
         * @param row : String -> String type row number
         */
        String row = "";

        /*
         * @param column : String -> String type column number
         */
        String column = "";

        /*
         * @param quit: boolean -> if user wants to exit the game
         */
        boolean quit = false;
        
        /*
         * @param boardOddSize: String -> save game board size
         */
        String  boardOddSize = "3";

        /*
         * @param scanner : Scanner ->hold the user input
         */
        Scanner scanner = new Scanner(System.in);

        // creating instance object from class TicTacToe
        TicTacToeX game = new TicTacToeX();
        //set the game board to 3*3 arrangement
        
        
        
        System.out.println("     ===== Welcome to the Tic Tac Toe game Application! ======= ");
        System.out.print("\nFirst! Choose your game board size(odd number between 2-16): ");
        boardOddSize = scanner.nextLine();
        //validate user input
        while (!isNumeric(boardOddSize) 
        		|| boardOddSize.isEmpty() 
        		|| Integer.parseInt(boardOddSize) < 2 
        		|| Integer.parseInt(boardOddSize) > 16 
        		|| Integer.parseInt(boardOddSize)%2 == 0 ) {
            System.out.print("\n Choose your game board size(odd number between 2-16): ");
            //set board game size
            boardOddSize = scanner.nextLine();

        } 
        game.setGameBoard(boardOddSize);
        System.out.println("\n This is a Two-player Game!");
        System.out.println(" You can be either player 'X' or player 'O'...... \n");

        //while loop till player wants to exit the game
        while (!quit) {

            // initialize player variable to "X" player	
            player = "X";

            //showing the game board using instance variable game 
            game.showGameBoard();

            //while loop till all the conditions checks or all spaces get full
            while (!game.winCondition() && !game.isTieGame()) {
                if (count % 2 == 0) {
                    player = "X";
                } else {
                    player = "O";
                }
                System.out.println("\nNow player'" + player + "' playing...");

                System.out.print("Which row? ");
                // get row from user
                row = scanner.nextLine();

                //check user input validation
                while (!isNumeric(row) || row.isEmpty() || Integer.parseInt(row) < 0 || Integer.parseInt(row) > game.getBoardSize() - 1) {
                    System.out.print("Which row? ");
                    row = scanner.nextLine();

                }

                System.out.print("Which column? ");
                //get column from user
                column = scanner.nextLine();

                //check user input validation
                while (!isNumeric(column) || column.isEmpty() || Integer.parseInt(column) < 0 || Integer.parseInt(column) > game.getBoardSize() - 1) {
                    System.out.print("Which column? ");
                    column = scanner.nextLine();
                }
                //check if there is any empty space to place the player value
                if (isEmptySpace(row, column, game)) {

                    //place the player value in the game board
                    game.setPlayerMove(row, column, player);

                    // show the game board
                    game.showGameBoard();
                    count++;

                } else {
                    System.out.println("\nThis space is already taken!");
                    System.out.println("choose from emthy spaces...");

                }

            }
            // save the players status records
            if (game.isTieGame()) {
                tieGames++;
            } else {

                if (player == "X") {
                    playerXwins++;
                }
                if (player == "O") {
                    playerOwins++;
                }
            }

            System.out.print("\n");
            game.showGameBoard();


            // Print the records of player after finishing each game
            System.out.println("\nplayer X wins :" + playerXwins + " time(s)!");
            System.out.println("player O wins :" + playerOwins + " time(s)!");
            System.out.println("tie games :" + tieGames + " time(s)!");


            // ask if users wants to play again
            System.out.print("\nReady to play again(Y/N)?");
            sInput = scanner.nextLine();

            //user input validation
            quit = userValidation(sInput, scanner, game);

        }

        scanner.close();
    }
    //===================== methods ======================

    /*
     * isNumeric Method
     * check to see if a string is numeric or not
     * @param str : String
     * @return boolean
     */

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    /*
     * method isEmptySpace
     * validate value if player hit white space
     * @param str : String
     * @param column : String
     * @param game :TicTacToe ->instance variable
     * @return boolean
     */
    public static boolean isEmptySpace(String row, String column, TicTacToeX game) {
        if (game.getSpaceValue(row, column) != " ") {
            return false;
        }
        return true;
    }


    /*
     * method userValidation
     * validate player input when wants to exit or continue the game
     *
     * @param sInput : String
     * @param scanner :Scanner ->instance variable
     * @param game : TicTacToe ->instance variable
     *
     */
    public static boolean userValidation(String sInput, Scanner scanner, TicTacToeX game) {
        

        char userInput = sInput.toUpperCase().charAt(0);
        boolean quit = false;
        String boardOddSize ="3";
        if (sInput.isEmpty()) {
            sInput = "empthy";
        }

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
            System.out.println("\n*****  Thanks for Using TicTacToe Game Application!  *****");
        } else if (userInput == 'Y') {
            System.out.println("Alright, Let's continue.....");
            
            System.out.print("\nFirst! Choose your game board size(odd number between 2-16): ");
            boardOddSize = scanner.nextLine();
            //validate user input
            while (!isNumeric(boardOddSize) 
            		|| boardOddSize.isEmpty() 
            		|| Integer.parseInt(boardOddSize) < 2 
            		|| Integer.parseInt(boardOddSize) > 16 
            		|| Integer.parseInt(boardOddSize)%2 == 0 ) {
                System.out.print("\n Choose your game board size(odd number between 2-16): ");
                boardOddSize = scanner.nextLine();

            } 
            // set the board game size
            game.setGameBoard(boardOddSize);
            
        }
        return quit;
    }

}

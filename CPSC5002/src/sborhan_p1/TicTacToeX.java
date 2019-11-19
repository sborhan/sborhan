
/*
 * Game board is a grid of 9 spaces, in a 3 x 3 arrangement
 * Allow two users to play Tic-Tac-Toe as many times as desired
 * Display the board
 * Allow users to place pieces (X or O) by taking turns
 * Check for a winner
 * Keep a running score board and print it after each game.
 *
 */
package sborhan_p1;

public class TicTacToeX {

    //================ Fields ===================

    /*
     * Save the user inputs inside the gameBoard
     *
     * @param gameBoardGrid :String[][]-> Two Dimensional String Array
     */
    private String[][] gameBoardGrid;


    // ================  Methods ================
    // THis Class has Setter and Getters method with No Constructor.

    /*
     *
     * method getBoardSize
     * getter method
     * return Array length
     *
     * @ return : integer
     */
    public int getBoardSize() {

        return gameBoardGrid.length;
    }

    /*
     * method getSpaceValue
     * getter method
     * returns values inside the game board spaces
     *
     * @param row :String
     * @param column :String
     * @return : String
     */
    public String getSpaceValue(String row, String column) {

        return gameBoardGrid[Integer.parseInt(row)][Integer.parseInt(column)];
    }


    /*
     * setGameBoard method
     *  setter method
     *  set the desirable size of the game board
     *
     * @param size = String;
     * @return : void
     *
     */
    public void setGameBoard(String size) {

        int iSize = Integer.parseInt(size);
        gameBoardGrid = new String[iSize][iSize];
        for (int i = 0; i < gameBoardGrid.length; i++) {
            for (int j = 0; j < gameBoardGrid.length; j++) {
                gameBoardGrid[i][j] = " ";
            }
        }
    }


    /*
     * setPlayerMove method
     * setter method
     * save a location for player input inside the board
     *
     *@param row :String
     *@param column :String
     *@param player :String
     *
     *@return : void
     */
    public void setPlayerMove(String row, String column, String player) {

        int iRow = Integer.parseInt(row);
        int iColumn = Integer.parseInt(column);

        gameBoardGrid[iRow][iColumn] = player;
    }

    /*
     * method isTieGame
     * indicates if game gets tied
     *
     * @return : boolean
     *
     */
    public boolean isTieGame() {
        for (int i = 0; i < gameBoardGrid.length; i++) {
            for (int j = 0; j < gameBoardGrid.length; j++) {
                if (gameBoardGrid[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * winCondition method
     *check if winning condition occurred
     *
     * @return : boolean
     */
    public boolean winCondition() {
        // loop counters variables
        int loopCounter1  = 0;
        int loopCounter11 = 0;
        int loopCounter2  = 0;
        int loopCounter22 = 0;
        int loopCounter3  = 0;
        int loopCounter33 = 0;
        int loopCounter4  = 0;
        int loopCounter44 = 0;

        //check if one player covers an entire row, column or diagonal
        for (int i = 0; i < gameBoardGrid.length-1; i++) {
            for (int j = 0; j < gameBoardGrid.length - 1; j++) {
                if (gameBoardGrid[i][j].equals("X") && gameBoardGrid[i][j + 1].equals("X")) {
                    (loopCounter1)++;
                }
                if (gameBoardGrid[i][j].equals("O") && gameBoardGrid[i][j + 1].equals("O")) {
                    (loopCounter11)++;
                } else if (gameBoardGrid[j][i].equals("X") && gameBoardGrid[j + 1][i].equals("X")) {
                    (loopCounter2)++;
                } else if (gameBoardGrid[j][i].equals("O") && gameBoardGrid[j + 1][i].equals("O")) {
                    (loopCounter22)++;
                } else if (gameBoardGrid[j][i].equals("X") && gameBoardGrid[j + 1][j + 1].equals("X")) {
                    (loopCounter3)++;
                } else if (gameBoardGrid[j][i].equals("O") && gameBoardGrid[j + 1][j + 1].equals("O")) {
                    (loopCounter33)++;
                } else if (gameBoardGrid[j][gameBoardGrid.length - j - 1].equals("X")
                		   && gameBoardGrid[j + 1][gameBoardGrid.length - j - 2].equals("X")) {
                    (loopCounter4)++;
                } else if (gameBoardGrid[j][gameBoardGrid.length - j - 1].equals("O")
                		  && gameBoardGrid[j + 1][gameBoardGrid.length - j - 2].equals("O")) {
                    (loopCounter44)++;

                }

            }
        }
        //check if loop counter value equals to entire row, column or diagonal
            if (loopCounter1  == gameBoardGrid.length - 1 ||
                loopCounter11 == gameBoardGrid.length - 1 ||
                loopCounter2  == gameBoardGrid.length - 1 ||
                loopCounter22 == gameBoardGrid.length - 1 ||
                loopCounter3  == gameBoardGrid.length - 1 ||
                loopCounter33 == gameBoardGrid.length - 1 ||
                loopCounter4  == gameBoardGrid.length - 1 ||
                loopCounter44 == gameBoardGrid.length - 1) {
            return true;

        } else {
            return false;
        }

    }


    /*
     * method showGameBoard
     * Displays game board
     *
     *@return : void
     */
    public void showGameBoard() {
        //@param: int numberOfPrintdash -> number of "-" 
        int numberOfPrintdash = 0;

        //@param :int numberOfVertic -> number of "|"
        int numberOfVertic = 0;

        //@param tracker : int ->track the loop
        int tracker = 0;

        //@param str : String[] 
        String[] str = new String[gameBoardGrid.length];



        System.out.println("=====================================");
        System.out.print("           ");
        for (int k = 0; k < gameBoardGrid.length; k++) {
            System.out.print(k + ".      ");
        }

        //Create the game board with loop of "-" and "|"
        for (int i = 0; i < gameBoardGrid.length; i++) {
            numberOfPrintdash = 0;
            System.out.println("");
            System.out.print("      " + i + ".");
            if (tracker < gameBoardGrid.length) {
                for (int j = 0; j < gameBoardGrid.length; j++) {

                    str[j] = ("       " + gameBoardGrid[tracker][j]);
                }
            }
            tracker++;

            for (int l = 0; l < gameBoardGrid.length; l++) {
                System.out.print(str[l]);
            }
            System.out.println("");
            System.out.print("            ");

            while (numberOfPrintdash < ((gameBoardGrid.length) * 3)) {

                if (numberOfVertic == 3) {
                    System.out.print("| - ");
                    numberOfVertic = 0;
                } else {
                    System.out.print("- ");
                }

                numberOfPrintdash++;
                numberOfVertic++;
            }

            numberOfVertic = 0;
            numberOfPrintdash = 0;
        }
    }
}







/*
 *In Java, create a GuessGame class. Include the following public member functions:
 *constructor - initializes all variables, pass in the range for choosing target integers
 *void displayStatistics() - displays number of guesses
 *void newTarget() - randomly chooses a new integer in this game's range which is now the new target
 *boolean guess(int num) - processes the user's guess, returns false if number is incorrect;
 *otherwise, returns true
 *int getRangeMinimum() - returns the low end of the range used by newTarget
 *int getRangeMaximum() - returns the high end of the range used by newTarget
 *And private member function:
 *void displayHint(int num) - called from guess function;
 *displays whether the guess was too high or too low
 */

package sborhan_lab3;

import java.util.Random;;

public class GuessGame {


    // private fields 
    private int rangeMinimum;
    private int rangeMaximum;
    private int numberOfGuesses;
    private int targetValue;
    private int guessValue;


    //constructor initialization rangeMinimum and rangeMaximum fields
    public GuessGame(int _rangeMinimum, int _rangeMaximum) {

        rangeMinimum = _rangeMinimum;
        rangeMaximum = _rangeMaximum;
    }

    // displayStatistics method tracking number of user guesses for each play.
    public void displayStatistics() {
        System.out.print("\nYou guessed " + numberOfGuesses + " time(s).\n");
    }

    // newTarget method generate new random number in the specified range.
    public void newTarget() {

        numberOfGuesses = 0;
        Random random = new Random();
        targetValue = random.nextInt((rangeMaximum - rangeMinimum) + 1) + rangeMinimum;
    }

    //Just for test ,my program, purposes -> this method get the random number from newTarget method.
    public int getNewTarget() {
        return targetValue;
    }

    //guess method is a boolean method which indicates whether guess is match
    // with the target and also by using displayHint method,gives 
    //a hint to take a better guess.
    //In Addition, I store ,user guess, value-
    //and number of guesses attempted by a user.
    public boolean guess(int _guessValue) {

        guessValue = _guessValue;
        numberOfGuesses++;

        displayHint(_guessValue);
        if (_guessValue == targetValue) {
            return true;
        } else {
            return false;
        }
    }
    

    //getRangeMinimum is a getter method to get the minimum number in the range
    public int getRangeMinimum() {

        return rangeMinimum;

    }

    //getRangeMaximum is a getter method to get the maximum number in the range
    public int getRangeMaximum() {

        return rangeMaximum;
    }

    //displayHint is a private methods which gives a hint to the user to have a better guess
    //this method is called by guess method.
    private void displayHint(int _guessValue) {

        if (_guessValue < targetValue) {
            System.out.print(guessValue + " is too low");
        } else if (_guessValue > targetValue) {
            System.out.print(guessValue + " is too high");
        } else {
            System.out.print("(" + guessValue + ")" + " That's correct!");
        }
    }
}

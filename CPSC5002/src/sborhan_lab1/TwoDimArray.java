/*
 * Sam Borhan 
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab1;

import java.util.Scanner;


public class TwoDimArray {

	  public static void main(String[] args) {
		  
	        int count;   
	        boolean quit = false;     
	        int[][] arr;
	            
	        
	          //Starting do-while loop
	        do {        	
	            count =0;
	            //Reading user input
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("\n======= 2D Square Array must have same number of rows and columns =======");
	            System.out.print("\nEnter number of rows or columns in the 2D-Array (choose between 1-99): ");
	          
	            //user input validation
	            while (!inputValidation(scanner)) {
	                System.out.println("Please Enter a valid input!");
	                System.out.print("Enter number of rows or columns in the 2D-Array (choose between 1-99): ");
	                scanner.nextLine();
	            }
	             
	            int input = scanner.nextInt();	
	            //limit user input to enter 1-99
	            while (input < 1 || input > 99) {
	                System.out.println("Invalid Number!");
	                System.out.print("Enter number of rows or columns in the 2D-Array( Choose between 1-99) : ");
	                while (!inputValidation(scanner)) {
	                    count++;
	                    //using variable count to prevent duplicate message in this while loop
	                    if(count == 1) {
	                        scanner.nextLine();
	                    }
	                    System.out.print("\nEnter a valid input(choose between 1-99): ");
	                    scanner.nextLine();
	                }

	                input = scanner.nextInt();
	                count =0;
	            }
	            
	            
	            arr = twoDimensionalArr(input);
	            scanner.nextLine();
	            print2DArray(arr);

             //check if user wants Exit or continue the Application
	            System.out.print("\n\nDo you want to continue (Y/N): ");
	            String sInput = scanner.nextLine();
	            char userInput = sInput.toUpperCase().charAt(0);
	            
	            while (userInput != 'N' && userInput != 'Y') {
	                System.out.println("Invalid input!");
	                System.out.print("\n\nDo you want to continue (Y/N): ");
	                sInput = scanner.nextLine();
	                userInput = sInput.toUpperCase().charAt(0);
	            }
	            if (userInput == 'N') {
	                quit = true;
	                System.out.println("\n*****  Thanks for Using 2D-Array Application!  *****");
	            } else if (userInput == 'Y') {
	                System.out.println("\nAlright, Let's continue.....\n");
	            }
	            
	            //End of do-While Loop
	        } while (!quit);
	      
	    }

	  

	    //****************  Methods   ***************
	  //create random number
	    public static int randomNumber() {

	        int rand = (int) (Math.random() * 99 + 1);
	        return rand;
	    }

	    //Create 2D-Array Array with random Numbers
	    public static int[][] twoDimensionalArr(int input) {
	        int[][] arr = new int[input][input];


	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr.length; j++) {
	                arr[i][j] = randomNumber();
	            }
	        }
	        return arr;
	    }

	    //Check if user enter valid input
	    public static boolean inputValidation(Scanner scanner) {
	        if (!scanner.hasNextInt()) {
	            return false;
	        }
	        return true;
	    }

	    //Print Array content along with sum of row,column,diagonals
	    public static void print2DArray(int[][] arr) {
	        int rowSum = 0;
	        int[] columnSum = new int[arr.length];
	        int rightDiaognals = 0;
	        int lefttDiagonals = 0;

	        System.out.print("      ");
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr.length; j++) {
	                System.out.format("%5d ", arr[i][j]);
	                rowSum += arr[i][j];
	                if (j == arr.length - 1) {
	                    System.out.format("----->%5d ", rowSum);
	                    rowSum = 0;
	                }
	            }
	            System.out.print("\n");
	            System.out.print("      ");
	        }

	        System.out.println("");

	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr.length; j++) {
	                columnSum[i] += arr[j][i];
	            }
	            lefttDiagonals += arr[i][i];
	            rightDiaognals += arr[i][arr.length - 1 - i];
	        }

	        System.out.format("%5d", rightDiaognals);
	        System.out.format(" ");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.format("%5d ", columnSum[i]);
	        }

	        System.out.format("%5d", lefttDiagonals);
	    }
	}






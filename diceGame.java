package com.company;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class diceGame {
    // Amount of "sides" for the dice.
    public static final int diceSides = 6;
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        dice(console);
    }
    public static void dice(Scanner scan) {
        System.out.println("Welcome to Dice! ");
        System.out.println();

        Random roll = new Random();
        System.out.print("How many dice will you roll? (1-3)");
        int userInput = 0;
        //The Testing Portion- Making sure the input is always correct.
        //The first while statement confirms it is an integer.
        while(!scan.hasNextInt()) {
            scan.next();
            System.out.println("That is not a proper input, 1-3 please. ");
            System.out.print("How many dice will you roll? (1-3) ");
        }
        //The second uses a placeholder variable to ensure the integer that userInput
        //will be is within the proper range.


        // I GOT THIS TO WORK
        userInput = scan.nextInt();
        int brakeCheck = 0;
        if (userInput > 0 && userInput < 4) {
            brakeCheck = 1;
        }
        if (brakeCheck == 0) {
            userInput =  inputChecker(scan, 0, 4);
        }



        // User's guess on what it lands on.
        System.out.print("What do you think it will land on? ");
        int guess = scan.nextInt();

        //time to start rolling!
        int diceRollResult = 0;
        System.out.println("You chose " + userInput + " die to roll, which means \nyou'll have " + (diceSides * userInput) + " different outputs." );
        System.out.println("Its time to roll!");

        System.out.println();// (spacer)
        // Rolls the dice!
        diceRollResult = roll.nextInt((diceSides * userInput) - 1) + 1;
        System.out.println("Your result = " + diceRollResult);
        if (diceRollResult == guess && userInput == 1) {
            System.out.println("You win!");
            //win bet amount * 1.5
        } else if (diceRollResult == guess && userInput == 2) {
            System.out.println("You win!");
            //win bet amount * 2.5
        } else if (diceRollResult == guess && userInput == 3) {
            System.out.println("You win!");
            //win bet amount * 3.5
        } else {
            System.out.println("No dice!");
        }
    }

    public static int inputChecker(Scanner scan, int min, int max) {
        int brakeCheck = 0;
        int returnInput = 0;
        while (brakeCheck == 0) {
            System.out.print("That is not a proper input, 1-3 please. ");
            while(!scan.hasNextInt()) {
                scan.next();
                System.out.print("That is not a proper input, 1-3 please. ");
            }
            returnInput = scan.nextInt();
            if (returnInput > min && returnInput < max) {
                brakeCheck = 1;
            }
        }
        return returnInput;
    }
}
/*
while (brakeCheck == 0) {
            System.out.print("That is not a proper input, 1-3 please. ");
            while(!scan.hasNextInt()) {
                scan.next();
                System.out.print("That is not a proper input, 1-3 please. ");
            }
            userInput = scan.nextInt();
            if (userInput > 0 && userInput < 4) {
                brakeCheck = 1;
            }
        }
 */

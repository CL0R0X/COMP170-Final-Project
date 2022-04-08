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

        Random roll = new Random();
        System.out.print("How many dice will you roll? (1-3)");
        int userInput = 0;
        //The Testing Portion- Making sure the input is always correct.
        //The first while statement confirms it is an integer.
        while(!scan.hasNextInt() /*|| scan.nextInt() >3*/ ) {
            System.out.println("That is not a proper input, 1-3 please. ");
            System.out.print("How many dice will you roll? (1-3) ");
            scan.next();
        }
        //The second uses a placeholder variable to ensure the integer that userInput
        //will be is within the proper range.

        // I need help working out this portion.
        int tester = scan.nextInt();
        if (tester > 0 && tester < 4) {
            userInput = tester;
        } else {
            while (tester <= 0 && tester >= 4) {
                System.out.println("That is not a proper input, 1-3 please. ");
                //scan.next();
                tester = scan.nextInt();
            }
        }
        System.out.print("What do you think it will land on? ");
        int guess = scan.nextInt();

        //time to start rolling!
        int diceRollResult = 0;
        System.out.println("You chose " + userInput + " die to roll, \n which means you'll have " + (diceSides * userInput) + " 3different outputs." );
        System.out.println("Its time to roll!");
        diceRollResult = roll.nextInt((diceSides * userInput) -1) + 1;
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
}

package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class roulette {
    public static void games(coin userBalance) {
        System.out.println("Welcome to Roulette! ");
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);




        System.out.print("Would you like to bet on Color or Number or Both (0/1/2): ");
        int request = scan.nextInt();


        int rolledScore = rand.nextInt(36);
        System.out.println(rolledScore);
        System.out.print("How many coins do you want to bet? ");
        int coins = scan.nextInt();

        if (request == 0 ) {
            System.out.printf("What color tile do you pick red or black or green(0/1/2)? ");
            int color = scan.nextInt();
            //color = color.toUpperCase();
            colorOfChoice(rolledScore, color, scan, userBalance);
        } else if(request == 1 ) {
            System.out.printf("What number out of 36 do you pick? ");
            int guessNumber = scan.nextInt();
            gambleNum(guessNumber, rolledScore);
        } else if( request == 2) {
            System.out.printf("What number out of 36 do you pick? ");
            int guessNumber = scan.nextInt();
            gambleNum(guessNumber, rolledScore);
            System.out.printf("What color tile do you pick red or black or green(0/1/2)? ");
            int color = scan.nextInt();
            colorOfChoice(rolledScore, color, scan, userBalance);

        }
    }

    public static void colorOfChoice( int rolledNumber, int color, Scanner scan, coin userBalance) {
        System.out.println("Before you roll, please input how much you would like to bet: ");
        while(!scan.hasNextInt()) {
            scan.next();
            System.out.println("That is not an integer. ");
        }
        int initialBet = scan.nextInt();

        if (initialBet <= userBalance.getBal()) {
            System.out.println(userBalance.getBal());
        } else {
            initialBet = inputChecker(scan, 1, (int) userBalance.getBal());
        }

        if (rolledNumber %2 == 0 && color == 0) {
            System.out.println("You rolled a "+rolledNumber);
            System.out.printf("You have won, double your coins");
            userBalance.newBal((initialBet * 2));
        } else if ( rolledNumber %2 == 1 && color == 1) {
            System.out.println("You rolled a "+rolledNumber);
            System.out.printf("You have won, double your coins");
            userBalance.newBal((initialBet * 2));
        }else if( (rolledNumber == 0 || rolledNumber == 36 )&& color == 2) {
            System.out.printf("You have won, triple your coins");
            System.out.println("You rolled a "+rolledNumber);
            userBalance.newBal((initialBet * 3));
        } else {
            System.out.print("Better luck next time ");
            System.out.println(rolledNumber);
            userBalance.newBal((initialBet * -1));
        }
    }

    public static void gambleNum( int guess, int rolledNumber) {
        if(guess == rolledNumber) {
            System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber + " ");
            System.out.println ("You won 5 times your money");
            
        } else {
            System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber);
            System.out.println("Better luck Next Time");
        }
    }
    public static int inputChecker(Scanner scan, int min, int max) {
        int brakeCheck = 0;
        int returnInput = 0;
        while (brakeCheck == 0) {
            System.out.print("That is not a proper input.");
            while(!scan.hasNextInt()) {
                scan.next();
                System.out.print("That is not a proper input.");
            }
            returnInput = scan.nextInt();
            if (returnInput > min && returnInput < max) {
                brakeCheck = 1;
            }
        }
        return returnInput;
    }


}





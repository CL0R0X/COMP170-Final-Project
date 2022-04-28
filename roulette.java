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

        System.out.println("Your current balance is " + userBalance.getBal() + " coins");
        int rolledScore = rand.nextInt(36);
       
        System.out.print("How many coins do you want to bet? ");

        while(!scan.hasNextInt()) {
            scan.next();
            System.out.println("That is not an integer. ");
        }
        int coins = scan.nextInt();

        if (coins <= userBalance.getBal()) {
            System.out.println("You may continue to gamble");
        } else {
            coins = inputChecker(scan, 1, (int) userBalance.getBal());
        }
        gambleTypes(scan, coins, userBalance, request, rolledScore);
    }


    public static void gambleTypes(Scanner scan , int initialBet, coin userBalance, int request, int rolledNumber) {
        if (request == 0 ) {
            System.out.printf("What color tile do you pick red or black or green(0/1/2)? ");
            int color = scan.nextInt();

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
            System.out.println("Your current balance is " + userBalance.getBal() + " coins");
        } else if(request == 1) {
            System.out.printf("What number out of 36 do you pick? ");
            int guess = scan.nextInt();
            //gambleNum(guessNumber, rolledScore), userBalance, coins;
            if(guess == rolledNumber) {
                System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber + " ");
                System.out.println ("You won 5 times your money");
                userBalance.newBal(initialBet*5);
            } else {
                System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber);
                System.out.println("Better luck Next Time");
                userBalance.newBal(initialBet *-1);
            }
            System.out.println("Your current balance is " + userBalance.getBal() + " coins");

        } else if( request == 2) {
            System.out.printf("What number out of 36 do you pick? ");
            int guess = scan.nextInt();
            System.out.printf("What color tile do you pick red or black or green(0/1/2)? ");
            int color = scan.nextInt();
            //gambleNum(guessNumber, rolledScore), userBalance, coins;

            //colorOfChoice(rolledScore, color, scan, userBalance, coins);
            if (rolledNumber %2 == 0 && color == 0) {
                //red
                System.out.println("You rolled a "+rolledNumber + " and your color tile is red");
                if(guess == rolledNumber ) {
                    System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber + " ");
                    System.out.println ("You won 5 times your money");
                    userBalance.newBal(initialBet*5);
                } else {
                    System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber);
                    System.out.println("Better luck Next Time");
                    userBalance.newBal(initialBet *-1);
                }
            } else if ( rolledNumber %2 == 1 && color == 1) {
                //black
                System.out.println("You rolled a "+rolledNumber + " and your color tile is black");
                if(guess == rolledNumber ) {
                    System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber + " ");
                    System.out.println ("You won 5 times your money");
                    userBalance.newBal(initialBet*5);
                } else {
                    System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber);
                    System.out.println("Better luck Next Time");
                    userBalance.newBal(initialBet *-1);
                }
            }else if( (rolledNumber == 0 || rolledNumber == 36 )&& color == 2) {
               //green
                System.out.println("Your color tile is green");
                if(guess == rolledNumber ) {
                    System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber + " ");
                    System.out.println ("You won 6 times your money");
                    userBalance.newBal(initialBet*6);
                } else {
                    System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber);
                    System.out.println("Better luck Next Time");
                    userBalance.newBal(initialBet *-1);
                }
            } else {
                System.out.print("Better luck next time ");
                if( (rolledNumber == 0 || rolledNumber == 36 )) {
                    System.out.println("You landed on " + rolledNumber + " and a green tile");
                } else if( rolledNumber %2 == 1 ) {
                    System.out.println("You landed on " + rolledNumber + " and a black tile");
                } else {
                    System.out.println("You landed on " + rolledNumber + " and a red tile");
                }
                userBalance.newBal((initialBet * -1));
            }
            System.out.println("Your current balance is " + userBalance.getBal() + " coins");
            
        }
        playAgain(userBalance);


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

    public static void playAgain (coin userBalance) {
        gamblingHome.whichGames(userBalance);
    }
}





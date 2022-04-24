package com.company;

import java.util.Random;
import java.util.Scanner;

public class blackjack {

    public static void games(coin userBalance) {
        Scanner console = new Scanner(System.in);
        blackjack(console, userBalance);
    }
    public static void blackjack(Scanner scan, coin userBalance) {
        System.out.println("Welcome to Blackjack!");
        System.out.println();
        System.out.println("Lets get your hand sorted out...");
        Random rand = new Random();

        System.out.println("Your current balance is " + userBalance.getBal() + " coins");
        // Betting code here:
        System.out.print("Please input how much you would like to bet: ");
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


        /*
        MAKING THE DEALER'S HAND
         */
        int sumOfDealer = 0;
        // (dealer hand size)
        int dealerHS = 2;
        String[] dealerHand = new String[5];
        for (int z = 0; z < dealerHS; z++) {
            int dealerCardPull = rand.nextInt(13);
            dealerHand[z] = cardDeck(dealerCardPull);
            sumOfDealer += dealerCardPull + 1;
        }

        /*
        MAKING THE USER'S HAND
         */
        String[] userHand = new String[5];
        //aceCount will be used after the user has gone over 21 (if they have)
        int aceCount = 0;
        int sumOfUser = 0;
        int cardCount = 0;
        boolean endGame = false;

        while (cardCount < 2) {
            int cardPullStart = rand.nextInt(13);
            if (cardPullStart == 0) {
                aceCount++;
                sumOfUser += 11;
            } else {
                sumOfUser += cardPullStart + 1;
            }
            userHand[cardCount] = cardDeck(cardPullStart);
            System.out.println("You just pulled a " + userHand[cardCount] + "!");
            cardCount++;
        }
        System.out.println("You currently have a hand that is worth " + sumOfUser + ".");

        // Cycles play while the user has a valid sum.
        while (sumOfUser < 21 && endGame == false) {
            System.out.print("Would you like to draw (1) or stay (0)? ");
            int userAnswer = scan.nextInt();
            int brakeCheck;
            if (userAnswer == 1 || userAnswer == 0) {
                brakeCheck = 1;
            } else {
                brakeCheck = 0;
            }
            if (brakeCheck == 0) {
                userAnswer = inputChecker(scan, 0, 1);
            }
            if (userAnswer == 1) {
                int cardPullStart = rand.nextInt(13);
                if (cardPullStart == 0) {
                    aceCount++;
                    sumOfUser += 11;
                } else {
                    sumOfUser += cardPullStart + 1;
                }
                userHand[cardCount] = cardDeck(cardPullStart);
                System.out.println("You just pulled a " + userHand[cardCount] + "!");
                System.out.println("You currently have a hand that is worth " + sumOfUser + ".");

            } else if (userAnswer == 0) {
                endGame = true;
            }

        }
        // END GAME TALLY
        System.out.print("You have a hand of: ");
        for (int a = 0; a <= cardCount - 1; a++) {
            System.out.print(userHand[a]);
            if (a !=  cardCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Your sum is " + sumOfUser + ".");

        System.out.print("The Dealer's hand is: ");
        for (int a = 0; a < dealerHS; a++) {
            System.out.print(dealerHand[a]);
            if (a !=  cardCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("His sum is " + sumOfDealer + ".");

        //Now for checks
        if (sumOfUser > 21) {
            System.out.println("You bust!");
            userBalance.newBal((initialBet * -1));
        } else if (sumOfDealer > 21) {
            System.out.println("Dealer has bust, here's your money.");
            //return bet. (does nothing)
        } else if (sumOfUser < sumOfDealer) {
            System.out.println("You have a smaller hand. You lose.");
            userBalance.newBal((initialBet * -1));
        } else if (sumOfUser == sumOfDealer) {
            System.out.println("You and the Dealer tied!");
            //return bet. (again, does nothing)
        } else if (sumOfUser > sumOfDealer || sumOfUser == 21){
            System.out.println("YOU WIN! Congratulations!");
            userBalance.newBal((initialBet * 1.5));
            //add bet * x amount.
        }
        System.out.println("Your new balance is " + userBalance.getBal());
        playAgain(userBalance);
    }
    public static String cardDeck(int userCard) {
        //Declaring the card Array.
        String[] cardArray = new String[13];
        //Defining all the values within it.
        cardArray[0] = "Ace";
        cardArray[1] = "Two";
        cardArray[2] = "Three";
        cardArray[3] = "Four";
        cardArray[4] = "Five";
        cardArray[5] = "Six";
        cardArray[6] = "Seven";
        cardArray[7] = "Eight";
        cardArray[8] = "Nine";
        cardArray[9] = "Ten";
        cardArray[10] = "Jack";
        cardArray[11] = "Queen";
        cardArray[12] = "King";
        //
        return cardArray[userCard];

    }
    public static int inputChecker(Scanner scan, int min, int max) {
        System.out.println(min);
        System.out.println(max);
        int brakeCheck = 0;
        int returnInput = 100000;
        while (brakeCheck == 0) {
            System.out.print("That is not a proper input, 0-1 please. ");
            while(!scan.hasNextInt()) {
                scan.next();
                System.out.print("That is not a proper input, 0-1 please. ");
            }
            returnInput = scan.nextInt();
            System.out.println(returnInput);
            // Modified to equals so that it works with 0 and 1
            if (returnInput == min || returnInput == max) {
                brakeCheck = 1;
            }
        }
        return returnInput;
    }

    public static void playAgain(coin userBalance) {
        gamblingHome.whichGames(userBalance);
    }
}

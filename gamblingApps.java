package com.company;

import java.util.Random;
import java.util.Scanner;

public class gamblingApps {
    /*
    THERE ARE A GOOD BIT OF BUGS WITH THIS SO FAR!!!!

    However, it is functional, so I thought you'd like to see.
     */


    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        blackjack(console);
    }
    public static void blackjack(Scanner scan) {
        System.out.println("Welcome to Blackjack!");
        System.out.println();
        System.out.println("Lets get your hand sorted out...");
        Random rand = new Random();


        /*


        BET CODE WILL BE HERE


         */

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
            System.out.print("Would you like to draw (1) or stay (0)? (Stay will end the session): ");
            int userAnswer = scan.nextInt();
            int brakeCheck;
            if (userAnswer == 1 || userAnswer == 0) {
                brakeCheck = 1;
            } else {
                brakeCheck = 0;
            }
            // Help with this, this checking section is messed up. I can explain it later.
            while (!scan.hasNextInt() || brakeCheck == 0) { //userAnswer != "draw" || userAnswer != "stay"
                System.out.print("That was an invalid input. Please answer correctly: ");
                userAnswer = scan.nextInt();
                //System.out.println(userAnswer);
                if (userAnswer == 0 || userAnswer == 1) {
                    brakeCheck = 1;
                }
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
        // END GAME TALLY WOOOOO
        System.out.print("You have a hand of: ");
        for (int a = 0; a < cardCount; a++) {
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
            //deduct bet.
        } else if (sumOfDealer > 21) {
            System.out.println("Dealer has bust, here's your money.");
            //return bet.
        } else if (sumOfUser < sumOfDealer) {
            System.out.println("You have a smaller hand. You lose.");
        } else if (sumOfUser == sumOfDealer) {
            System.out.println("You and the Dealer tied!");
            //return bet.
        } else if (sumOfUser > sumOfDealer || sumOfUser == 21){
            System.out.println("YOU WIN! Congratulations!");
            //add bet * x amount.
        }
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
}

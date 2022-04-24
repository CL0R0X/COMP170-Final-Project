package com.company;

import java.util.Random;
import java.util.Scanner;

public class horseBetting {
    public static final int horseSum = 5;
    public static final int trackLength = 10;
    public static void games(coin userBalance) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Horse Race!\n");
        //setting up the String array for the track.
        Random rand = new Random();

        String[] track = new String[horseSum];
        int[] horsePlaces =  new int[horseSum];

        //This has to be a separate block of code from the other prints- its initializing the array.
        for (int j = 0; j < horseSum; j++) {
            track[j] = "O";
            for (int i = 0; i < trackLength - 1; i++) {
                track[j] += "-";
            }
            System.out.println("Horse #" + (j + 1) + ": " + track[j]);
        }
        // Collecting the bet:



        System.out.println("Please input how much you would like to bet. ");
        System.out.println("Current Balance is " + userBalance.getBal() + ": ");
        int initialBet = fetchThis(scan);
        if (initialBet <= userBalance.getBal()) {

        } else {
            initialBet = inputChecker(scan, 1, (int) userBalance.getBal());
        }

        System.out.println("What place are you betting on? (1 - " + horseSum + "): ");
        int userPlace = fetchThis(scan);
        if (!(userPlace <= horseSum) && !(userPlace > 0)) {
            userPlace = inputChecker(scan, 0, horseSum + 1);
        }



    // Time to run the race!
        int weHaveAWinner = 0;
        int winnerPlace = 0;
        while (weHaveAWinner == 0) {
            printTrack(track);
            int boostPlace = rand.nextInt(horseSum);
            track = horseForward(boostPlace, horsePlaces, track);
            horsePlaces[boostPlace]++;
            if (horsePlaces[boostPlace] == trackLength) {
                weHaveAWinner = 1;
                winnerPlace = boostPlace  + 1;
            }
            System.out.println();
        }
        System.out.println("The Winner is Horse #" + (winnerPlace) + "!!!" );

        // Lets see if they won....
        if (userPlace == winnerPlace) {
            System.out.println("You win!!!");
            userBalance.newBal((initialBet * (0.9 * horseSum)));
        } else {
            System.out.println("Your horse did not win :(");
            userBalance.newBal((initialBet * -1));

        }
        playAgain();
    }
    public static String[] horseForward(int place, int[] horsePlaces, String[] raceTrack) {
        // for ease of typing
        String returning = raceTrack[place];
        String line = "-";

        returning = returning.substring(0, returning.length() - 1);
        returning = line + returning;
        raceTrack[place] = returning;
        return raceTrack;
    }
    public static void printTrack(String[] track) {
        for (int i = 0; i < horseSum; i++) {
            System.out.println("Horse #" + (i + 1) + ": " + track[i]);
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

    public static int fetchThis(Scanner scan) {
        int input;
        while(!scan.hasNextInt()) {
            scan.next();
            System.out.println("That is not an integer. ");
        }
        int returnInt = scan.nextInt();
        return returnInt;


    }
    
    public static void playAgain() {
        com.company.gamblingHome.whichGames();
    }
}


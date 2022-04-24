package com.company;

import java.util.Random;
import java.util.Scanner;

public class Slots {

    public static void games(coin userBalance) {
        int brakeCheck = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Slots!");
        System.out.println("Rules: \n Match 3 of the same numbers for slots of 3. \n Match 5 of the same numbers for slots of 5. ");
        System.out.print("Would you like to bet on a Slot machine of 3 or 5 (3/5)?: ");

        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("3 or 5 please.");
        }
        int whichSlot = scan.nextInt();

        if (whichSlot == 3 || whichSlot == 5 ) {
            brakeCheck = 1;
        } else if (brakeCheck == 0) {
            whichSlot = inputChecker(scan, 3, 5);
        }
        brakeCheck = 0;
        System.out.print("Insert 30 coins to begin playing: ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("That is not 30 coins.");
        }
        int coins = scan.nextInt();
        if (coins == 30) {
            brakeCheck = 1;
        } else if (brakeCheck == 0) {
            coins = inputChecker(scan,30,91834809);
        }

        if (whichSlot == 3) {
            rollingSlot3(userBalance, coins);
        } else if (whichSlot == 5) {
            rollingSlot5(userBalance, coins);
        }

    }

    public static void rollingSlot5(coin userBalance, int coins) {
        int[] slot = rig5Value();
        boxPrinter(slot);
        if (slot[0] ==slot[1] && slot[1] ==slot[2] && slot[2] == slot[3] && slot[3] == slot[4] && slot[4] ==slot[0] ) {
            System.out.println("Congratulations, you won doubled your money!");
            userBalance.newBal((double) coins *2);
        } else {
            System.out.println("You have lost your bet!");
            userBalance.newBal((double) coins *-1);
        }
        System.out.println("Your current balance is " + userBalance.getBal() + " coins");
        playAgain(userBalance);
    }
    public static void rollingSlot3(coin userBalance, int coins ) {
        int[] slot = rig3slot();
        boxPrinter(slot);
        if (slot[0] ==slot[1] && slot[1] ==slot[2] && slot[2] == slot[1]){
            System.out.println("Congratulations, you won doubled your money!");
            userBalance.newBal((double) coins *2);
        }else {
            System.out.println("You have lost your 30 coins!");
            userBalance.newBal((double) coins *- 1);
        }
        System.out.println("Your current balance is " + userBalance.getBal() + " coins");
        playAgain(userBalance);
    }
    public static void boxPrinter(int[] objects) {
        String line = "-";
        System.out.println(line.repeat(4 * objects.length + 1) );
        for (int i = 0; i < objects.length; i++) {
            if (i == 0) {
                System.out.print("|");
            }
            System.out.print(" " + objects[i] + " |");
        }
        System.out.println();
        System.out.println(line.repeat(4 * objects.length + 1) );
    }
    public static int inputChecker(Scanner scan, int min, int max) {

        int brakeCheck = 0;
        int returnInput = 100000;
        while (brakeCheck == 0) {
            System.out.print("Please input correctly. ");
            while(!scan.hasNextInt()) {
                scan.next();
                System.out.print("Please input correctly. ");
            }
            returnInput = scan.nextInt();

            // Modified to equal so that it works with 0 and 1
            if (returnInput == min || returnInput == max) {
                brakeCheck = 1;
            }
        }
        return returnInput;
    }

    public static int[] rig5Value() {
        Random rand = new Random();
        int riggingSlots = rand.nextInt(2);
        //There is a random chance for the user to get a one or zero at which decides the console output of have a rigged slot output
        if (riggingSlots == 0) { //activates pure random integer value
            int[] slot = {rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10)}; 
            return slot;
        } else {
            int[] slot = new int[5];
            slot[0] = rand.nextInt(10); // the first value is random num generator
            if (slot[0] >= 5) { // the second value is if the first value is greater than 5 or less than 5, do random generator based on less than 5 or greater 
                slot[1] = rand.nextInt(6);
                slot[1] = slot[1] + 5;
            } else {
                slot[1] = rand.nextInt(5);
            }
            if (slot[1] > 6) { // based on the second value do rng on set limits of greaeter than 6 or between 6 and 3 less than 3. then those limits wouold determine the how the rng would act between the limtsa
                slot[2] = rand.nextInt(4);
                slot[2] = slot[2] + 7;
            } else if (slot[1] >= 3 && slot[1] <= 6) {
                slot[2] = rand.nextInt(4);
                slot[2] = slot[2] + 3;
            } else {
                slot[2] = rand.nextInt(3);
            }
            if (slot[2] > 6) { // this is the same method as before but the number values are changed
                slot[3] = rand.nextInt(4);
                slot[3] = slot[2] + 7;
            } else if (slot[2] >= 3 && slot[2] <= 6) {
                slot[3] = rand.nextInt(4);
                slot[3] = slot[2] + 3;
            } else {
                slot[3] = rand.nextInt(3);
            }
            if (slot[3] > 6) {
                slot[4] = rand.nextInt(4);
                slot[4] = slot[4] + 7;
            } else if (slot[3] >= 3 && slot[3] <= 6) {
                slot[4] = rand.nextInt(4);
                slot[4] = slot[4] + 3;
            } else {
                slot[4] = rand.nextInt(3);
            }
            return slot;
        }


    }
    public static int[] rig3slot() {
        Random rand = new Random();
        int riggingSlots = rand.nextInt(2);
        if (riggingSlots == 0) {
            int[] slot = {rand.nextInt(10), rand.nextInt(10), rand.nextInt(10)};
            return slot;
        } else {
            int[] slot = new int[3];
            slot[0] = rand.nextInt(10);
            if (slot[0] >= 5) {
                slot[1] = rand.nextInt(6);
                slot[1] = slot[1] + 5;
            } else {
                slot[1] = rand.nextInt(5);
            }
            if (slot[1] > 6) {
                slot[2] = rand.nextInt(4);
                slot[2] = slot[2] + 7;
            } else if (slot[1] >= 3 && slot[1] <= 6) {
                slot[2] = rand.nextInt(4);
                slot[2] = slot[2] + 3;
            } else {
                slot[2] = rand.nextInt(3);
            }
            return slot;
    }
}
        public static void playAgain( coin userBalance) {
            gamblingHome.whichGames(userBalance);
        }
}

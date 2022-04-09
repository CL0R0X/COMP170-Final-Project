import java.util.Random;
import java.util.Scanner;

public class Slots {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Slots");
        System.out.println("Rules: \n Match 3 of the same numbers for slots of 3 \n Match 5 of the same numbers for slots of 5");
        System.out.print("Would you like to bet on a Slot machine of 3 or 5 (3/5): ");
        int whichSlot = scan.nextInt();
        System.out.print("Insert 30 coins to begin playing: ");
        int coins = scan.nextInt();
        boolean userBet = false;

        if (coins == 30) {
            userBet = true;
        }
        while( userBet == false ) {
            System.out.print("Insert 30 coins to begin playing: ");
            coins= scan.nextInt();
            if (coins == 30) {
                userBet = true;
            }
        }
        if (whichSlot == 3) {
            rollingSlot3();
        } else if (whichSlot == 5) {
            rollingSlot5();
        }

    }

    public static void rollingSlot5() {
        Random rand = new Random();
        int slotNum1 = rand.nextInt(10);
        int slotNum2 = rand.nextInt(10);
        int slotNum3 = rand.nextInt(10);
        int slotNum4 = rand.nextInt(10);
        int slotNum5 = rand.nextInt(10);
        if (slotNum1 ==slotNum2 && slotNum2 ==slotNum3 && slotNum3 ==slotNum4 && slotNum4 ==slotNum5 && slotNum5 ==slotNum1 ) {
            System.out.println("Congradulations you won double your money");
            System.out.println("Your numbers were " + slotNum1 +slotNum2 +slotNum3 +slotNum4 +slotNum5);
        } else {
            System.out.println("You have lost 30 coins");
            System.out.println("Your numbers were " + slotNum1 +slotNum2 +slotNum3 +slotNum4 +slotNum5);
        }


    }
    public static void rollingSlot3() {
        Random rand = new Random();
        int slotNum1 = rand.nextInt(10);
        int slotNum2 = rand.nextInt(10);
        int slotNum3 = rand.nextInt(10);
        if (slotNum1 == slotNum2 && slotNum2 ==slotNum3 && slotNum3 ==slotNum1){
            System.out.println("You won double your money");
            System.out.println("Your numbers were: " +slotNum1 +slotNum2 + slotNum3);
        }else {
            System.out.println("You have lost 30 coins");
            System.out.println("Your numbers were: " +slotNum1 +slotNum2 + slotNum3);
        }
    }
}
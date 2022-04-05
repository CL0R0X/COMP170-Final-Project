import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class roulette {
    public static void main(String[]  args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to bet on Color or Number or Both (C/N/B): ");
        String request = scan.nextLine();
        request =request.toUpperCase();

        int rolledScore = rand.nextInt(36);

        System.out.print("How many coins do you want to bet? ");
        int coins = scan.nextInt();

        if (request == "C" ) {
            System.out.printf("What color tile do you pick red or black?(R/B/G) ");
            String color = scan.nextLine();
            color = color.toUpperCase();
            colorOfChoice(rolledScore, color);
        } else if(request == "N" ) {
            System.out.printf("What number out of 36 do you pick? ");
            int guessNumber = scan.nextInt();
            gambleNum(guessNumber, rolledScore);
        } else if( request == "B") {
            System.out.printf("What color tile do you pick red or black?(R/B/G) ");
            String color = scan.nextLine();
            color = color.toUpperCase();
            colorOfChoice(rolledScore, color);
            System.out.printf("What number out of 36 do you pick? ");
            int guessNumber = scan.nextInt();
            gambleNum(guessNumber, rolledScore);
        }
    }

    public static void colorOfChoice( int rolledNumber, String color) {
        if (rolledNumber %2 == 0 && color == "B") {
            System.out.printf("You have won, double your coins");
            reward(rolledNumber);
        } else if ( rolledNumber %2 == 1 && color == "R") {
            System.out.printf("You have won, double your coins");
            reward(rolledNumber);
        }else if( (rolledNumber == 0 || rolledNumber == 36 )&& color == "G") {
            System.out.printf("You have won, triple your coins");
            reward(rolledNumber);
        } else {
            System.out.print("Better luck next time ");
        }
    }

    public static void gambleNum( int guess, int rolledNumber) {
        if(guess == rolledNumber) {
            System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber);
            System.out.printf("You won 5 times your money");
            reward(rolledNumber);
        } else {
            System.out.printf("You have guessed " + guess + " and rolled " + rolledNumber);
            System.out.printf("Better luck Next Time");
        }
    }

    public static void reward( int rolledNumber) {

    }

}
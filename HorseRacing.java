
import java.util.Random;


public class HorseRacing {
    /*
     *  First have the console print out information about how Horse race willl work
     *  let the user pick/determine the amount of money they want to bet
     *
     *
     *  Have the console next print out 4 different track:
     * --------------------
     * track 1
     * --------------------
     * track 2
     * --------------------
     * track 3
     * -------------------
     * track 4
     *
     * have those 4 tracks listed in console
     * let the user pick which of the 4 tracks to bet on
     *
     * after the user picks which track he wants to bet on
     * save that into a variable
     * next send that variable into another method
     *
     * in order for the tracks to move to the end
     * create a random int with max of 1, there can be only 2 options 0 or 1
     * if the random integer hits a 1 that object would switch places with -
     * do a while loop for the track to happen
     * the first track that reaches to " "
     * record that track and send it to the other method
     * about which track the user had beted on
     *
     * that method will receive 2 different values
     * which determines if the user wins or loses
     * using a if else statements
     *
     *
     * */
   public static final int horseSum = 5;
    public static final int trackLength = 10;
    public static void main(String[] args) {
        System.out.println("Welcome to the Horse Race!\n");
        //setting up the String array for the track.
        Random rand = new Random();

        String[] track = new String[horseSum];
        int[] horsePlaces =  new int[horseSum];
        //This has to be a separate block of code from the other prints for now.
        for (int j = 0; j < horseSum; j++) {
            track[j] = "O";
            for (int i = 0; i < trackLength - 1; i++) {
                track[j] += "-";
            }
            System.out.println("Horse #" + (j + 1) + ": " + track[j]);
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
                winnerPlace = boostPlace;
            }
            System.out.println();
        }

        System.out.println("The Winner is Horse #" + (winnerPlace + 1) + "!!!" );



    }
    public static String[] horseForward(int place, int[] horsePlaces, String[] raceTrack) {
        /*
        for (int j = 0; j < horseSum; j++) {
            //track[j] = "O";
            for (int i = 0; i < trackLength - 1; i++) {
                //track[j] += "-";
            }
            System.out.println("Horse #" + (j + 1) + ": " + track[j]);
        } */
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
}

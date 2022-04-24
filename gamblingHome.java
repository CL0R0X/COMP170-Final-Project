package com.company;

import java.util.Scanner;



public class gamblingHome {
    public static coin userBalance = new coin();
    public static final int boxSize = 35;
    public static void main(String[] args) {
        String welcome = ("Welcome to the Gambling Hub!!");
        printerHelper(welcome, boxSize - welcome.length());
        whichGames(userBalance);
    }
    public static void whichGames(coin userBalance) {
        // ^^ initializing balance.
        Scanner scan = new Scanner(System.in);

        String options = "What games do you want to play: ";
        printerHelper(options, boxSize - options.length());
        String[] choices = new String[5];
        choices[0] = "Black_Jack";
        choices[1] = "Dice";
        choices[2] = "Roulette";
        choices[3] = "Slots";
        choices[4] = "Horse_Racing";
        //System.out.printf("| %34s |\n| %34s |", welcome, options );
        for (int i = 0; i < choices.length; i++) {
            //System.out.printf("\n| %12s |", choices[i]);
            printerHelper(choices[i], boxSize - choices[i].length());
        }
        System.out.println();
        System.out.print("What game do you want to select: ");
        String gameChoice = scan.next();

        //try {
        int breakcheck = 0;
        while (breakcheck == 0) {
            if (gameChoice.equals("Black_Jack")) {
                com.company.blackjack.games(userBalance);
                breakcheck++;
            } else if (gameChoice.equals("Dice")) {
                com.company.diceGame.games(userBalance);
                breakcheck++;
            } else if (gameChoice.equals("Roulette")) {
                com.company.roulette.games(userBalance);
                breakcheck++;
            } else if (gameChoice.equals("Slots")) {
                com.company.Slots.games(userBalance);
                breakcheck++;
            } else if (gameChoice.equals("Horse_Racing")) {
                com.company.horseBetting.games(userBalance);
            }
            System.out.print("What game do you want to select: ");
            gameChoice = scan.next();
        }
        //} catch (Exception e) {
        //System.out.printf("| %34s |\n | %34s | ", options);
        //ring gamechoices  = scan.next();


    }

    public static void printerHelper(String input, int spacesToFill) {
        for (int i = 0; i < spacesToFill; i++) {
            if (i % 2 == 0) {
                input = " " + input;
            } else {
                input = input + " ";
            }
        }

        System.out.println("|" + input + "|");

    }
    /*
    printHome() {
    printHome will be a function that prints out an easily adjustable window. This window
    will serve as a home page in our program, from which the user can type which game they
    would like to play (out of the ones listed on screen.)
    for (loop for columns) {
        for (loops for size of window) {
            print out spaces + text
        }
    }
    It may be beneficial to have a string array for this to store the names of
     */
    /*
    gameSelection() {
    create a System print of "Would you want to play: BlackJack/n , Dice /n, Roulette /n, slots,/n  Horse Racing"
    assign variable to the response of the code above
    use a if else statement to select which game to pick/load the code for the game
    It will be linked with the printHome() method for producing the size of lines
    }
    */

   /*
    blackjack() {
    blackjack is, as the name implies, the card game blackjack. The user will be presented with the current sum of their
    cards, and if the sum goes past 21, they lose. If they hit 21 exactly or have a number closer to 21 then the dealer, they win.
    Super compressed code would be something like:
        (card values defined and stored)
        Ask for user's bet out of their current balance.
        Deal out two of these cards randomly using a new Random.
        User chooses whether to draw another random card based on their current sum.
        if (sum > 21) {
            user loses.
        }
        Code above will loop until user decides to stop or 5 turns have been ran through.
        After loop, compare with dealer's hand.
        if (dealerHand < userhand) {
             user wins.
             Multiply bet by x amount (yet to be determined) and add it to balance)
        else if (dealerHand = userHand) {
             user and dealer draw.
        else if (dealerHand > userHand) {
             user loses.
             Deduct bet from balance.
        }
        Prompt user to see if they want to play again (show their new balance as well with their wins/losses.
        if (yes) {
            restart program.
        else if (no) {
            printHome();
        }
    */

    /*
    Slots() {
    slots game is a game where you need to match the 3 numbers for the user to get a reward
    In order to get the 3 random numbers necessary for the slots game to function
    you would use a randomInt value and set it to 11 =
    num1 =randInt(11);
    print = user gets num1
    num2 =randInt(11);
    print = user gets num2
    num3 =randInt(11);
    print = user gets num3
     if num1 == num2 && num2 ==num3 && num1 == num3 {
    user gets rewards if it gets equal
     }
    }
    */

    /*
    diceGame() {
    This game is very simple- the user will guess the number the dice rolls. Before this, the user decides how many dice they want to roll.
    collectBet();
    (They can only roll 1-3)
    if (userInput = 1) {
        diceRoll = RandomNum(1-6)
    else if (userInput = 2) {
        diceRoll = RandomNum(1-12)
    else if (userInput = 3) {
        diceRoll = RandomNum(1-18)
    }
    then, we check the user's input to see if it matches the diceRoll.
    if (userGuess = diceRoll) {
        user wins bet * (userInput + 0.5)
    } else {
        user loses, balance = balance - bet
    }
    */
        /*
    roulette(){
    The pockets of the roulette wheel are numbered from 0 to 36. In number ranges from 1 to 10 and 19 to 28, odd numbers are red and even are black.
    Green tiles are 0 and 36
    allow the user to pick whether he wants to bet on tiles or tiles and number or numbers alone
    create a function if/else to determine whether the function is odd or even
    if outcome odd then user is on the black tile and if user bet black tile reward is 1.5times
    if outcome even then user is on the red tile and if user bet red tile reward is 1.5times
    if outcome is green tile then randint lands on 0 or 36 then reward is 3times
    if outcome is guessed both number and tile then reward is 5 times
    if user bets on green tile and number then reward is 10 times
    }
    */

    /*
    horseRace() {
    There are a series of 5 horses(0):
    &---------
    0---------
    $---------
    The first variable & in is called an num1
    have a random int is equal to 1 then the value moves
    for example:
    -&--------
    0---------
    $---------
    the mechanism for the horses to move is similar to:
    int temp = num1;
    num1 = num2;
    num2 = temp;
    }
    the track would last for 10 -
    and the loop is run by a while loop
    while( num != 1) {}
    reward for betting on first one to come to end is 5 times
    */
}

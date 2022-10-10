package pig_dice.lib;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Pig_Dice {
    public static void main(String[] args) {
        // declare primitive variables
        int dieRoll = 0, playerNumber;
        boolean win = false;
        String choice = "";

        // declare object instances
        Random rand = new Random();
        Scanner userInput = new Scanner(System.in);
        Scanner userInputNum = new Scanner(System.in);

        Player p1 = new Player(0, 0, 0);
        Player p2 = new Player(0, 0, 0);
        Player p3 = new Player(0, 0, 0);
        Player p4 = new Player(0, 0, 0);
        Player p5 = new Player(0, 0, 0);
        Player p6 = new Player(0, 0, 0);

        PlayerRoll player1 = new PlayerRoll(p1, userInput, rand, choice, "||------------------------Player 1------------------------||", dieRoll, win);
        PlayerRoll player2 = new PlayerRoll(p2, userInput, rand, choice, "||------------------------Player 2------------------------||", dieRoll, win);
        PlayerRoll player3 = new PlayerRoll(p3, userInput, rand, choice, "||------------------------Player 3------------------------||", dieRoll, win);
        PlayerRoll player4 = new PlayerRoll(p4, userInput, rand, choice, "||------------------------Player 4------------------------||", dieRoll, win);
        PlayerRoll player5 = new PlayerRoll(p5, userInput, rand, choice, "||------------------------Player 5------------------------||", dieRoll, win);
        PlayerRoll player6 = new PlayerRoll(p6, userInput, rand, choice, "||------------------------Player 6------------------------||", dieRoll, win);

        try {
            // Tell the users the rules of the game
            System.out.println("||--------------------Rules of Pig Dice-------------------||");
            System.out.println("||You start your turn by rolling a dice                   ||");
            System.out.println("||                                                        ||");
            System.out.println("||You can choose to continue rolling,                     ||");
            System.out.println("||or you can choose to pass                               ||");
            System.out.println("||                                                        ||");
            System.out.println("||If you keep rolling and get a 1,                        ||");
            System.out.println("||you get no points                                       ||");
            System.out.println("||                                                        ||");
            System.out.println("||When you choose to pass,                                ||");
            System.out.println("||your score is added to your total                       ||");
            System.out.println("||                                                        ||");
            System.out.println("||When you reach 100 points,                              ||");
            System.out.println("||you win the game and the program ends                   ||");
            System.out.println("||                                                        ||");
            System.out.println("||Good Luck!                                              ||");
            System.out.println("||--------------------------------------------------------||");

            // ask user for number of players
            System.out.println();
            System.out.println("||-------How many Players will you be playing with?-------||");
            System.out.print("||Enter a number from 2 - 6: ");
            playerNumber = userInputNum.nextInt();
            System.out.println("||--------------------------------------------------------||");
            System.out.println();

            /**
             * Go through each player and ask them if they will roll or pass. They must roll
             * the first time. If they get a 1, they will have nothing added to their score,
             * unless it is the first roll. When a player chooses to stop rolling, add their
             * current score to the final score. When a player reaches 100, they stop
             * rolling and win the game.
             */

            // do-while loop repeats until someone has won
            do {
                // for loop goes through and repeats code for each player
                for (int i = 1; i <= playerNumber; i++) {
                    // go through the code until someone wins
                    if (win == false) {
                        switch (i) {
                            case 1:
                                player1.roll();
                                if (player1.win == true)
                                    win = true;
                                break;
                            case 2:
                                player2.roll();
                                if (player2.win == true)
                                    win = true;
                                break;
                            case 3:
                                player3.roll();
                                if (player3.win == true)
                                    win = true;
                                break;
                            case 4:
                                player4.roll();
                                if (player4.win == true)
                                    win = true;
                                break;
                            case 5:
                                player5.roll();
                                if (player5.win == true)
                                    win = true;
                                break;
                            case 6:
                                player6.roll();
                                if (player6.win == true)
                                    win = true;
                                break;
                        }// end of switch i

                    } // end of if statement
                } // end of for loop
            } while (win == false);// end of do-while for Going through Players
        } catch (InputMismatchException error) {
            System.out.println("That is not a good input!");
        } catch (Exception e) {
            System.out.println("Something went Very Wrong!!!");
        } // end of try-catch

        // tell the user the program has ended
        System.out.println("||            THE PROGRAM HAS BEEN TERMINATED             ||");
        System.out.println("||--------------------------------------------------------||");

    }// end of main
}// end of Pig_Dice

class Player {
    // declare variables
    int finalScore, currentScore, currentTotal;

    // constructor Structure
    Player(int fScore, int cScore, int cTotal) {
        finalScore = fScore;
        currentScore = cScore;
        currentTotal = cTotal;

    }
}// end of Player

class PlayerRoll {
    // declare variables
    Player userP;
    Scanner userInput;
    Random rand;
    String choice, pName;
    int dieRoll;
    boolean win;

    // constructor structure
    PlayerRoll(Player userP, Scanner userInput, Random rand, String choice, String pName, int dieRoll, boolean win) {
        this.userP = userP;
        this.userInput = userInput;
        this.rand = rand;
        this.choice = choice;
        this.pName = pName;
        this.dieRoll = dieRoll;
        this.win = win;

    }// end of PlayerRoll constructor

    void roll() {

        // roll the first die and add to current score
        System.out.println();
        System.out.println(pName);
        dieRoll = rand.nextInt(6) + 1;
        System.out.println("||Your First roll is " + dieRoll);
        userP.currentScore += dieRoll;

        // do-while loop repeats until the player passes or gets a 1 or wins
        do {
            // determine if they have won
            if ((userP.currentScore + userP.finalScore) >= 100) {
                win = true;
                System.out.println("||");
                System.out.println(pName);
                System.out.println("||                    You Have Won!!!                     ||");
                System.out.println("||                  Your Final Score Was:                 ||");
                System.out.println("||                           " + (userP.currentScore + userP.finalScore) + "                          ||");
                System.out.println("||--------------------------------------------------------||");
                System.out.println();
            } else {
                // ask if they would like to roll or pass
                System.out.println("||");
                System.out.println("||Would you like to Roll or Pass? (Enter Roll or Pass)");
                System.out.print("||");
                choice = userInput.nextLine();

                // evaluate their answer
                if (choice.contentEquals("Roll") || choice.contentEquals("roll")) {
                    // roll the die and decide what to do
                    dieRoll = rand.nextInt(6) + 1;
                    System.out.println("||You got a " + dieRoll);

                    if (dieRoll == 1) {
                        System.out.println("||You got a 1, you get no points this round");
                        userP.currentScore = 0;
                    } else {
                        userP.currentScore += dieRoll;
                        System.out.println("||Your Current Score is " + userP.currentScore);
                        System.out.println("||Your Current Total is " + (userP.currentScore + userP.finalScore));
                    }

                } else if (choice.contentEquals("Pass") || choice.contentEquals("pass")) {
                    // add their currentScore to their finalScore and clear their currentScore
                    userP.finalScore += userP.currentScore;
                    userP.currentScore = 0;
                    System.out.println("||Your Total Score is " + userP.finalScore);
                } else {
                    System.out.println("||That is an invalid input, enter \"Roll\" or \"Pass\"");
                }
            } // end of did they win? if-else statement

        } while (!choice.contentEquals("Pass") && !choice.contentEquals("pass") && dieRoll != 1 && win == false);// end of do-while loop for rolling/passing
        System.out.println("||--------------------------------------------------------||");
    }// end of roll Method

}// end of PlayerRoll Class
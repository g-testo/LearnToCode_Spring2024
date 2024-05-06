package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Understand the problem
        // Devise a plan
        // Code!
        // Look back

        // --- Understand the problem ---

        // Yahtzee
        // Dice game
        // Dice: 1-6

        // 5 6-sided dice
        // 3 rolls per round
        // 13 rounds
        // At the end of each round, choose a category

        // Phase One
        // Single Player
        // Super simple

        // Goal- Maximize score

        // --- Understand the problem ---

        // -- Devise a plan --

        // Keep track of...
            // Class: Game
            // -Current dice
            // -Saved dice
            // -Times dice rolled
            // -What round?
            // -What categories are locked in and the score for each...

        // Create command line UI
            // Initial message that says: "Let's play some Yahtzee!"
            // Ask the user to roll dice
                // MENU
                    // ROLL
                    // QUIT
                // Display the current dice
                // Ask the user what would they like to do?
                // MENU
                    // Choose what dice to keep... And show current saved dice
                        // Saved:
                        // Unsaved: (A)2 (B)4 (C)6 (D)1 (E)3
                        // MENU
                            // What dice position would you like to choose?
                    // Reroll the unsaved dice
                    // Choose a category
                        // See category section
                    // QUIT


        // Categories
            //Aces	Any combination	The sum of dice with the number 1
            //Twos	Any combination	The sum of dice with the number 2
            //Threes	Any combination	The sum of dice with the number 3
            //Fours	Any combination	The sum of dice with the number 4
            //Fives	Any combination	The sum of dice with the number 5
            //Sixes	Any combination	The sum of dice with the number 6

            //Three Of A Kind	At least three dice the same Sum of all dice
            //Four Of A Kind	At least four dice the same	Sum of all dice
            //Full House	Three of one number and two of another
            //Small Straight	Four sequential dice (1-2-3-4, 2-3-4-5, or 3-4-5-6)
            //Large Straight	Five sequential dice (1-2-3-4-5 or 2-3-4-5-6)
            //Yahtzee	All five dice the same	50	33333
            //Chance	Any combination	Sum of all dice	11345
        // Dices

        // -- Devise a plan --

        Scanner scanner = new Scanner(System.in);

        int mainMenuCommand;
        do {
            // -- Code! --
            System.out.println("Let's play some Yahtzee!");
            System.out.println("What would you like to do?");
            System.out.println("1) ROLL");
            System.out.println("2) QUIT");

            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:

                    int subMenuCommand;
                    do {
                        System.out.println("Dice have been rolled");
                        System.out.println("You rolled the following: 2 1 5 3 2");
                        System.out.println("What would you like to do next?");
                        System.out.println("1) Choose dice to keep");
                        System.out.println("2) Reroll unsaved dice");
                        System.out.println("3) End round and choose category");
                        System.out.println("4) BACK");

                        subMenuCommand = scanner.nextInt();

                        switch (subMenuCommand) {
                            case 1:

                                int keepDiceMenuCommand;

                                do{
                                    System.out.println("Saved: ");
                                    System.out.println("Unsaved: \n1) 2 \n2) 1 \n3) 5 \n4) 3 \n5) 2 \n6) KEEP ALL");
                                    System.out.println("What die would you like to keep?");

                                    keepDiceMenuCommand = scanner.nextInt();

                                    switch (keepDiceMenuCommand){
                                        case 1:
                                            System.out.println("You kept 2");
                                            break;
                                        case 2:
                                            System.out.println("You kept 1");
                                            break;
                                        case 3:
                                            System.out.println("You kept 5");
                                            break;
                                        case 4:
                                            System.out.println("You kept 3");
                                            break;
                                        case 5:
                                            System.out.println("You kept 2");
                                            break;
                                        case 6:
                                            System.out.println("KEEP DICE...");
                                            break;
                                        default:
                                            System.out.println("Command not found");
                                    }

                                } while (keepDiceMenuCommand != 6);

                                break;
                            case 2:
                                System.out.println("You rerolled");
                                break;
                            case 3:
                                System.out.println("The round is over, please choose a category...");
                                // Show categories to choose from
                                break;
                            case 4:
                                System.out.println("Back to the main menu...");
                                break;
                            default:
                                System.out.println("Command not found");
                        }
                    } while (subMenuCommand != 4);

                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found");
            }
        }while(mainMenuCommand != 2);

        // -- Code! --


    }
}
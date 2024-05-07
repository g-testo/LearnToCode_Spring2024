package com.ps;

import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    public static void display() {
        init();
    }

    private static void init() {
        int mainMenuCommand;
        do {
            System.out.println("Let's play some Yahtzee!");
            System.out.println("What would you like to do?");
            System.out.println("1) START GAME");
            System.out.println("2) QUIT");

            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    handleStartGame();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found");
            }
        } while (mainMenuCommand != 2);
    }

    private static void handleStartGame(){
        int subMenuCommand;
        do {

            // Input: Takes in nothing
            // Output [1,4,2,5,3] int[]
            // init roll
            // reroll




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
                    handleKeepDice();
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
    }

    private static void handleKeepDice(){
        int keepDiceMenuCommand;

        do {
            System.out.println("1) 2(Saved) \n2) 1(Unsaved) \n3) 5(Unsaved) \n4) 3(Unsaved) \n5)(Unsaved) 2 \n6) KEEP ALL");
            System.out.println("What die would you like to keep?");

            keepDiceMenuCommand = scanner.nextInt();

            switch (keepDiceMenuCommand) {
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
    }

}

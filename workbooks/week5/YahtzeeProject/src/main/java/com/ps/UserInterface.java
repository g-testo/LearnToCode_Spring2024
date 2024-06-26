package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Game game = new Game();
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
            System.out.println("Dice have been rolled");
            ArrayList<Integer> currentRollArr = game.getCurrentRoll();

            String strNumbers = "";

            for(int i=0;i<currentRollArr.size();i++){
                strNumbers += currentRollArr.get(i) + " ";
            }

            System.out.printf("You rolled the following: %s\n", strNumbers);
            System.out.println("What would you like to do next?");
            System.out.println("1) Choose dice to reroll");
            System.out.println("2) End round and choose category");
            System.out.println("3) BACK");

            subMenuCommand = scanner.nextInt();

            switch (subMenuCommand) {
                case 1:
                    if(game.getCurrentRerollsLeft() > 0){
                        handleRerollDice();
                    } else {
                        System.out.println("No rerolls left");
                    }
                    break;
                case 2:
                    System.out.println("The round is over, please choose a category...");

                    ArrayList<Combination> upper = game.getUpperCombinations();
                    ArrayList<Combination> lower = game.getLowerCombinations();

                    for(int i = 0;i<upper.size();i++){
                        Combination upperCombo = upper.get(i);
                        Combination lowerCombo = lower.get(i);
                        ArrayList<Integer> currentRoll = game.getCurrentRoll();

                        System.out.printf("%d) %-6s- %-2d      %2d) %-16s - %-2d\n",
                                upperCombo.getId(),
                                upperCombo.getDisplayName(),
                                upperCombo.calculateScore(currentRoll),
                                lowerCombo.getId(),
                                lowerCombo.getDisplayName(),
                                lowerCombo.calculateScore(currentRoll)
                        );
                    }
                    break;
                case 3:
                    System.out.println("Back to the main menu...");
                    break;
                default:
                    System.out.println("Command not found");
            }
        } while (subMenuCommand != 3);
    }

    private static void handleRerollDice(){
        int rerollDiceMenuCommand;
        boolean[] diceToReroll = {false, false, false, false, false};
        ArrayList<Integer> currentRollArr = game.getCurrentRoll();

        do {
            String rollToDisplay = "";
            for(int i = 0; i < currentRollArr.size();i++){
                rollToDisplay += i+1 + ") " + currentRollArr.get(i) + (diceToReroll[i] ? "(Reroll)": "") + "\n";
            }
            rollToDisplay += "6) DONE";
            System.out.println(rollToDisplay);

            System.out.println("What dice would you like to reroll?");

            rerollDiceMenuCommand = scanner.nextInt();

            switch (rerollDiceMenuCommand) {
                case 1:
                    diceToReroll[0] = !diceToReroll[0];
                    break;
                case 2:
                    diceToReroll[1] = !diceToReroll[1];
                    break;
                case 3:
                    diceToReroll[2] = !diceToReroll[2];
                    break;
                case 4:
                    diceToReroll[3] = !diceToReroll[3];
                    break;
                case 5:
                    diceToReroll[4] = !diceToReroll[4];
                    break;
                case 6:
                    game.rollDice(diceToReroll);
                    break;
                default:
                    System.out.println("Command not found");
            }

        } while (rerollDiceMenuCommand != 6);
    }

}

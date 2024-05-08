package com.ps;

import java.util.ArrayList;
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

        // Responsibilities


        // Phase 1
        // UserInterface
        // Game

        // Phase 2
        // Add Colors! i.e. saved vs unsaved
        // FileManager / HighScores
        // SETTINGS menu / Config file


        // -- Code! --

        UserInterface.display();

        // -- Code! --
    }
}
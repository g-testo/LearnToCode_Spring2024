package com.ps;

import java.util.ArrayList;

public class Combination {
    private int id;
    private String displayName;

    public Combination(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int calculateScore(ArrayList<Integer> dice){
        switch (this.id){
            case 1:
                // Ones
                return calculateUpperCombo(dice, 1);
            case 2:
                // Twos
                return calculateUpperCombo(dice, 2);
            case 3:
                // Threes
                return calculateUpperCombo(dice, 3);
            case 4:
                // Fours
                return calculateUpperCombo(dice, 4);
            case 5:
                // Fives
                return calculateUpperCombo(dice, 5);
            case 6:
                // Sixes
                return calculateUpperCombo(dice, 6);
            case 7:
                // Three of a kind
                return calculateOfAKind(dice, 3);
            case 8:
                // Four of a kind
                return calculateOfAKind(dice, 4);
            case 9:
                // Full House
                break;
            case 10:
                // Small Straight
                break;
            case 11:
                // Large Straight
                break;
            case 12:
                // Chance
                break;
            case 13:
                // YAHTZEE
                break;
            default:
        }
        return 0;
    }

    public static int calculateOfAKind(ArrayList<Integer> dice, int numOfOccurrences) {
        int[] diceCounter = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < dice.size(); i++) {
            int dieValue = dice.get(i);
            diceCounter[dieValue - 1] = diceCounter[dieValue - 1] + 1;
        }

        for (int i = 0; i < diceCounter.length; i++) {
            if (diceCounter[i] > numOfOccurrences-1) {
                return calculateSumOfDice(dice);
            }
        }

        return 0;
    }

    public static int calculateSumOfDice(ArrayList<Integer> dice){
        int total = 0;
        for(int i=0;i<dice.size();i++){
            total += dice.get(i);
        }
        return total;
    }

    public static int calculateUpperCombo(ArrayList<Integer> dice, int diceValue){
        int score = 0;
        for(int i=0;i<dice.size();i++){
            if(dice.get(i).equals(diceValue)){
                score+=diceValue;
            }
        }
        return score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

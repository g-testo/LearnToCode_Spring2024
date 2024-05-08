package com.ps;

import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> currentRoll = new ArrayList<>();
    // Contain game actions
    // rollDice
    //

    public Game(){
        rollDice();
    }
    public void rollDice(){
        int numOfDice = this.currentRoll.size();
        int diceToRoll = 5 - numOfDice;

        for(int i=0;i<diceToRoll;i++){
            int randomNum = generateNewDieValue();
            this.currentRoll.add(randomNum);
        }
    }

    public void rollDice(boolean[] diceToReroll){

        for(int i=0;i<this.currentRoll.size();i++){

            if(diceToReroll[i]){
                int newDieValue = generateNewDieValue();
                this.currentRoll.set(i, newDieValue);
            }

        }

    }

    public static int generateNewDieValue(){
        return (int)(Math.random() * 6) + 1;
    }

    public ArrayList<Integer> getCurrentRoll() {
        return this.currentRoll;
    }
}

package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private int currentRound;
    private int currentRerollsLeft;


    private ArrayList<Integer> currentRoll = new ArrayList<>();

    private ArrayList<Combination> upperCombinations = new ArrayList<>();
    private ArrayList<Combination> lowerCombinations = new ArrayList<>();;

    // Contain game actions
    // rollDice
    //

    public Game(){
        populateCombinations();

        this.currentRound = 1;
        this.currentRerollsLeft = 2;
        rollDice();
    }

    private void populateCombinations(){
        try{
            BufferedReader bufReader = new BufferedReader(new FileReader("combinations.csv"));

            String input;
            int lineCount = 0;
            while((input = bufReader.readLine()) != null){
                lineCount++;

                String[] splitLine = input.split(",");
                int id = Integer.parseInt(splitLine[0]);
                String displayName = splitLine[1];

                if(lineCount < 8){
                    upperCombinations.add(new Combination(id, displayName));
                } else {
                    lowerCombinations.add(new Combination(id, displayName));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
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
        this.currentRerollsLeft--;

        if(this.currentRerollsLeft < 0){
            System.out.println("No rerolls left");
            return;
        }

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

    public void startNewRound(){
        this.currentRound++;
        this.currentRerollsLeft = 2;
    }

    public int getCurrentRound(){
        return this.currentRound;
    }

    public int getCurrentRerollsLeft(){
        return this.currentRerollsLeft;
    }

    public ArrayList<Integer> getCurrentRoll() {
        return this.currentRoll;
    }

    public ArrayList<Combination> getUpperCombinations() {
        return upperCombinations;
    }

    public ArrayList<Combination> getLowerCombinations() {
        return lowerCombinations;
    }
}

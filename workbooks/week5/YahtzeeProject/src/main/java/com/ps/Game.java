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
            int randomNum = (int)(Math.random() * 6) + 1;
            this.currentRoll.add(randomNum);
        }
    }

    public ArrayList<Integer> getCurrentRoll() {
        return this.currentRoll;
    }

    public void removeDie(int index){
        // Guard Clause
        try{
            this.currentRoll.remove(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Can't remove that die");
//            e.printStackTrace();
        }
    }
}

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

    public void rerollDice(boolean[] diceToReroll){
        try{


//           diceToReroll: [true,false,true, true, false]
//           Current Roll: [1,6,3,4,2]


//            for(int i=0;i<diceToReroll.length;i++){
//                if(diceToReroll[i]){
//                    game.removeDie(i);
//                }
//            }

//          game.rollDice();
            this.currentRoll.remove(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Can't remove that die");
        }
    }
}

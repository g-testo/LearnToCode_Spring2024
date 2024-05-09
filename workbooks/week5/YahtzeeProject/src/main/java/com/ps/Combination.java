package com.ps;

import java.util.ArrayList;

public class Combination {
    private int id;
    private String displayName;

    public Combination(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int calculateScore(ArrayList dice){
        switch (this.id){
            case 1:
                // Ones
                break;
            case 2:
                // Twos
                break;
            case 3:
                // Threes
                break;
            case 4:
                // Fours
                break;
            case 5:
                // Fives
                break;
            case 6:
                // Sixes
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            default:
        }
        return 0;
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

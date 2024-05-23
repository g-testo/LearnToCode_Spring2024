package com.ps;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        World world = new World(600, 600, Color.BLACK);
        Turtle turtle = new Turtle(world, 0, 0);

        Color[] colors = {Color.red,Color.BLUE, Color.GREEN, Color.PINK};

//        0 : 1 5
//        1 : 2 6
//        2 : 3 7
//        3 : 4 8
        int accum = 0;
        for(int i=1;i<30;i++){
            int randomSize = (int) ((Math.random() * (6 - 1)) + 1);
            turtle.setPenWidth(randomSize);

            int colorIndex = (i-1)%4;

            turtle.setColor(colors[colorIndex]);

            turtle.forward(accum);
            turtle.turnRight(90);
            accum += i;
        }

    }
}
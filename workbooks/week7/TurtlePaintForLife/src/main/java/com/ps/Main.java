package com.ps;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    private static World world = new World(600, 600, Color.BLACK);
    public static void main(String[] args) {
//        Turtle turtle = new Turtle(world, 0, 0);
//        turtle.setPenWidth(1);
//        turtle.setDelay(.1);
//        singleSpiral(turtle);

        multiSpiral();
    }

    public static void multiSpiral(){
        int width = 150;
        int[][] coordinates = {{-width, -width},{width,-width},{width,width},{-width,width}};
        ArrayList<Turtle> turtles = new ArrayList<>();

        for(int[] coordinate: coordinates){
            Turtle turtle = new Turtle(world, coordinate[0], coordinate[1]);

            turtle.setShellSize(0);
            turtle.setPenWidth(1);
            turtle.setDelay(.01);

            turtles.add(turtle);
        }

        for(Turtle turtle: turtles){
            world.addTurtle(turtle);
            singleSpiral(turtle);
        }
    }

    public static void singleSpiral(Turtle turtle){
        Color[] colors = {Color.red,Color.BLUE, Color.GREEN, Color.PINK};

        int accum = 0;
        for(int i=1;i<25;i++){
            int colorIndex = (i-1)%4;
            turtle.setColor(colors[colorIndex]);
            turtle.forward(accum);
            turtle.turnRight(90);
            accum += i;
        }
    }
}
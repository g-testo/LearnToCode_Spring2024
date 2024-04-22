package com.ps;


import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader bufReader = new BufferedReader(new FileReader("song.txt"));

            String input;

            while((input = bufReader.readLine()) != null){
                System.out.println(input);
            }

        } catch(Exception e){
            System.out.println("Error!!!!");
            e.printStackTrace();
        }
    }
}
package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("employeeData.txt"));

            String line;
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
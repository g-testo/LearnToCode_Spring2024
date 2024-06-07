package com.ps.problems;

import java.util.ArrayList;

public class SpotDifferences {

    public static void run(){
        String str1 = "Bird";
        String str2 = "Word";

        String str3 = "Hello World!";
        String str4 = "hello world.";

        // Create an array to store the differences
        ArrayList<Integer> diff = new ArrayList<>();

        // Iterate through an input
        for(int i=0;i<str3.length(); i++){
            // Compare the value at each position
            // If different, add to the array
            if(str3.charAt(i) != str4.charAt(i)){
                diff.add(i);
            }
        }
//      return the difference array
        System.out.println(diff);
    }
}

package com.ps.problems;

// At the annual family gathering, the family likes to
// find the oldest living family member’s age and the youngest
// family member’s age and calculate the difference between them.
// You will be given an array of all the family members' ages,
// in any order. The ages will be given in whole numbers, so a baby
// of 5 months, will have an ascribed ‘age’ of 0. Return a new array
// (a tuple in Python) with [youngest age, oldest age, difference between
// the youngest and oldest age].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DifferenceInAge {
    public static void run() {
        ArrayList<Integer> input1 = new ArrayList<>( // [6, 82, 76]
                Arrays.asList(82, 15, 6, 38, 35)
        );

        ArrayList<Integer> input2 = new ArrayList<>( // [14, 99, 85]
                Arrays.asList(57, 99, 14, 32)
        );

        int oldest = 0;
        int youngest = input1.get(0);

        for(int num: input2){
            if(num > oldest){
                oldest = num;
            }
            if(num < youngest){
                youngest = num;
            }
        }
        System.out.println(Arrays.toString(new int[]{youngest, oldest, oldest - youngest}));
//        int oldest = Collections.max(input2);
//        int youngest = Collections.min(input2);
//        int dif = oldest - youngest;
//
//        System.out.println(Arrays.toString(new int[]{youngest, oldest, dif}));
    }


}

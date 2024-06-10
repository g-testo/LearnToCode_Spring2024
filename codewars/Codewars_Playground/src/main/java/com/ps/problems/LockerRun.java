package com.ps.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class LockerRun{
    public static void run() {
//        int lockers = 1_000; // [1,4,9]
//        boolean[] lockerStatuses = new boolean[lockers];
//        // [true,false,false,true,false,false,false,false,true,false]
//        for(int i=1;i<=lockers;i++){ // Total run through all lockers
//            for(int j=i;j<lockers; j+=i) { // Run through each locker
//                lockerStatuses[j-1] = !lockerStatuses[j-1];
//            }
//        }
//
//        System.out.println(Arrays.toString(lockerStatuses));



        int lockers = 100; // [1,4,9]


//        [1,4,9,16,25,36,49,64,81,100] 3,5,7,9,11,13,15,17 (0,1,2,3,4,5,6,7,8)
        ArrayList<Integer> newArray = new ArrayList<>();

        for(int i=1; Math.pow(i,2) <= lockers;i++){
            newArray.add((int) Math.pow(i,2));
        }

        System.out.println(newArray);
    }
}

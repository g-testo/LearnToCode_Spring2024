package com.ps.problems;

import java.util.Arrays;

public class LockerRun{
    public static void run() {
        int lockers = 1_000; // [1,4,9]
        boolean[] lockerStatuses = new boolean[lockers];
        // [true,false,false,true,false,false,false,false,true,false]
        for(int i=1;i<=lockers;i++){ // Total run through all lockers
            for(int j=i;j<lockers; j+=i) { // Run through each locker
                lockerStatuses[j-1] = !lockerStatuses[j-1];
            }
        }

        System.out.println(Arrays.toString(lockerStatuses));
    }
}

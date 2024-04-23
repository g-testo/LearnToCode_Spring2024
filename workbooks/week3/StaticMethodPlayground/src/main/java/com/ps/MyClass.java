package com.ps;

public class MyClass {
    static int staticCounter;
    int instanceCounter;

    public MyClass(){
        instanceCounter = 0;
    }

    public static void incrementStatic(){
        staticCounter++;
    }

    public void incrementInstance(){
        staticCounter++;
        this.instanceCounter++;
    }
}

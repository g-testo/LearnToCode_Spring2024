package com.ps;

public class AnotherClass {

    public static void init(){
        run();

        NestedClass.run();
    }

    public static void run(){
        System.out.println("Hello World from AnotherClass");
    }

    private static class NestedClass{
        private static void run(){
            System.out.println("Hello World from a nested class");
        }
    }
}

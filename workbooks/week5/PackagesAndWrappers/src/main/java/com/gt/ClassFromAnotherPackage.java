package com.gt;

public class ClassFromAnotherPackage {
    public static void run(){
        System.out.println("Hello World From another package");
    }

    public static class NestedClass{
        static void run(){
            System.out.println("Hello World from a nested class");
        }
    }
}

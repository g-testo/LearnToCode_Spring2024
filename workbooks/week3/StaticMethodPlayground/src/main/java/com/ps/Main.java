package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        MyClass myClass3 = new MyClass();

        myClass1.incrementInstance();

        myClass2.incrementInstance();
        myClass2.incrementInstance();

        myClass3.incrementInstance();
        myClass3.incrementInstance();
        myClass3.incrementInstance();
        myClass3.incrementInstance();

        System.out.println("myClass1 Static " + myClass1.staticCounter);
        System.out.println("myClass2 Static " + myClass2.staticCounter);
        System.out.println("myClass3 Static " + myClass3.staticCounter);

        System.out.println("myClass1 Instance: " + myClass1.instanceCounter);
        System.out.println("myClass2 Instance: " + myClass2.instanceCounter);
        System.out.println("myClass3 Instance: " + myClass3.instanceCounter);

        // Static: 3
        // 1: 1
        // 2: 2
        // 3: 0


        Math.pow(2, 2);

    }

}
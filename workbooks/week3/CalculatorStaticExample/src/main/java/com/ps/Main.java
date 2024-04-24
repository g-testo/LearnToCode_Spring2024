package com.ps;

public class Main {
    public static void main(String[] args) {
//        Main main = new Main(); // This is how you access instance methods
//        main.addInstance(100, 200);

//        Main.add(20, 50); // Can be accessed anywhere
//        add(10, 20); // Can only be referenced like this inside of the class it was defined in

//        StaticCalc.pow(2, 3);
//        StaticCalc.rectArea(2.5f, 37);

        InstCalc instance1 = new InstCalc(20, 10);

        int addResult = instance1.add();
        int subResult = instance1.sub();

        System.out.println(addResult);
        System.out.println(subResult);
    }

    public static void add(int num1, int num2){
        System.out.println(num1 + num2);
    }

    public void addInstance(int num1, int num2){
        System.out.println(num1 + num2);
    }
}
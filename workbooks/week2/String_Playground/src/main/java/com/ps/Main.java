package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int num1 = 5;
//        int num2 = 5;
//
//        System.out.println(num1 == num2);

//        String s1 = new String("ABC");
//
//        System.out.println(s1);
//        String s2 = new String("ABC");
//
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));

//        String word = "  Explosions!   ";
//
//        String trimmedUpperCaseWord = word.trim().toUpperCase();
//
//        System.out.println(trimmedUpperCaseWord);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide the following information: ");

        System.out.print("First Name: ");
        String fName = scanner.nextLine().trim() + " ";

        System.out.print("Middle Name: ");
        String mName = scanner.nextLine().trim();
        String displayedMName = "";
        if(!mName.equals("")){
//            displayedMName = " " + String.valueOf(mName.charAt(0)) + ". ";
            displayedMName = mName.substring(0, 1) + ". ";
        }

        System.out.print("Last Name: ");
        String lName = scanner.nextLine().trim();

        System.out.print("Suffix: ");
        String suffix = scanner.nextLine().trim();
        String displayedSuffix = "";
        if(!suffix.equals("")) {
            displayedSuffix = ", " + suffix;
        }

        System.out.printf("Full name: %s%s%s%s", fName, displayedMName, lName, displayedSuffix);
    }
}

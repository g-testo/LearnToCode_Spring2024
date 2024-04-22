package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Ezra", "Elisha", "Ian", "Siddalee", "Pursalane", "Zephaniah"};
        System.out.print("Pick a kid (select #1 - #6): ");
        int index = scanner.nextInt();
        index--;

        try {
            System.out.println(names[index]);
        } catch(Exception e){
            System.out.println("That name doesn't exist. Please run the program again...");
            e.printStackTrace();
        }

        System.out.println("Rest of the program");
    }
}
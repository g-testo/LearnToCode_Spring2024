package com.ps;

import java.sql.*;
import java.util.Scanner;

public class UserInterface {
    public static void init(){

    }
    public static void display(){
        init();
        showMainMenu();
    }

    public static void showMainMenu(){

        int command;

        do{

            System.out.println("What would you like to do?");
            System.out.println("1) Show All Products");
            System.out.println("2) Show All Categories");
            System.out.println("3) Show All Orders");
            System.out.println("0) Exit");

            Scanner scanner = new Scanner(System.in);

            command = scanner.nextInt();

            switch(command){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command");
            }
        } while(command != 0);

    }
}

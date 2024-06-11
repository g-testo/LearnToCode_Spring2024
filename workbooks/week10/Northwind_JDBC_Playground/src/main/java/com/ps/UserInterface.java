package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static NorthwindDataManager dataManager;
    public static void init(String[] args){
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);

        dataManager = new NorthwindDataManager(basicDataSource);
    }
    public static void display(String[] args){
        init(args);
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
                    List products = dataManager.getAllProducts();
                    System.out.println(products);
                    break;
                case 2:
                    // DataManager get all categories
                    break;
                case 3:
                    // DataManager get all orders
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

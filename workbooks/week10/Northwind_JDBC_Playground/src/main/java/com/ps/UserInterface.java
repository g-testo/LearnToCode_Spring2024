package com.ps;

import java.sql.*;
import java.util.Scanner;

public class UserInterface {
    private static String[] arguments;
    public static void init(){

    }
    public static void display(String[] args){
        arguments = args;
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
                    displayQueryResult("SELECT ProductName FROM products");
                    break;
                case 2:
                    displayQueryResult( "SELECT CategoryName FROM categories");
                    break;
                case 3:
                    displayQueryResult( "SELECT ShipName FROM orders");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command");
            }
        } while(command != 0);

    }

    public static void displayQueryResult(String query){
        if(arguments.length != 2){
            System.out.println("Please set a username/password in config...");
            System.exit(1);
        }

        String username = arguments[0];
        String password = arguments[1];
        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                        username,
                        password
                );
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            Class.forName("com.mysql.cj.jdbc.Driver");

            while(resultSet.next()){
                System.out.printf("%s\n", resultSet.getString(1));
            }

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}

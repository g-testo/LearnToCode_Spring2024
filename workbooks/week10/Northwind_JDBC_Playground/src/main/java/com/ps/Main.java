package com.ps;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Please set a username/password in config...");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                    username,
                    password
                );
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT ProductName FROM products ORDER BY ProductName"
                );
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Product Name");
            System.out.println("-------------");
            while(resultSet.next()){
                System.out.printf("%s\n", resultSet.getString(1));
            }

        } catch (ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }


    }
}
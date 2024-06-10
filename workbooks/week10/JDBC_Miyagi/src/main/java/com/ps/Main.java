package com.ps;

import java.sql.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(Arrays.toString(args));
        if(args.length != 2){
            System.out.println("Please set username/password in config as args...");
            System.exit(1);
        }

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sakila",
                args[0],
                args[1]
        );

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM film ORDER BY title, rating"
        );

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.printf("Title: %s, \nRelease Year: %s, \nRating: %s \n\n",
                    resultSet.getString("title"),
                    resultSet.getString("release_year"),
                    resultSet.getString("rating")
            );
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
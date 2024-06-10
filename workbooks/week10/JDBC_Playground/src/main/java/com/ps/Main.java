package com.ps;
// load the MySQL Driver
//Class.forName("com.mysql.cj.jdbc.Driver");

import java.sql.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1. open a connection to the database
        // use the database URL to point to the correct database
        Connection connection;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sakila",
                    args[0],
                    args[1]);
            // create statementÒ
            // the statement is tied to the open connection
            int userInput = 103;
            String query = "SELECT * FROM city WHERE country_id = 103";

            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, userInput);
            // define your query

            // 2. Execute your query
            ResultSet results = statement.executeQuery(query);
            // process the results
            while (results.next()) {
                String city = results.getString("city");
                System.out.println(city);
            }
            // 3. Close the connection
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
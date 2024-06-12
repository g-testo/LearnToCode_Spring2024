package com.ps;

import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserInterface {
    private static UserDAO userDAO;

    public static void init(String[] args){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/ticket_playground_db");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);
        userDAO = new UserDAO(basicDataSource);
    }

    public static void display(String[] args){
        init(args);

        List<User> users = userDAO.getAllUsers();
        System.out.println(users);
    }
}

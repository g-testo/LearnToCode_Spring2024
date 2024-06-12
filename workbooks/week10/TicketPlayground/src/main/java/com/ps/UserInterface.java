package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInterface {

    public static void init(String[] args){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/ticket_playground_db");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);


    }

    public static void display(String[] args){
        init(args);

    }
}

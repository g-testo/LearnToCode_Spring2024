package com.ps;

import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketPlaygroundDataManager {
    private BasicDataSource dataSource;

    public TicketPlaygroundDataManager(BasicDataSource basicDataSource){
        this.dataSource = basicDataSource;
    }

    public List<User> getAllUsers(){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while(resultSet.next()){
                System.out.println(resultSet.getString("first_name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

package com.ps;

import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private BasicDataSource dataSource;

    public UserDAO(BasicDataSource basicDataSource){
        this.dataSource = basicDataSource;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                User user = new User(id, firstName, lastName);
                users.add(user);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } finally {
            return users;
        }
    }
}

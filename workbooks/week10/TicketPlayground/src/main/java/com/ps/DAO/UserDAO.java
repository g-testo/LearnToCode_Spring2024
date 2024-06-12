package com.ps.DAO;

import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public User getOneUser(int id){
        User user = null;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM user WHERE id = ?"
                );
        ){
            preparedStatement.setInt(1, id);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ){
                while(resultSet.next()){
                    int userId = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    user = new User(userId, firstName, lastName);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public int createUser(String firstName, String lastName){
        int generatedId = -1;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO user(first_name, last_name) VALUES (?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );
        ){
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();

            try(ResultSet keys = preparedStatement.getGeneratedKeys()){
                while(keys.next()){
                    generatedId = keys.getInt(1);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return generatedId;
    }

    public void updateUser(int id, String firstName, String lastName){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE user SET first_name = ?, last_name = ? WHERE id = ?"
                );
        ){
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteUser(int id){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM user WHERE id = ?"
                );
        ){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

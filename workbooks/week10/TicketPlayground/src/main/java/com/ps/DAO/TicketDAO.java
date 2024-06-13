package com.ps.DAO;

import com.ps.models.Ticket;
import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketDAO {
    private BasicDataSource dataSource;

    public TicketDAO(BasicDataSource basicDataSource){
        this.dataSource = basicDataSource;
    }

    public List<Ticket> getAllTickets(){
        List<Ticket> tickets = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ticket");
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String eventName = resultSet.getString("event_name");
                float price = resultSet.getFloat("price");
                String type = resultSet.getString("type");

                Ticket ticket = new Ticket(id, eventName, price, type);
                tickets.add(ticket);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } finally {
            return tickets;
        }
    }

    public List<Ticket> filterTicketsByNameAndPrice(String name, float price){
        List<Ticket> tickets = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                CallableStatement callableStatement = connection.prepareCall("{CALL `ticket_playground_db`.`FilterNameAndPrice`(?, ?)}");
        ){
            callableStatement.setString(1, name);
            callableStatement.setFloat(2, price);

            try(
                    ResultSet resultSet = callableStatement.executeQuery()
            ){
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String eventName = resultSet.getString("event_name");
                    float priceField = resultSet.getFloat("price");
                    String type = resultSet.getString("type");

                    Ticket ticket = new Ticket(id, eventName, priceField, type);
                    tickets.add(ticket);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } finally {
            return tickets;
        }
    }
}

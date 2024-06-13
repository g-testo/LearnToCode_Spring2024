package com.ps.DAO;

import com.ps.models.Ticket;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                Ticket ticket = generateTicketFromRS(resultSet);
                tickets.add(ticket);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } finally {
            return tickets;
        }
    }

    // getOneTicket

    public Ticket getOneTicket(int id){
        Ticket ticket = null;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM ticket WHERE id = ?"
                );
        ) {
            preparedStatement.setInt(1, id);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()){
                    ticket = generateTicketFromRS(resultSet);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ticket;
    }

    // createTicket

    public int createTicket(Ticket ticket){
        int generatedId = -1;

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO ticket(event_name, price, type) VALUES(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS
                );
        ){
            preparedStatement.setString(1, ticket.getEventName());
            preparedStatement.setFloat(2, ticket.getPrice());
            preparedStatement.setString(3, ticket.getType());
            preparedStatement.executeUpdate();

            try(
                    ResultSet keys = preparedStatement.getGeneratedKeys();
            ){
                while (keys.next()){
                    generatedId = keys.getInt(1);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return generatedId;
    }
    // updateTicket

    public void updateTicket(int id, Ticket ticket){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE ticket SET event_name=?, price=?, type=? WHERE id=?"
                );
        ){
            preparedStatement.setString(1, ticket.getEventName());
            preparedStatement.setFloat(2, ticket.getPrice());
            preparedStatement.setString(3, ticket.getType());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        }catch (SQLException sql){
            sql.printStackTrace();
        }
    }

    // deleteTicket
    public void deleteTicket(int id){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM ticket WHERE id=?"
                );
        ){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sql){
            sql.printStackTrace();
        }
    }


    public Ticket generateTicketFromRS(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String eventName = resultSet.getString("event_name");
        float price = resultSet.getFloat("price");
        String type = resultSet.getString("type");

        return new Ticket(id, eventName, price, type);
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

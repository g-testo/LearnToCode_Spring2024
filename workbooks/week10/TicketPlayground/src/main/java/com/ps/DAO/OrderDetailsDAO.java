package com.ps.DAO;

import com.ps.DAO.interfaces.OrderDetailsInt;
import com.ps.models.OrderDetails;
import com.ps.models.Ticket;
import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAO implements OrderDetailsInt {
    private BasicDataSource dataSource;

    public OrderDetailsDAO(BasicDataSource basicDataSource) {
        this.dataSource = basicDataSource;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        List<OrderDetails> ordersDetails = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM order_details");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                OrderDetails orderDetails = generateOrderDetailsFromRS(resultSet);
                ordersDetails.add(orderDetails);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return ordersDetails;
        }
    }


    @Override
    public OrderDetails getOneOrderDetails(int id) {
        OrderDetails orderDetails = null;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM order_details WHERE id = ?"
                );
        ) {
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    orderDetails = generateOrderDetailsFromRS(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public int createOrderDetails(OrderDetails orderDetails) {
        int generatedId = -1;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO order_details(user_id, ticket_id, quantity, is_redeemed) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );
        ) {
            preparedStatement.setInt(1, orderDetails.getUserId());
            preparedStatement.setInt(2, orderDetails.getTicketId());
            preparedStatement.setInt(3, orderDetails.getQuantity());
            preparedStatement.setBoolean(4, orderDetails.isRedeemed());
            preparedStatement.executeUpdate();

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()) {
                    generatedId = keys.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    @Override
    public void updateOrderDetails(int id, OrderDetails orderDetails) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE order_details SET user_id = ?, ticket_id = ?, quantity = ?, is_redeemed = ? WHERE id = ?"
                );
        ) {
            preparedStatement.setInt(1, orderDetails.getUserId());
            preparedStatement.setInt(2, orderDetails.getTicketId());
            preparedStatement.setInt(3, orderDetails.getQuantity());
            preparedStatement.setBoolean(4, orderDetails.isRedeemed());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderDetails(int id) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM order_details WHERE id = ?"
                );
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getOrdersDetailsJoinTicket(int id) {
        List<String> ordersDetailsStr = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT t.event_name, o.quantity, t.price, o.is_redeemed " +
                                "FROM order_details AS o " +
                                "JOIN ticket AS t ON t.id = o.ticket_id " +
                                "WHERE o.user_id = ?;"
                );
        ) {
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while(resultSet.next()){
                    String eventName = resultSet.getString("event_name");
                    int quantity = resultSet.getInt("quantity");
                    float price = resultSet.getInt("price");
                    boolean isRedeemed = resultSet.getBoolean("is_redeemed");
                    ordersDetailsStr.add(String.format("Event Name: %s, Quantity: %d, Price: %f, Redeemed? %b",
                            eventName,
                            quantity,
                            price,
                            isRedeemed
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return ordersDetailsStr;
        }
    }

    public OrderDetails generateOrderDetailsFromRS(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int userId = resultSet.getInt("user_id");
        int ticketId = resultSet.getInt("ticket_id");

        int quantity = resultSet.getInt("quantity");
        boolean isRedeemed = resultSet.getBoolean("isRedeemed");

        return new OrderDetails(
                id,
                userId,
                ticketId,
                quantity,
                isRedeemed
        );
    }
}

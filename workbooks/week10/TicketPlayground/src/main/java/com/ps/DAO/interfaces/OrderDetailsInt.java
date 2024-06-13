package com.ps.DAO.interfaces;

import com.ps.models.OrderDetails;

import java.util.List;

public interface OrderDetailsInt {
    List<OrderDetails> getAllOrderDetails();
    OrderDetails getOneOrderDetails(int id);
    int createOrderDetails(OrderDetails orderDetails);
    void updateOrderDetails(int id, OrderDetails orderDetails);
    void deleteOrderDetails(int id);
}

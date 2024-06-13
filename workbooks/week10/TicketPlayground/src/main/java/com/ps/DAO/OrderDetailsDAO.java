package com.ps.DAO;

import com.ps.DAO.interfaces.OrderDetailsInt;
import com.ps.models.OrderDetails;

import java.util.List;

public class OrderDetailsDAO implements OrderDetailsInt {

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return null;
    }

    @Override
    public OrderDetails getOneOrderDetails(int id) {
        return null;
    }

    @Override
    public int createOrderDetails(OrderDetails orderDetails) {
        return 0;
    }

    @Override
    public void updateOrderDetails(int id, OrderDetails orderDetails) {

    }

    @Override
    public void deleteOrderDetails(int id) {

    }
}

package com.ps.models;

public class OrderDetails {
    private int id;
    private int userId;
    private int ticketId;
    private int quantity;
    private boolean isRedeemed;

    public OrderDetails(int id, int userId, int ticketId, int quantity, boolean isRedeemed) {
        this.id = id;
        this.userId = userId;
        this.ticketId = ticketId;
        this.quantity = quantity;
        this.isRedeemed = isRedeemed;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isRedeemed() {
        return isRedeemed;
    }

    public void setRedeemed(boolean redeemed) {
        isRedeemed = redeemed;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticketId=" + ticketId +
                ", quantity=" + quantity +
                ", isRedeemed=" + isRedeemed +
                '}';
    }
}

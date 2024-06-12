package com.ps.models;

public class Ticket {
    private int id;
    private String eventName;
    private float price;
    private String type;

    public Ticket(int id, String eventName, float price, String type) {
        this.id = id;
        this.eventName = eventName;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}

package com.ps;

public class Room {
    private int numberOfBeds;
    private float price;
    private boolean isOccupied;
    private boolean isDirty;

    public void checkIn(){
        this.isOccupied = true;
        this.isDirty = true;
    }

    public void checkOut(){
        this.isOccupied = false;
    }
    public void cleanRoom(){
        this.isDirty = false;
    }

    public Room(int numberOfBeds, float price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public boolean isAvailable(){
        return !this.isOccupied && !this.isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public float getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }
}

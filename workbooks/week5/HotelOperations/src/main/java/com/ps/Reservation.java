package com.ps;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public float getPrice(){
        if(this.roomType.equalsIgnoreCase("king")){
            return 139.00f;
        } else {
            return 124.00f;
        }
    }

    public float getReservationTotal(){
        float ratePercent = 1;
        if(isWeekend){
            ratePercent = 1.1f;
        }
        return this.getPrice() * ratePercent;
    }


    //        getPrice()
    //        getReservationTotal()

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean weekend) {
        isWeekend = weekend;
    }

}

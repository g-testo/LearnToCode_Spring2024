package com.ps;

public class Plant {
    private int id;
    private String type;
    private String status;
    private float listPrice;

    public Plant(int id, String type, String status, float listPrice) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.listPrice = listPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }
}

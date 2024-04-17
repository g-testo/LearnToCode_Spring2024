package com.ps;

public class Car {
    private String make;
    private String model;
    private float price;
    private int numOfSales;
    private boolean isNew;

    public Car(String make, String model, float price, int numOfSales, boolean isNew) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.numOfSales = numOfSales;
        this.isNew = isNew;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public void setNumOfSales(int numOfSales) {
        this.numOfSales = numOfSales;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
}



//    // Constructor method signs
//    // Capitalized
//    // It has the same name of the class
//    // There is no return type
//    // This will run once when you instantiate(new) the class
//    public Car(String make, String model){
//        this.make = make;
//        this.model = model;
//    }
//
//    // Getters and setters
//
//    // Follows the naming convention get____(Name of the property)
//    // Empty parameters
//    // Return type of the that property
//    // Return this.___(Name of the property)
//    public String getMake(){
//        return this.make;
//    }
//    // Follows the naming convention set____(Name of the property)
//    // Must receive new value for property matching the type
//    // Return nothing
//    public void setMake(String make){
//        this.make = make;
//    }
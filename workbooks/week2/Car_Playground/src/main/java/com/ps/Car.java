package com.ps;

public class Car {
    private String make;
    private String model;
    private int timesHonked;
    private int odometer;
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.timesHonked = 0;
        this.odometer = 0;
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

    public void drive(){
        this.odometer += 5;
    }
    public void drive(int millage){
        this.odometer += millage;
    }
    public void drive(int speedMph, int hoursDriven){
        this.odometer = speedMph * hoursDriven;
    }

    public void honk(){
        switch(this.timesHonked){
            case 0:
                System.out.println("HOOOOOOOONNNNKKKKK!!!!!!");
                break;
            case 1:
                System.out.println("Hooooooonnnnkkkk!!!");
                break;
            case 2:
                System.out.println("hoonnkkk");
                break;
            default:
                System.out.println("...");
        }
        this.timesHonked++;
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
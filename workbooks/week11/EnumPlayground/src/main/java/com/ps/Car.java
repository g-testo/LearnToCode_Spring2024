package com.ps;

public class Car {
    private String make;
    private String model;
    private Colors color;

    public Car() {}

    public Car(String make, String model, Colors color) {
        this.make = make;
        this.model = model;
        this.color = color;
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

    public Colors getColor() {

        switch(this.color){
            case BLUE -> System.out.println("Blue");
            case BLACK -> System.out.println("Black");
            case WHITE -> System.out.println("White");
            default -> System.out.println("NA");
        }
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
}

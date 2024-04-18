package com.ps;

public class Main {
    public static void main(String[] args){
        Car car1 = new Car("Honda", "Accord");
        car1.honk();
        car1.honk();
        car1.honk();
        car1.honk();
        car1.honk();
        car1.honk();
        car1.honk();

        Car car2 = new Car();
        car2.setMake("Honda");

    }
}

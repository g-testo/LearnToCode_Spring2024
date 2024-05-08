package com.ps;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @org.junit.jupiter.api.Test
    void getMake() {
        // AAA
        // Arrange
        Car car = new Car("Lamborghini", "Diablo");
        String expectedMake = "Lamborghinis";

        // Act
        String actualMake = car.getMake();

        // Assert
        assertEquals(expectedMake, actualMake);
    }

    @org.junit.jupiter.api.Test
    void setMake() {
    }

    @org.junit.jupiter.api.Test
    void getModel() {
    }

    @org.junit.jupiter.api.Test
    void setModel() {
    }
}
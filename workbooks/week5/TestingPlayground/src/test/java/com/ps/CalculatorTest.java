package com.ps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void addTwoNumbers_shouldReturn_summedValue(){
        // arrange
        int number1 = 1;
        int number2 = 5;
        int expectedResult = 6;

        // act
        int actualResult = Calculator.add(number1, number2);


        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void subTwoNumbers_shouldReturn_differenceOfValue(){
        int number1 = 1;
        int number2 = 5;
        int expectedResult = -4;

        int actualResult = Calculator.subtract(number1, number2);

        assertEquals(expectedResult, actualResult);
    }


}
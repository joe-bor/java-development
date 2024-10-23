package com.pluralsight.week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
    @Test
    void addTwoNumbers_positiveNrs() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        double result = simpleCalculator.addTwoNumbers(2, 4);
        assertEquals(6, result);
    }

    @Test
    void addTwoNumbers_negativeNrs() {
        // arrange
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // act
        double result = simpleCalculator.addTwoNumbers(-2, -4);
        // assert
        assertEquals(-6, result);
    }

    @Test
    void divideTwo_positiveNums_shouldBePositive(){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        double result = simpleCalculator.divideTwoNumbers(10.0,5.0);
        assertEquals(2, result);
    }

    @Test
    void divideTwo_positiveNums_shouldBeNegative(){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        double result = simpleCalculator.divideTwoNumbers(10.0,-5.0);
        assertEquals(-2, result);
    }

    @Test
    void divideTwo_secondNumIsZero_shouldBeZero(){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        double result = simpleCalculator.divideTwoNumbers(10.0,0);
        assertEquals(0, result);
    }
}
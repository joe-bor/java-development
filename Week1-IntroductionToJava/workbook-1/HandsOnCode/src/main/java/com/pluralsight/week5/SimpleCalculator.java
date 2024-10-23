package com.pluralsight.week5;

public class SimpleCalculator {
    public double addTwoNumbers(double x, double y) {
        return x + y;
    }

    public double divideTwoNumbers(double x, double y) {
        if (y == 0){
            return 0;
        }
        return x / y;
    }
}
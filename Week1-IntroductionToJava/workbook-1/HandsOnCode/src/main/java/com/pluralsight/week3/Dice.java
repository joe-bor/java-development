package com.pluralsight.week3;

public class Dice {

    public int roll(int minValue, int maxValue){
        return (int)(Math.random() * maxValue) + minValue;
    }
}

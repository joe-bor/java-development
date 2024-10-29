package com.pluralsight.week6.Polymorphism;

public class Shape {
    private String color;


    public void calculateArea(){
        System.out.println("Calculate Area");
    }

    public void calculateCircumference(){
        System.out.println("Calculate Circumference");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

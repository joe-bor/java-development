package com.pluralsight.week6.Polymorphism;

public class Circle  extends  Shape{

    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        System.out.println(Math.PI * Math.pow(this.getRadius(), 2));
    }

    @Override
    public void calculateCircumference() {
        System.out.println(2 * Math.PI * this.getRadius());
    }
}

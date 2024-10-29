package com.pluralsight.week6.Polymorphism;

public class Square  extends  Shape{
    private int sideSize;

    public int getSideSize() {
        return sideSize;
    }

    public void setSideSize(int sideSize) {
        this.sideSize = sideSize;
    }

    @Override
    public void calculateArea() {
        System.out.println(this.sideSize * this.sideSize);
    }
}

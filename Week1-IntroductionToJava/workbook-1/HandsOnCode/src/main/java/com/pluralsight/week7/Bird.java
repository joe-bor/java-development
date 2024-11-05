package com.pluralsight.week7;

public abstract class Bird extends Animal implements Flyable {
    @Override
    public void fly() {
        System.out.println(this.getClass() + "flies");
    }
}
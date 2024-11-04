package com.pluralsight.week7;

public class Assistant extends PartTimeEmployee implements Promotable{

    @Override
    public void promote() {
        System.out.println("promote");
    }

    @Override
    public double getSalary() {
        return 0;
    }
}

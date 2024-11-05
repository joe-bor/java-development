package com.pluralsight.week7.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Tester<T, U> {
    private T typeOne;
    private U typeTwo;

    public Tester(T typeOne, U typeTwo) {
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }

    public T getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(T typeOne) {
        this.typeOne = typeOne;
    }

    public U getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(U typeTwo) {
        this.typeTwo = typeTwo;
    }

    public void printType1() {
        System.out.println("typeOne = " + typeOne);
    }

    public void printType2() {
        System.out.println("typeTwo = " + typeTwo);
    }

    public <T extends Number> double genericMethod(ArrayList<T> numbers) {
        double total = 0;
        for (T num : numbers) {
            total += num.doubleValue();
        }
        return total / numbers.size();
    }

    public <T extends Number> double genericMethod2(T[] numbers) {
        double total = 0;
        for (T num : numbers){
            total += num.doubleValue();
        }
        return total/numbers.length;
    }
}

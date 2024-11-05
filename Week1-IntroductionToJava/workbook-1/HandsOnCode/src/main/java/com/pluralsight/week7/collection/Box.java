package com.pluralsight.week7.collection;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    public static void main(String[] args) {
        Box<Laptop> box = new Box();
        box.contents.add(new Laptop());
        box.printContents();
    }

    private List<T> contents = new ArrayList<>();



    public void printContents() {
        for (T t : this.contents) {
            System.out.println(t);
        }
    }
}

package com.pluralsight.week7.collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {

    public static void main(String[] args) {
        FixedList<Integer> numbers = new FixedList<>(3);
        numbers.add(10);
        numbers.add(3);
        numbers.add(92);
        numbers.add(43); // this line should fail
        System.out.println(numbers.getItems().size());
        FixedList<LocalDate> dates = new FixedList<>(2);
        dates.add(LocalDate.now());
        dates.add(LocalDate.now());
//        dates.add(15); // this line should fail
    }

    private List<T> items = new ArrayList<>();
    private int maxSize;

    public FixedList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item) {
        if (this.items.size() < maxSize) {
            this.items.add(item);
        } else {
            System.out.println("Reached max size");
        }
    }

    public List<T> getItems() {
        return this.items;
    }
}

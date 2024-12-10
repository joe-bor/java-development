package com.pluralsight.beyond.concurrency.exercises;

public class CleaningActivity implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().threadId());
        System.out.println("Cleaning activity happening");
    }
}

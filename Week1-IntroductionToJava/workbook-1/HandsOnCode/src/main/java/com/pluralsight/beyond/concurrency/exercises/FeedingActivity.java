package com.pluralsight.beyond.concurrency.exercises;

public class FeedingActivity extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().threadId());
            System.out.println("Feeding activity happening...");
            Thread.sleep(2000);
            System.out.println("done feeding");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

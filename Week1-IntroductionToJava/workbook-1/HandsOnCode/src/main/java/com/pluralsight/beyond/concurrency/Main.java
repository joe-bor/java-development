package com.pluralsight.beyond.concurrency;

public class Main {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("t1 started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished!");
        });

        t1.start();

        try {
            System.out.println("Main thread will be waiting for other t1 to be done...");
            t1.join();
            System.out.println("Main thread continues...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


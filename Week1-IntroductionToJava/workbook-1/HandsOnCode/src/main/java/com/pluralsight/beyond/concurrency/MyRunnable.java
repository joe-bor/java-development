package com.pluralsight.beyond.concurrency;

public class MyRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println("My thread is running on " );
    }
}

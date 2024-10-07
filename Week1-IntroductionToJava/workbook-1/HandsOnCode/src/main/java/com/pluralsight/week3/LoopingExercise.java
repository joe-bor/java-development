package com.pluralsight.week3;

public class LoopingExercise {
    public static void main(String[] args) throws InterruptedException {
        WhileLoop.main(new String[0]);
        DoWhileLoop.main(new String[0]);
        ForLoop.main(new String[0]);
    }
}

class WhileLoop {
    public static void main(String[] args) {
        int counter = 0;
        while (counter < 5) {
            System.out.println("I love Java");
            counter++;
        }
    }
}

class DoWhileLoop {
    public static void main(String[] args) {
        int counter = 0;
        do {
            System.out.println("I love Java");
            counter++;
        } while (counter < 5);
    }
}

class ForLoop {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i > 0; i--) {
            System.out.println("Countdown: " + i);
            Thread.sleep(1000);
        }
        System.out.println("Launch!");
    }
}
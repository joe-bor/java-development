package com.pluralsight;

public class LoopsExercise {
    public static void main(String[] args) {
        whileLoop();
        forLoop();
        forEachLoop();
        lilMonkeys();
    }

    static void whileLoop(){
        int counter = 0;
        while ( Math.random() < 0.05){
            counter++;
            System.out.println("Hi " + counter);
        }
    }

    static void forLoop(){
        for (int i = 0; i < 20; i = i + 2) {System.out.println(i);}
    }

    static void forEachLoop(){
        String[] faveArray = {"Apple", "Orange", "Watermelon"};
        for (String item: faveArray) System.out.println("I love " + item);
    }

    static void lilMonkeys(){
        for (int i = 10; i > 0 ; i--) System.out.println((i == 1 ? i + " little monkey " : i + " little monkeys ") + "jumping on the bad, one fell off and bumped his head, mommy called the doctor and the doctor said no more monkeys jumping on the bed");
    }
}

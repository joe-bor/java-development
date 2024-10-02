package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = generateRandomNumberBetweenZeroAnd(10);
        int userGuess;
        boolean isGuessing;
        int guessCounter = 0;
        ArrayList<Integer> guessesNum = new ArrayList();

        do {
            System.out.println("What is your guess?");
            userGuess = scanner.nextInt();
            guessesNum.add(userGuess);
            isGuessing = guessNum(randomNumber, userGuess);
            guessCounter++;
        } while (isGuessing);

        System.out.println("It took you " + guessCounter + " guesses to get the answer");
        System.out.println("\n These were your guesses:");
        for (int num: guessesNum){
            System.out.println(num);
        }
    }

    static int generateRandomNumberBetweenZeroAnd(int maxNum){
        System.out.println("Generating a random number between zero and " + maxNum + "(exclusive)");
        return (int) (Math.random() * maxNum);
    }

    static boolean guessNum(int randomNum, int userGuess){
        System.out.println("You guessed: " + userGuess);
        if (randomNum > userGuess){
            System.out.println("The number we are looking for is HIGHER");
        } else if (randomNum < userGuess){
            System.out.println("The number we are looking for is LOWER");
        } else {
            System.out.println("You guessed it! " + userGuess + " is the correct answer");
            return false;
        }
        return true;
    }
}

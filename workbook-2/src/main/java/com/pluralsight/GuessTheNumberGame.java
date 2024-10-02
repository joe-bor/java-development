package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumberGame {

    static Scanner scanner = new Scanner(System.in);
    static int maxNum = Integer.MIN_VALUE;
    static int userGuess = 0;
    static boolean isGuessing = true;
    static int guessCounter = 0;
    static ArrayList<Integer> guessesContainer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try {
            setMaxNum();
            int randomNumber = generateRandomNumberBetweenZeroAnd();

            do {
                System.out.println("What is your guess?");
                userGuess = scanner.nextInt();
                guessesContainer.add(userGuess);
                isGuessing = guessNum(randomNumber, userGuess);
                guessCounter++;
            } while (isGuessing);

            System.out.println("It took you " + guessCounter + " guesses to get the answer");

            System.out.println("\n These were your guesses:");
            for (int num: guessesContainer){
                System.out.println(num);
            }

            recordToFile(userGuess);
        } catch (InputMismatchException e) {
            System.err.println(e);
            System.err.println("Input must be parseable to integer");
        } finally {
            scanner.close();
        }
    }

    static void setMaxNum(){
        System.out.println("Pick a number between 0 - 100");
         maxNum = scanner.nextInt();
    }

    static int generateRandomNumberBetweenZeroAnd(){
        System.out.println("Generating a random number between zero and " + maxNum + "(exclusive)");
        return (int) (Math.random() * maxNum);
    }

    static boolean guessNum(int randomNum, int userGuess){
        if (userGuess > maxNum || userGuess < 0){
            System.out.println("The number we are looking for is between 0 (inclusive) and " + (maxNum - 1));
        }

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

    static void recordToFile(Integer guessCounter) throws IOException {
        File myFile = new File("Hello.txt");
        myFile.createNewFile();

        FileWriter fileWriter = new FileWriter(myFile);
        fileWriter.write(String.format("""
                # of Guesses:
                %s
                """, guessCounter.toString()));

        fileWriter.close();

    }
}

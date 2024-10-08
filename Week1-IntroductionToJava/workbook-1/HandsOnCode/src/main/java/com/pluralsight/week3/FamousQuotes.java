package com.pluralsight.week3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FamousQuotes {

    private static final Scanner scanner = new Scanner(System.in);
    private static String[] famousQuotes = {
            "You must be the change you wish to see in the world. -Mahatma Gandhi",
            "Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa",
            "The only thing we have to fear is fear itself. -Franklin D. Roosevelt",
            "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that. -Martin Luther King Jr.",
            "Do one thing every day that scares you. -Eleanor Roosevelt",
            "Well done is better than well said. -Benjamin Franklin",
            "The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart. -Helen Keller",
            "It is during our darkest moments that we must focus to see the light. -Aristotle",
            "Do not go where the path may lead, go instead where there is no path and leave a trail. -Ralph Waldo Emerson",
            "Be yourself; everyone else is already taken. -Oscar Wilde"
    };
    static boolean keepGoing = true;

    public static void main(String[] args) {

        do {
            provideOptions();
            keepGoing();
        } while (keepGoing);

        scanner.close();
    }

    static int promptUser() {
        System.out.println("Pick a number between 1 and 10");
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    static void getQuoteAtIndex(int index) {
        try {
            System.out.println(famousQuotes[index - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e);
            System.out.println("Index out of bounds");
        }
    }

    static void getRandomQuote() {
        int randomIndex = (int) Math.floor(Math.random() * famousQuotes.length);
        System.out.println(famousQuotes[randomIndex]);
    }

    static void keepGoing() {
        System.out.println("-----\nWould you like to see another quote? (y/n)");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("n")) {
            quitProgram();
        }
    }

    static void provideOptions() {
        System.out.println("""
                -----
                1 - Pick a quote
                2 - Get a random quote
                """);
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> getQuoteAtIndex(promptUser());
                case 2 -> getRandomQuote();
//            case 3 -> quitProgram();
                default -> {
                    System.out.println("Pick [1] or [2]");
                    provideOptions();
                }

            }
        } catch (InputMismatchException e) {
            System.err.println(e);
        }
    }

    static void quitProgram() {
        System.out.println("Quitting...");
        keepGoing = false;
    }
}

package com.pluralsight.week2.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    static Book[] books = new Book[20];

    public static void seed() {
        books[0] = new Book(1, "isbn-1111", "Harry Potter", false, "");
        books[1] = new Book(2, "isbn-2222", "Winnie the Pooh", false, "");
        System.out.println(books[0]);
    }

    public static void main(String[] args) {
        seed();
        homeScreen();
    }

    public static void homeScreen() {
        System.out.println("""
                ----- Home Screen -----
                1 - Show Available Books
                2 - Show Checked Out Books
                3 - Exit
                """);
        executeUserInput();
    }

    public static void executeUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1" -> {
                showAvailableBooks();
                promptToCheckOut();
            }
            case "2" -> showCheckedOutBooks();
            case "3" -> quitApplication();
        }
        scanner.close();
    }

    private static void promptToCheckOut() {
        System.out.println("""
                What would you like to do?
                1 -> Check out a book
                2 -> Go back to home screen
                """);
    }

    private static void quitApplication() {
    }

    private static void showCheckedOutBooks() {

    }

    private static void showAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book != null) {
                if (!book.isCheckedOut()) {
                    availableBooks.add(book);
                }
            }
        }
        System.out.println("Here are the available books:");
        for (Book book : availableBooks) {
            if (book != null) {
                System.out.println("\t- Id: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle());
            }
        }
    }
}

package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {

    static Scanner scanner = new Scanner(System.in);
    static String userName;
    static LocalDate eventDate;
    static int numOfTickets;

    public static void main(String[] args) {
        getNameOfUser();
        getDateOfEvent();
        getNumOfTickets();
        printReservation();
    }

    static void getNameOfUser(){
        System.out.print("Please enter your name: ");
        userName = scanner.nextLine().trim();
    }

    static void getDateOfEvent(){
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String strDate = scanner.nextLine().trim();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        eventDate =  LocalDate.parse(strDate, dateTimeFormatter);
    }

    static void getNumOfTickets(){
        System.out.print("How many tickets would you like? ");
        numOfTickets = scanner.nextInt();
    }

    static void printReservation(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numOfTickets);
        stringBuilder.append((numOfTickets > 1 ? " tickets " : " ticket "));
        stringBuilder.append("reserved for ");
        stringBuilder.append(eventDate);
        stringBuilder.append(" under ");
        String[] fullNameArray = userName.split(" ");
        stringBuilder.append(fullNameArray[1]);
        stringBuilder.append(", " + fullNameArray[0]);
        System.out.println(stringBuilder);
    }
}

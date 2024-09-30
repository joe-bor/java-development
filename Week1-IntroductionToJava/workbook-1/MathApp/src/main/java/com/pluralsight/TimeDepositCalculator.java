package com.pluralsight;

import java.util.Scanner;

public class TimeDepositCalculator {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("How much to deposit?");
        double deposit = scanner.nextDouble();

        System.out.println("What is the annual interest rate?");
        double interestRate = scanner.nextDouble();
        double rateInDecimal = interestRate / 100.0;

        System.out.println("How many years?");
        int numOfYears = scanner.nextInt();

        double newBalance = deposit * Math.pow((1 + rateInDecimal/365), (365*numOfYears));
        double interestGained = newBalance - deposit;
        System.out.printf("If you deposit $%.2f in a CD that earns %.2f interest and matures in %d years, your CD's ending balance will be $%.2f and you would have earned $%.2f in interest ", deposit, interestRate, numOfYears, newBalance, interestGained);
    }
}

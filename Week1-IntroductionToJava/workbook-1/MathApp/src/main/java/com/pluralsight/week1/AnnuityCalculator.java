package com.pluralsight;

import java.util.Scanner;

public class AnnuityCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("How much do you want as payout? ");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Expected annual interest rate?");
        double rate = scanner.nextDouble();
        double r = rate / 100 / 12;


        System.out.println("How many years do you want to be paid out?");
        int numOfYears = scanner.nextInt();
        int n = numOfYears * 12;

        double pv = monthlyPayout * ((1 - Math.pow((1 + r), -n))/r);

        System.out.printf("To fund an annuity that pays $%.2f monthly for %d years and earns an expected %.2f%% interest, you would need to invest $%.2f today", monthlyPayout, numOfYears, rate, pv);

        scanner.close();
    }
}

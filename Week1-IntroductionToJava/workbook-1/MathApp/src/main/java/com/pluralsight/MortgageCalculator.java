package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("What is the principal amount?");
        double principalAmount = scanner.nextDouble();

        System.out.println("What is the annual interest rate?");
        double interestRate = scanner.nextDouble();
        double monthlyInterest = interestRate / 100.0; // turn to decimal
        monthlyInterest /= 12; // get monthly rate

        System.out.println("What is the loan length (in years)?");
        int loanLength = scanner.nextInt();


        double x = Math.pow((1 + monthlyInterest), loanLength * 12);
        double y = x - 1.0;
        double monthlyPayment = principalAmount * monthlyInterest * (x / y);
        double totalInterest = (monthlyPayment * loanLength * 12) - principalAmount;

        System.out.printf("A $%.2f loan at %.3f%% interest for %d years would have a $%.2f payment with a total interest of $%.2f\n",principalAmount, interestRate, loanLength, monthlyPayment, totalInterest);

        scanner.close();
    }
}

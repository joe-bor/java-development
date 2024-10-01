package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\n------ Financial Calculators ------");
        System.out.println("Which calculator would you like to use?");
        System.out.println("""
                    [1] -> Mortgage Calculator
                    [2] -> Time Deposit Calculator
                    [3] -> Annuity Calculator
                """);
        String userInput = scanner.nextLine();
        switch (userInput){
            case "1" -> MortgageCalculator.main(new String[0]);
            case "2" -> TimeDepositCalculator.main(new String[0]);
            case "3" -> AnnuityCalculator.main(new String[0]);
            default -> System.err.println("Must provide either 1, 2, or 3");


        }
    }
}

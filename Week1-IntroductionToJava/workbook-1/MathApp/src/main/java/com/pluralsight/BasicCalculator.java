package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        float firstFloat = scanner.nextFloat();
        System.out.println("Enter the second number: ");
        float secondFloat = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Possible Calculations:");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        if (secondFloat == 0) {
            System.out.println("** Can't divide with 0 **");
        } else {
            System.out.println("(D)ivide");
        }
        System.out.println();

        System.out.print("Please select an option: ");
        String operator = scanner.nextLine().toUpperCase();
        char symbol;
        double answer;

        switch (operator) {
            case "A":
                symbol = '+';
                answer = firstFloat + secondFloat;
                System.out.println(firstFloat + " " + symbol + " " + secondFloat + " = " + answer );
                break;
            case "S":
                symbol = '-';
                answer = firstFloat - secondFloat;
                System.out.println(firstFloat + " " + symbol + " " + secondFloat + " = " + answer );
                break;
            case "M":
                symbol = '*';
                answer = firstFloat * secondFloat;
                System.out.println(firstFloat + " " + symbol + " " + secondFloat + " = " + answer );
                break;
            case "D":
                // I dont know how to handle errors/exceptions yet lol
                if (secondFloat == 0) {
                    System.out.println("\n Cannot divide with 0");
                    throw new Error("Cannot divide with 0");
                }
                symbol = '/';
                answer = firstFloat / secondFloat;
                System.out.println(firstFloat + " " + symbol + " " + secondFloat + " = " + answer );
                break;
            default:
                System.out.println("Invalid inputs. Please try again");
        }

        scanner.close();
    }
}

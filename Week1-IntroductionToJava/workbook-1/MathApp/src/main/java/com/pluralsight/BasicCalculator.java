package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator {

    public static char symbol;
    public static double answer;
    public static String operator;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Get inputs from user
        float firstFloat= getNumberFromUser();
        float secondFloat = getNumberFromUser();

        // Show available commands
        printCommandsToOperations();

        String operator = getOperationFromUser();
        boolean isSuccessful = doMath(firstFloat, secondFloat, operator);
        if (isSuccessful) printAnswer(firstFloat, secondFloat);

        scanner.close();
    }

    public static float getNumberFromUser(){
        System.out.println("Enter the a number: ");
        while (!scanner.hasNextFloat()){
            System.out.println("Invalid input");
            scanner.next();
        }
        return scanner.nextFloat();
    }

    public static void printCommandsToOperations(){
        System.out.println("""
                Possible Calculations:
                (A)dd
                (S)ubtract
                (M)ultiply
                (D)ivide
                ** Note: You can't divide with 0 **"
                """);
    }

    public static String getOperationFromUser(){
        do {
            System.out.print("Please select an option: ");
            operator = scanner.nextLine().toUpperCase();
        } while (!operator.matches("[ASMD]"));
        return operator;
    }

    public static boolean doMath(float firstFloat, float secondFloat, String operator){
        boolean isSuccessful = true;
        try {
            switch (operator) {
                case "A":
                    symbol = '+';
                    answer = firstFloat + secondFloat;
                    break;
                case "S":
                    symbol = '-';
                    answer = firstFloat - secondFloat;
                    break;
                case "M":
                    symbol = '*';
                    answer = firstFloat * secondFloat;
                    break;
                case "D":
                    if (secondFloat == 0) {
                        isSuccessful = false;
                        System.out.println("\nCannot divide with 0 \nExiting the program.");
                        break;
                    }
                    symbol = '/';
                    answer = firstFloat / secondFloat;
                    break;
                default:
                    System.out.println("Invalid inputs. Please try again");
            }
        } catch (ArithmeticException e) {
            System.err.println("Division by 0 error, perhaps?");
        }
        return isSuccessful;
    }

    public static void printAnswer(float firstFloat, float secondFloat){
        System.out.println(firstFloat + " " + symbol + " " + secondFloat + " = " + answer );
    }
}

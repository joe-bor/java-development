package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {

    static Scanner scanner = new Scanner(System.in);
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {

        System.out.println("Please provide the following information:");
        askUser("Full name: ");
        stringBuilder.append("\n\n");

        stringBuilder.append("Billing Address: \n");
        askUser("Billing Street: ");
        stringBuilder.append("\n");
        askUser("Billing City: ");
        stringBuilder.append(", ");
        askUser("Billing State: ");
        stringBuilder.append(" ");
        askUser("Billing Zip: ");
        stringBuilder.append("\n\n");

        stringBuilder.append("Shipping Address: \n");
        askUser("Shipping Street: ");
        stringBuilder.append("\n");
        askUser("Shipping City: ");
        stringBuilder.append(", ");
        askUser("Shipping State: ");
        stringBuilder.append(" ");
        askUser("Shipping Zip: ");

//        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    static void askUser(String message){
        System.out.print(message);
        stringBuilder.append(scanner.nextLine().trim());
    }
}

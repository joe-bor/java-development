package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Following this format(s):");
        System.out.println("\tfirst last OR first middle last");
        System.out.print("Enter your name: ");

        String fullName = scanner.nextLine().trim();
        String[] nameArr = fullName.split(" ");

        switch (nameArr.length){
            case 2 -> {
                System.out.println("First name: " + nameArr[0].trim());
                System.out.println("Middle name: (none)");
                System.out.println("Last name: " + nameArr[1].trim());
            }
            case 3 -> {
                System.out.println("First name: " + nameArr[0].trim());
                System.out.println("Middle name: " + nameArr[1].trim());
                System.out.println("Last name: " + nameArr[2].trim());
            }
            default -> {
                System.out.println("Invalid input");
                System.out.println("Restarting... \n");
                main(new String[0]);
            }
        }
        scanner.close();
    }
}

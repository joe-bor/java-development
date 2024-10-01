package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getUserInput();
    }

    static void getUserInput(){
        System.out.println("Please enter your name");
        String firstName = getFirstname();
        String middleName = getMiddleName();
        String lastName = getLastName();
        String suffix = getSuffix();

        String fullName = "";
        fullName += (firstName + " " + (middleName.isBlank() ? " ": middleName + " ") + lastName + (suffix.isEmpty() ? "" : ", " + suffix)).trim();
        System.out.println(fullName);
    }

    static String getFirstname(){
        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        if (firstName.isEmpty()){
            System.out.println("First name is required!");
            getFirstname();
        }
        return firstName;
    }

    static String getLastName(){
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        if (lastName.isEmpty()){
            System.out.println("Last name is required!");
            getLastName();
        }
        return lastName;
    }

    static String getMiddleName(){
        System.out.print("Middle name: ");
        return scanner.nextLine();
    }

    static  String getSuffix(){
        System.out.print("Suffix: ");
        return scanner.nextLine();
    }
}

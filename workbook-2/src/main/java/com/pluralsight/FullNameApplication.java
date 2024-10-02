package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getUserInput();
    }

    static void getUserInput(){
        System.out.println("Please enter your name");
        String firstName = getRequiredName("First name: ");
        String middleName = getMiddleName();
        String lastName = getRequiredName("Last name: ");
        String suffix = getSuffix();

        String fullName = "";
        fullName += firstName + " " + middleName + lastName + suffix;
        System.out.println(fullName);
    }

    static String getRequiredName(String message){
        System.out.print(message);
        String requiredName = scanner.nextLine();

        if (requiredName.isBlank()){
            System.out.println("This is required!");
            requiredName = getRequiredName(message);
        }
        return requiredName.trim();
    }

    static String getMiddleName(){
        System.out.print("Middle name: ");
        String middleName = scanner.nextLine().trim();
        return middleName.isBlank() ? "" : middleName + " ";
    }

    static  String getSuffix(){
        System.out.print("Suffix: ");
        String suffix = scanner.nextLine().trim();
        return suffix.isBlank() ? "" : ", " + suffix;
    }
}

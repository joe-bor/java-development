package com.pluralsight.week2;

import java.util.Scanner;

public class CellPhoneService {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CellPhone cellPhone = createPhoneViaPrompt();
        CellPhone cellPhone2 = createPhoneViaPrompt();
        CellPhone cellPhone3 = new CellPhone(123, "serial number", "model", "carrier", "owner");

        display(cellPhone);
        display(cellPhone2);
        display(cellPhone3);

        cellPhone.dial(cellPhone2.getPhoneNumber());
        cellPhone2.dial(cellPhone.getPhoneNumber());
        cellPhone3.dial(cellPhone);
    }

    static String promptUser(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    static void display(CellPhone cellPhone) {
        System.out.println("\n----- Cell Phone Details -----");
        System.out.println("Serial Number: " + cellPhone.getSerialNumber());
        System.out.println("Model: " + cellPhone.getModel());
        System.out.println("Carrier: " + cellPhone.getCarrier());
        System.out.println("Phone number: " + cellPhone.getPhoneNumber());
        System.out.println("Owner: " + cellPhone.getOwner() + "\n");
    }

    static CellPhone createPhoneViaPrompt() {
        CellPhone cellPhone = new CellPhone();
        cellPhone.setSerialNumber((Integer.parseInt(promptUser("\nWhat is the serial number? "))));
        cellPhone.setModel(promptUser("What model is the phone? "));
        cellPhone.setCarrier(promptUser("Who is the carrier? "));
        cellPhone.setPhoneNumber(promptUser("What is the phone number? "));
        cellPhone.setOwner(promptUser("Who is the owner of the phone? "));
        return cellPhone;
    }
}

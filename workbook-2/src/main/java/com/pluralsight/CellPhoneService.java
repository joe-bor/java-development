package com.pluralsight;

import java.util.Scanner;

public class CellPhoneService {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();

        cellPhone.setSerialNumber((Integer.parseInt(promptUser("What is the serial number? "))));
        cellPhone.setModel(promptUser("What model is the phone? "));
        cellPhone.setCarrier(promptUser("Who is the carrier? "));
        cellPhone.setPhoneNumber(promptUser("What is the phone number? "));
        cellPhone.setOwner(promptUser("Who is the owner of the phone? "));

        printPhoneFields(cellPhone);

    }

    static String promptUser(String message){
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    static void printPhoneFields(CellPhone cellPhone){
        System.out.println("Serial Number: " + cellPhone.getSerialNumber());
        System.out.println("Model: " + cellPhone.getModel());
        System.out.println("Carrier: " + cellPhone.getCarrier());
        System.out.println("Phone number: " + cellPhone.getPhoneNumber());
        System.out.println("Owner: " + cellPhone.getOwner());
    }
}

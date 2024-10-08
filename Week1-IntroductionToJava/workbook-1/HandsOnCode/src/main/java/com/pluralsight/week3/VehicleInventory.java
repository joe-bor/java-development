package com.pluralsight.week3;

import java.util.Scanner;

public class VehicleInventory {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Vehicle[] vehicles = new Vehicle[20];

    public static void main(String[] args) {

        int vehicleCounter = vehicles.length;

        var vehicle1 = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        var vehicle2 =new Vehicle(101122,"Toyota Camry","Blue",60000,11000);
        var vehicle3 = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        var vehicle4 = new Vehicle(101124,"Honda Civic","White",70000,7500);
        var vehicle5 = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        var vehicle6 = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);

        vehicles[0] = vehicle1;
        vehicles[1] = vehicle2;
        vehicles[2] = vehicle3;
        vehicles[3] = vehicle4;
        vehicles[4] = vehicle5;
        vehicles[5] = vehicle6;


    }

    static void showChoices(){
        System.out.println("""
                What do you want to do?
                
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                
                Enter your command:
                """);
    }

    static void promptUser(){
        showChoices();
        String choice = scanner.nextLine();

        switch (choice){
            case "1" -> listVehicles();
            case "2" -> System.out.println("Search by make/model");
            case "3" -> System.out.println("Search by price range");
            case "4" -> System.out.println("Search by color");
            case "5" -> System.out.println("Add a vehicle");
            case "6" -> System.out.println("Quit");
        }
    }

    static void listVehicles(){
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
}

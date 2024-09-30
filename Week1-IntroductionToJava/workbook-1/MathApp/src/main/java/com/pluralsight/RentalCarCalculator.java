package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String pickUpDate = determinePickUpDate();

        int numberOfDays = determineNumOfRentalDays();
        scanner.nextLine();

        boolean hasTollTag = isTollTagWanted();
        boolean hasCarGPS  = isCarGPSWanted();
        boolean hasRoadSideAssistance =  isRoadSideAssistanceWanted();

        int userAge = determineUserAge();
        scanner.nextLine();

        float underAgeSurcharge = userAge < 25 ? (29.99f * .3f) : 0f;
        float carRentalPricePerDay = 29.99f + underAgeSurcharge;
        float optionsCost = calculateOptionsCost(hasTollTag, hasCarGPS, hasRoadSideAssistance);
        float totalCost = calculateTotalCost(carRentalPricePerDay, optionsCost, numberOfDays);

        System.out.println("Basic car rental: $" + carRentalPricePerDay);
        System.out.println("Options Cost: $" + optionsCost);
        System.out.println("Under Age Surcharge: $" + underAgeSurcharge);
        System.out.println("------------------------------------------------");
        System.out.printf("Total Cost: $" + totalCost);
    }

    static String determinePickUpDate(){
        System.out.println("When do you plan on picking up?");
        return scanner.nextLine();
    }

    static int determineNumOfRentalDays(){
        System.out.println("For how many days?");
         return scanner.nextInt();
    }

    static boolean isTollTagWanted() {
        System.out.println("Would you like an electronic toll tag for $3.95 per day? (yes/no)");
        String tollTag = scanner.nextLine();

        if (tollTag.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    static boolean isCarGPSWanted(){
        System.out.println("Would you like a GPS for $2.95/day? (yes/no)");
        String carGps = scanner.nextLine();

        if (carGps.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    static boolean isRoadSideAssistanceWanted(){
        System.out.println("Would you like roadside assistance for $3.95/day? (yes/no");
        String roadsideAssistance = scanner.nextLine();

        if (roadsideAssistance.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    static int determineUserAge(){
        System.out.println("How old are you?");
        return scanner.nextInt();
    }

    static float calculateOptionsCost(boolean hasTollTag, boolean hasCarGPS, boolean hasRoadSideAssistance){
        float tollTagExtra = hasTollTag ? 3.95f : 0f;
        float carGPSExtra = hasCarGPS ? 2.95f : 0f;
        float roadSideExtra = hasRoadSideAssistance ? 3.95f : 0f;

        return tollTagExtra + carGPSExtra + roadSideExtra;
    }

    static float calculateTotalCost(float carRentalPricePerDay, float optionsCost, int numberOfDays) {
        return (carRentalPricePerDay + optionsCost) * numberOfDays;
    }

}

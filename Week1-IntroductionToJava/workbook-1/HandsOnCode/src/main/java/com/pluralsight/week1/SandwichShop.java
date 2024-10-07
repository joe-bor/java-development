package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        float sandwichPrice = getSandwichSize() == 1 ? 5.45f : 8.95f;
        boolean isSandwichLoaded = wantSandwichLoaded();
        int customerAge = getCustomerAge();
        float discount = determineDiscount(customerAge);
        float extraCharge = isSandwichLoaded ? getSandwichSize() == 1 ? 1f : 1.75f : 0f;
        // condition ? return this if true : return this

        System.out.println("The total cost of the sandwich is $" + ((sandwichPrice + extraCharge) * discount));
    }

    public static int getSandwichSize(){
        System.out.println("What size of sandwich would you like (1 or 2) ?");
        while (!scanner.hasNextInt()){
            System.out.println("1 or  2?");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int getCustomerAge(){
        System.out.println("How old are you?");
        while (!scanner.hasNextInt()){
            System.out.println("How old are you?");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static float determineDiscount(int customerAge){
        float discount;
        if (customerAge <= 17){
            discount = 0.9f;
        } else if (customerAge >= 65) {
            discount = 0.8f;
        } else {
            discount = 1f;
        }
        return discount;
    }

    public static boolean wantSandwichLoaded(){
        String answer = "";
        System.out.println("Would you like a 'loaded' sandwich for additional price?");
        answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")){
            System.out.println("yes or no ?");
            answer = scanner.nextLine();
        }
        return answer == "yes" ? true : false;

    }

}

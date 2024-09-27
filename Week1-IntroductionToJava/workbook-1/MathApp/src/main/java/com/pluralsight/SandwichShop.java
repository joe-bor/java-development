package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        float sandwichPrice = getSandwichSize() == 1 ? 5.45f : 8.95f;
        int customerAge = getCustomerAge();
        float discount = determineDiscount(customerAge);

        System.out.println("The total cost of the sandwich is $" + (sandwichPrice * discount));
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

}

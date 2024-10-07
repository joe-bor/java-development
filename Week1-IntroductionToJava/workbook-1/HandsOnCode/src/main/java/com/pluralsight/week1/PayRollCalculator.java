package com.pluralsight;

import java.util.Scanner;

public class PayRollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        print("What is your name?");
        String name = scanner.nextLine();
        print("How many hours did you work?");
        float hoursWorked = scanner.nextFloat();
        print("What is your pay rate?");
        float payRate = scanner.nextFloat();
        scanner.nextLine();

        print(name + " is getting paid " + (hoursWorked < 40 ? hoursWorked * payRate : (40 * payRate) + ((hoursWorked-40)*payRate) ));
        
        
        
        
        
        
        scanner.close();
    }
    
    public static void print(Object o){
        System.out.println(o.toString());
    }
}

package com.pluralsight;

import java.util.Scanner;

public class ScanExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int myInt = scanner.nextInt();
        System.out.println("age: " + myInt);

        String input1 = scanner.nextLine();
        System.out.println("Hi");
        System.out.println(input1);
        System.out.println("Hello");
//        System.out.println("input is... + " + input1 + "asd");

        scanner.close();
    }
}

package com.pluralsight.week5;

public class StaticClasses {
    public static void main(String[] args) {
            System.out.println("\n--------------");
            System.out.println(NameFormatter.format("", ""));
            System.out.println(NameFormatter.format("Error", ""));
            System.out.println(NameFormatter.format("", "Error"));

            System.out.println("\n---------------");
            System.out.println(NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD"));
            System.out.println(NameFormatter.format("", "Mel", "", "Johnson", "PhD"));
            System.out.println(NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD"));
            System.out.println(NameFormatter.format("", "Mel", "", "Johnson", "PhD"));
    }
}

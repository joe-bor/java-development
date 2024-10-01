package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class MiniExercises {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println(getLengthOfString("hello"));
//        System.out.println(multiplyByStr("bla", 3));
//        System.out.println(sumOfLetters("abc"));

//        determineYearOfBirth();
    }

    static int getLengthOfString(String str) {
        return str.length();
    }

    static String multiplyByStr(String str, int multiplier){
        var stringBuilder = new StringBuilder();

        for (int i = 0; i < multiplier; i++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    static int sumOfLetters(String str){
        // found out that chars are represented by their int values in Java
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int charValue = str.charAt(i);
//            System.out.println(charValue);
            sum += charValue;
        }
        return sum;

    }

    static void determineYearOfBirth(){
        System.out.println("How old are you going to be at the end of this year?");
        int ageThisYear = scanner.nextInt();

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int birthYear = currentYear - ageThisYear;
        System.out.println("You were born on " + birthYear);
    }
}

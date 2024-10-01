package com.pluralsight;

public class MiniExercises {
    public static void main(String[] args) {
//        System.out.println(getLengthOfString("hello"));
//        System.out.println(multiplyByStr("bla", 3));
        System.out.println(sumOfLetters("abc"));
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
}

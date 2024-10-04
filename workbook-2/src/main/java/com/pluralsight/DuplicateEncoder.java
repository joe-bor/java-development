package com.pluralsight;

import java.util.HashMap;

public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println("ABCDEF".chars());
//        String result = encode("heloooo");
//        System.out.println(result);
    }
    static String encode(String word){
        // first loop and create a freq counter
        HashMap<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.toLowerCase().charAt(i);
            counter.put(currentChar, counter.getOrDefault(currentChar, 0) + 1);
        }
        System.out.println(counter);

        var stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.toLowerCase().charAt(i);

            if(counter.get(currentChar) > 1){
                stringBuilder.append(")");
            } else {
                stringBuilder.append("(");
            }
        }
        word = stringBuilder.toString();

        return word;
    }
}


package codeWars;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 6kyu
/*
Create a function taking a positive integer between 1 and 3999 (both included) as its parameter and returning a string containing the Roman Numeral representation of that integer.

Modern Roman numerals are written by expressing each digit separately starting with the leftmost digit and skipping any digit with a value of zero. There cannot be more than 3 identical symbols in a row.

In Roman numerals:

1990 is rendered: 1000=M + 900=CM + 90=XC; resulting in MCMXC.
2008 is written as 2000=MM, 8=VIII; or MMVIII.
1666 uses each Roman symbol in descending order: MDCLXVI.
*/
public class RomanNumeralsEncoder {
    public static void main(String[] args) {
        System.out.println(solution(1990));
        System.out.println(solution(2008));
        System.out.println(solution(1666));


    }

    public static String solution(int n) {
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        var sb = new StringBuilder();
        for (int i = 0; i < romanSymbols.length; i++) {
            // from highest to lowest
            // subtract the values to current 'n'
            // while creating the roman numeral equivalent
            while (n >= values[i]){
                sb.append(romanSymbols[i]);
                n -= values[i];
            }
        }
        return sb.toString();
    }
}

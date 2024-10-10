package codeWars;

/*
* Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.

Examples:
Input: 42145 Output: 54421

Input: 145263 Output: 654321

Input: 123456789 Output: 987654321
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {

    public static void main(String[] args) {
        sortDesc(823844);
    }

    public static int sortDesc(final int num) {
        //Your code
        var x = String.valueOf(num).toCharArray();
        Arrays.sort(x);

        StringBuilder sb = new StringBuilder();

        for (int i = x.length - 1; i >= 0; i--) {
            sb.append(x[i]);
        }
        System.out.println(sb);
        return Integer.parseInt(sb.toString());
    }

    public static int sortDesc2(int num) {
        String[] numStrArr = String.valueOf(num).split("");
        Arrays.sort(numStrArr, Collections.reverseOrder());
        return Integer.valueOf(String.join("", numStrArr));
    }
}

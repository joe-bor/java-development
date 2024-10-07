package com.pluralsight;

import java.util.Arrays;

public class WhoLikesIt {
    public static void main(String[] args) {
        whoLikesIt();
        whoLikesIt("hello");
        whoLikesIt("hello", "hi");
        whoLikesIt("hello", "hi", "john");
        whoLikesIt("hello", "hi", "john", "jane");
    }

    public static String whoLikesIt(String... names) {
        //Do your magic here
//        String[] names = names.split(",");
        int numOfLikes = names.length;

        String result = switch(numOfLikes){
            case 0 -> "no one likes this";
            case 1 -> String.format("%s likes this", names[0]);
            case 2 -> String.format("%s and %s likes this", names[0], names[1]);
            case 3 -> String.format("%s, %s and %s likes this", names[0], names[1], names[2]);
            default -> String.format("%s, %s and %d others like this", names[0], names[1], numOfLikes - 2);
        };
        System.out.println(result);
        return result;
    }
}



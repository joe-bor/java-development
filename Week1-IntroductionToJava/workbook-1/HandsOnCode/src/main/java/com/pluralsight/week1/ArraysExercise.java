package com.pluralsight;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.Arrays;

public class ArraysExercise {

    public static void main(String[] args) {

        String[] faveMovies = {"Superman", "Batman", "ABC", "ABB", "0"};
        String[] faveFriends = {"Luffy", "Zoro", "Sanji"};
        int[] faveNumbers = {26, 8, 22, 20, 1};

        System.out.println(faveMovies.length);
        Arrays.sort(faveMovies);
        System.out.println(Arrays.toString(faveMovies));
        System.out.println(faveMovies[faveMovies.length - 1]);
//        System.out.println(faveMovies[-1]);

        String[] newArray = Arrays.copyOfRange(faveMovies, 3, 10);
        System.out.println(Arrays.toString(newArray));
//        System.out.println(newArray);
//        System.out.println(faveMovies);
    }


}

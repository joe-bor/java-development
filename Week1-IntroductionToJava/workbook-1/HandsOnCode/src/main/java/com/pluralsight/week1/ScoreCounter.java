package com.pluralsight;

import java.util.Scanner;

public class ScoreCounter {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String scoresFromUser =  getScoresFromUser();
        int counter = scoreCounter(scoresFromUser);
        System.out.println(counter);
        scanner.close();
    }

    static String getScoresFromUser(){
        System.out.println("Enter five test scores between 1 and 10");
        String scoreStrings = scanner.nextLine();
        return scoreStrings;
    }

    static int scoreCounter(String strOfNums){
        int counter = 0;

        for(String nums: strOfNums.split(",")){
            int currentNum = Integer.parseInt(nums); // can throw
            if (currentNum > 7) counter++;
        }
        return counter;
    }
}

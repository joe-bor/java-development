package com.pluralsight.week3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestStatistics {

    static int[] testScores = {65, 24, 67, 89, 99, 87, 65, 76, 89, 94};

    public static void main(String[] args) {
        System.out.println(getAverage(testScores));
        System.out.println(getHighestScore(testScores));
        System.out.println(getLowestScore(testScores));
        System.out.println(getMedian(testScores));
    }

    public static int getAverage(int[] testScores) {
        int sum = 0;
        for( int scores: testScores){
            sum += scores;
        }
        return sum/ testScores.length;
    }
    public static int getHighestScore(int[] testScores) {
        if (testScores.length == 0) return 0;
        int maxNum = Integer.MIN_VALUE;

        for (int scores : testScores){
            if (scores > maxNum){
                maxNum = scores;
            }
        }
        return maxNum;
    }
    public static int getLowestScore(int[] testScores){
        if (testScores.length == 0) return 0;
        int minNum = Integer.MAX_VALUE;

        for(int scores: testScores){
            if( scores < minNum){
                minNum = scores;
            }
        }
        return minNum;
    }
    public static int getMedian(int[]testScores){
        int avg = getAverage(testScores);
        int median = 0;
        Arrays.sort(testScores);

        if (testScores.length % 2 == 1) {
            int indexOfMedian = Math.round(testScores.length/2) + 1;
            median = testScores[indexOfMedian];
        } else {
            int leftIndex = testScores.length / 2;
            int rightIndex = leftIndex + 1;

            median =  (testScores[leftIndex] + testScores[rightIndex]) / 2;

        }
        return avg - median;
    }
}

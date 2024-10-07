package com.pluralsight;

import java.util.HashSet;
import java.util.Scanner;

public class CollectingWords {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        collectWords();
        scanner.close();
    }

    static void collectWords(){
        var collectedWords = new HashSet<String>();
        boolean isCollecting = true;

        System.out.println("Provide a word");
        while (isCollecting){
            String word =  scanner.nextLine();
            if (word.trim().isEmpty()){
                isCollecting = false;
                break;
            }
            collectedWords.add(word);
            System.out.println("Give another word");
        }

        System.out.println("\nYou entered nothing.");
        System.out.println("Here are the words you provided:");
        for (String word: collectedWords){
            System.out.println("\t- " + word);
        }

        printShortestWord(collectedWords);
        printLongestWord(collectedWords);
        printAvgLengthOfAllWords(collectedWords);
    }

    static void printShortestWord(HashSet<String> words){
        if (words.isEmpty()) return;

        int currShortestLength = Integer.MAX_VALUE;
        String currShortestWord = "";

        for(String word: words){
            if (word.length() < currShortestLength){
                currShortestLength = word.length();
                currShortestWord = word;
            }
        }
        if (!currShortestWord.trim().isEmpty()){
            System.out.println("The shortest word is " + currShortestWord);
        }
    }

    static void printLongestWord(HashSet<String> words){
        if (words.isEmpty()) return;

        int currLongestLength = Integer.MIN_VALUE;
        String currLongestWord = "";

        for (String word: words){
            if (word.length() > currLongestLength){
                currLongestLength = word.length();
                currLongestWord = word;
            }
        }
        System.out.println("The longest word is " + currLongestWord);
    }

    static void printAvgLengthOfAllWords(HashSet<String> words){
        int totalWordLength = 0;
        int wordCount = 0;

        for (String word: words){
            totalWordLength += word.length();
            wordCount++;
        }

        System.out.println("The average length of all words is " + (totalWordLength/wordCount));
    }

}

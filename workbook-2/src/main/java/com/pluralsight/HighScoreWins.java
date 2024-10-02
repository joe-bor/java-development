package com.pluralsight;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HighScoreWins {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please Enter a Game Score: ");
        String userInput = scanner.nextLine().trim();

        String[] arr = userInput.split(Pattern.quote("|"));
        String[] teamNames = arr[0].trim().split(Pattern.quote(":"));
        String[] teamScores = arr[1].trim().split(Pattern.quote(":"));

        String winner = "";
        int indexOfHighestScore = -1;
        int highestScore = Integer.MIN_VALUE;

        for (int i = 0; i < teamNames.length; i++) {
            int currScore = Integer.parseInt(teamScores[i]);

            if (currScore > highestScore){
                highestScore = currScore;
                indexOfHighestScore = i;
            }
        }
        winner = teamNames[indexOfHighestScore];
        System.out.println("Winner: " + winner);
    }
}

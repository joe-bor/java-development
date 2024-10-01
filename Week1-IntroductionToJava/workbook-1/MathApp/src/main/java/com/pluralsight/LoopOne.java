package com.pluralsight;

import java.util.Scanner;

public class LoopOne {

    static Scanner scanner = new Scanner(System.in);
    static boolean isRunning = true;

    public static void main(String[] args) {

//        do {
//            int maxOfThreeNms = getMaxOfThreeNums();
//            System.out.println(maxOfThreeNms);
//            wantToQuit();
//        } while (isRunning);
//
//        scanner.close();

        LoopTwo.main(new String[]{"Hello"});
    }

    static int getMaxOfThreeNums() {
        System.out.println("Please enter THREE numbers separated by comma");
        System.out.println("A number CANNOT have spaces nor underscores");
        String threeNumbers = scanner.nextLine();

        int maxNum = Integer.MIN_VALUE;

        try {
            for (String numString : threeNumbers.split(",")) {
                int num = Integer.parseInt(numString); // <--- can cause error
                if (num > 10 || num < 1) {
                    throw new IllegalArgumentException("Numbers must be between 1 through 10");
                }
            }
            System.out.println(maxNum);
            return maxNum;
        } catch (NumberFormatException e) {
           System.err.println("Invalid input: Must be parseable to a number");
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            System.out.println("-------");
            System.err.println(e.getMessage());
        }
        return maxNum;
    }

    static void wantToQuit(){
        System.out.println("Would you like to quit? [Y/N]");
        String toQuit = scanner.nextLine();
        if (toQuit.trim().toUpperCase().equalsIgnoreCase("Y")){
            isRunning = false;
        }
    }
}

class LoopTwo {
    public static void main(String[] args) {
        String userInput = args[0];

        for (int i = 0; i < userInput.length(); i++) {
            System.out.println(userInput.charAt(i));
        }
    }
}

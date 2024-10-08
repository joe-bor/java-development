package com.pluralsight.week3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedTimeStories {
    private static final Scanner scanner = new Scanner(System.in);
//    static File[] storiesFile = {new File("goldilocks.txt"), new File("hansel_and_gretel.txt"), new File("mary_had_a_little_lamb.txt")};
    static String[] storiesFile = {"goldilocks.txt", "hansel_and_gretel.txt", "mary_had_a_little_lamb.txt"};

    public static void main(String[] args) throws FileNotFoundException {
        promptUser();
    }

    static void promptUser() throws FileNotFoundException {
        System.out.println("What would oyu like to read?");
        System.out.println("""
                1 - Goldilocks
                2 - Hansel and Gretel
                3 - Mary Had a Little Lamb
                """);

        String options = scanner.nextLine();

        switch (Integer.parseInt(options)){
            case 1 -> printReadFile(0);
            case 2 -> printReadFile(1);
            case 3 -> printReadFile(2);
            default -> promptUser();
        }
    }

    static void printReadFile(int index) throws FileNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(storiesFile[index]);
            Scanner scanner1 = new Scanner(fis);

            String input;
            int lineCounter = 1;
            while (scanner1.hasNextLine()){
                input = scanner1.nextLine();
                System.out.println(lineCounter + ".\t" + input);
                lineCounter++;
            }
            scanner1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

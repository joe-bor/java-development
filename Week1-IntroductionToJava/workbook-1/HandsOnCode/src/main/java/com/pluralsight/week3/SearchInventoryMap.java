package com.pluralsight.week3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchInventoryMap {

    private static final Map<Integer, Product> idToProduct = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static boolean isAppRunning = true;

    public static void main(String[] args) {
        loadInventory();
        printInventory();
        do {
            promptUser();
        } while (isAppRunning);
    }

    static void loadInventory(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String input;
            try {
                while ((input = bufferedReader.readLine()) != null){
                    String[] arr = input.split(Pattern.quote("|"));
                    Product newProduct = new Product(Integer.parseInt(arr[0]), arr[1], Float.parseFloat(arr[2]));
                    idToProduct.put(newProduct.getId(), newProduct);
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    static void printInventory(){
        System.out.println("\nHere are our products");
        for (int id : idToProduct.keySet()){
            System.out.println(String.format("Id: %d | Name: %s | Price: %.2f", idToProduct.get(id).getId(), idToProduct.get(id).getName(), idToProduct.get(id).getPrice()));
        }

    }

    static void promptUser(){
        System.out.println("\nDo you want to search for a product? (y/n)" );
        String userInput = scanner.nextLine().trim();

        if (userInput.equalsIgnoreCase("y")) {
            searchForProductById();
        } else {
            quitProgram();
        }
    }

    public static void quitProgram() {
        System.out.println("Quitting the program...");
        isAppRunning = false;
    }

    static void searchForProductById(){
        System.out.print("Enter the Id of the product you are looking for: ");
        int id  = scanner.nextInt();
        scanner.nextLine();

        if (idToProduct.get(id) != null) {
            System.out.println(idToProduct.get(id));
        } else {
            System.out.println("Product Id not found");
        }
    }
}

package com.pluralsight.week3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class SearchInventory {

    static private List<Product> inventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean isRunning = true;

    public static void main(String[] args) throws IOException {
//        for (Product product : getInventory()){
//            System.out.println(product);
//        }
        // https://www.bezkoder.com/java-sort-arraylist-of-objects/
        addProductsViaFileRead("inventory.csv");

        while (isRunning){
            printOptions();
        }
    } // end of main

    public static List<Product> getInventory() {
        inventory.sort(Comparator.comparing(Product::getName));
        return inventory;
    }

    public static void addProductsViaFileRead(String fileName){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String input;
            while((input = bufferedReader.readLine()) != null){
                String[] arr = input.split(Pattern.quote("|"));
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                float price = Float.parseFloat(arr[2]);

                inventory.add(new Product(id, name, price));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    static void printOptions(){
        System.out.println("""
                ------------------------
                What do you want to do?
                    1 - List all products
                    2 - Look up a product by its id
                    3 - Find all products within a price range
                    4 - Add a new product
                    5 - Quit the application
                """);
        executeOption();
    }

    static void executeOption(){
        String option = scanner.nextLine();

        switch (option){
            case "1" -> printAllProducts();
            case "2" -> searchProductById();
            case "3" -> searchProductByPriceRange();
            case "4" -> createNewProduct();
            case "5" -> quitProgram();
        }
    }

    private static void createNewProduct() {
        System.out.println("Creating a new product...");
        System.out.print("Provide id: ");
        int id = scanner.nextInt();
        System.out.print("Provide name: ");
        String name = scanner.nextLine();
        System.out.print("Provide price: ");
        float price = scanner.nextFloat();

        Product newProduct = new Product(id, name, price);
        System.out.println("New product added");
        System.out.println(newProduct);
    }

    private static void searchProductByPriceRange() {
        System.out.println("Please provide min price");
        float minPrice = scanner.nextFloat();

        System.out.println("Please provide max price");
        float maxPrice = scanner.nextFloat();

        List<Product> productsInsideRange = new ArrayList<>();
        for (Product product : getInventory()){
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice){
                productsInsideRange.add(product);
            }
        }

        System.out.println("Here are the products whose price are between" + minPrice + " and " + maxPrice);
        productsInsideRange.forEach(System.out::println);
    }

    private static void searchProductById() {
        System.out.println("Please provide the Id of the product you are looking for");
        int id = scanner.nextInt();

        for (Product product : inventory){
            if (id == product.getId()){
                System.out.println("Here you go:");
                System.out.println(product);
                break;
            }
        System.out.println("Product not found");
        }
    }

    private static void quitProgram() {
        System.out.println("Terminating program...");
        isRunning = false;
    }

    private static void printAllProducts() {
        System.out.println("Here are all the products we have;");
        getInventory().forEach(System.out::println);
    }

}

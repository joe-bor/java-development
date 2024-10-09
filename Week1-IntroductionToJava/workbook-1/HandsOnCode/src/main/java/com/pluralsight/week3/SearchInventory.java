package com.pluralsight.week3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class SearchInventory {
    public static void main(String[] args) throws IOException {
//        for (Product product : getInventory()){
//            System.out.println(product);
//        }
        // https://www.bezkoder.com/java-sort-arraylist-of-objects/
        getInventory().forEach(System.out::println);
    }

    public static ArrayList<Product> getInventory() throws IOException {
        ArrayList<Product> inventory = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
        String input;
        while((input = bufferedReader.readLine()) != null){
            String[] arr = input.split(Pattern.quote("|"));
            int id = Integer.parseInt(arr[0]);
            String name = arr[1];
            float price = Float.parseFloat(arr[2]);

            inventory.add(new Product(id, name, price));
        }
        // https://www.bezkoder.com/java-sort-arraylist-of-objects/
//        Collections.sort(inventory, Comparator.comparing(Product::getName));
        inventory.sort(Comparator.comparing(Product::getName));
        return inventory;
    }
}

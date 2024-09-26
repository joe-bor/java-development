package com.pluralsight;

public class ShoppingList {
    public static void main(String[] args) {
        String[] groceryList = {
                "apple",
                "banana",
                "watermelon"
        };

        int x = 1;
        double y = 1.0;
        float z = 1.0f;

        for (String s : groceryList) {
            System.out.println(s);
        }
    }
}

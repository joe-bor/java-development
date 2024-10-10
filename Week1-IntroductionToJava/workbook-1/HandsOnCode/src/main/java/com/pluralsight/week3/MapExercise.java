package com.pluralsight.week3;

import java.util.*;

public class MapExercise {
    static HashMap<String, String> statesAndCapitals = new HashMap<String, String>();
    static {
        statesAndCapitals.put("CT", "Hartford");
        statesAndCapitals.put("CA", "Sacramento");
        statesAndCapitals.put("WA", "Olympia");
        statesAndCapitals.put("TX", "Austin");
        statesAndCapitals.put("FL", "Tallahassee");
    }

    public static void main(String[] args) {
        exercise3();
    }

    static void exercise1() {
        // name to fruits
        Map<String, String> nameToFruits = new HashMap<>() {{
            put("Cesar", "Apple");
            put("Akbar", "orange");
            put("Grecia", "Watermelon");
        }}; // DON'T USE
        System.out.println(nameToFruits);


        // nums 1-5 to their squared values
        int[] nums = {1, 2, 3, 4, 5};
        Map<Integer, Double> numsToSquared = new HashMap<>();

        for (int num : nums) {
            numsToSquared.put(num, Math.pow(num, 2));
        }
        System.out.println(numsToSquared);

        // string owner to list of puppies
        Map<String, List<Puppy>> ownerToPuppyList = new HashMap<>();
        Puppy puppy1 = new Puppy();
        List<Puppy> puppyList1 = new ArrayList<>();
        puppyList1.add(puppy1);
        ownerToPuppyList.put("Me", puppyList1);

        System.out.println(ownerToPuppyList);
    }

    static void exercise2() {
        HashMap<String, String> statesAndCapitals = new HashMap<String, String>();
        statesAndCapitals.put("CT", "Hartford");
        statesAndCapitals.put("CA", "Sacramento");
        statesAndCapitals.put("WA", "Olympia");
        statesAndCapitals.put("TX", "Austin");
        statesAndCapitals.put("FL", "Tallahassee");
//        for (String value : statesAndCapitals.values()) {
//            System.out.println(value);
//        }

        // compute takes 2 params, 1: key to look up, 2: function to apply to the value associated with key)
        // if key is not present: null is passed to param 2
        // if computed value is null: entry is removed
        var y = statesAndCapitals.compute("CT", (key, value) -> value + " " + key + " " + value);
        System.out.println(statesAndCapitals.get("CT"));
        System.out.println(y);

        var x = statesAndCapitals.computeIfAbsent("CA", (key) -> "San Francisco + " + key);
        System.out.println(x);
        System.out.println(statesAndCapitals.get("CA"));

    }

    static void exercise3() {

        //Type of z:  Set<Map.Entry<String,String>>
        var z = statesAndCapitals.entrySet();
        for (Map.Entry<String, String> entry : z){
            if (entry.getKey().equals("CA")){
                entry.setValue("San Francisco?");
            }
        }

        // Print
        System.out.println(z);
        System.out.println(statesAndCapitals);
    }

    static class Puppy {
        String breed;
    }
}

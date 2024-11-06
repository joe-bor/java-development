package com.pluralsight.week7.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe", 25));
        people.add(new Person("Jane", "Doe", 28));
        people.add(new Person("Alice", "Smith", 30));
        people.add(new Person("Bob", "Johnson", 22));
        people.add(new Person("Charlie", "Brown", 35));
        people.add(new Person("David", "Williams", 40));
        people.add(new Person("Emily", "Jones", 27));
        people.add(new Person("Frank", "Miller", 31));
        people.add(new Person("Grace", "Davis", 29));
        people.add(new Person("Hannah", "Wilson", 26));


        System.out.print("Search for a name (first or last): ");
        Scanner scanner = new Scanner(System.in);
        String nameToBeSearched = scanner.nextLine();

        List<Person> nameMatch = new ArrayList<>();
        for (Person person : people){
            if (person.getFirstName().equalsIgnoreCase(nameToBeSearched) || person.getLastName().equalsIgnoreCase(nameToBeSearched)){
                nameMatch.add(person);
            }
        }

        for (Person p : nameMatch){
            System.out.println("People found: ");
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }


        // Step 3
        int totalAge = 0;
        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;

        for (Person person : people){
            int ageOfCurrentPerson = person.getAge();

            totalAge += ageOfCurrentPerson;

            if (ageOfCurrentPerson < minAge) {
                minAge = ageOfCurrentPerson;
            }

            if (ageOfCurrentPerson > maxAge) {
                maxAge = ageOfCurrentPerson;
            }
        }

        int avgAge = totalAge / people.size();

        System.out.printf("""
                ---
                Avg age: %d
                Min age: %d
                Max age: %d
                """, avgAge, minAge, maxAge);
    }

}

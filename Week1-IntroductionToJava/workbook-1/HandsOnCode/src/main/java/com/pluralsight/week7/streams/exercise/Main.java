package com.pluralsight.week7.streams.exercise;

import java.util.*;

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

        List<Person> nameMatch = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(nameToBeSearched) ||
                        person.getLastName().equalsIgnoreCase(nameToBeSearched))
                .toList();

        nameMatch.forEach(person -> System.out.println("Found: " + person.getFirstName() + " " + person.getLastName()));


        // Step 3
        int totalAge = people.stream()
                .mapToInt(value -> value.getAge())
                .sum();
        int avgAge = totalAge / people.size();

        OptionalInt minAge = people.stream()
                .mapToInt(value -> value.getAge())
                .min();
        OptionalInt maxAge = people.stream()
                .mapToInt(value -> value.getAge())
                .max();

        System.out.printf("""
                ---
                Avg age: %d
                Min age: %d
                Max age: %d
                """, avgAge, minAge.getAsInt(), maxAge.getAsInt());

        // ----------- Alternative ways --------------
        int oldestAge = people.stream()
                .map(person -> person.getAge())
                .reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a,b));

        int youngestAge = people.stream()
                .map(person -> person.getAge())
                .reduce(Integer.MAX_VALUE, (acc, curr) -> Integer.min(acc, curr));

        System.out.println("oldestAge = " + oldestAge);
        System.out.println("youngestAge = " + youngestAge);

        // using sorted
        // oldest
        var oldestPerson = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .findFirst();
        oldestPerson.ifPresentOrElse(p -> System.out.println(p.getFirstName()), () -> System.out.println("missing"));

        var youngestPerson = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .findFirst();
        youngestPerson.ifPresentOrElse(person -> System.out.printf("%s is the youngest, with age of %d", person.getFirstName(), person.getAge()), ()-> System.out.println("missing"));


    }

}

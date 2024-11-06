package com.pluralsight.week7.streams.exercise;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {

        // 1
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 66, 234);
        List<Integer> filteredList = integerList.stream()
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer * integer)
                .toList();

        System.out.println(filteredList);
    }
}

class TerminalOperationsExample {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 66, 234);
        System.out.println(integerList.stream().count());
    }
}

class IntermediateOperationsExample {
    public static void main(String[] args) {
        List<String> stringList = List.of("apple", "banana", "orange");
        List<String> newList = stringList.stream()
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .toList();

        System.out.println(newList);
    }
}

class LoopToForEachExample {
    public static void main(String[] args) {

        List<String> stringList = List.of("apple", "banana", "orange");
        stringList.stream()
                .forEach(System.out::println);

        stringList.stream()
                .forEach(s -> System.out.println(s));
    }
}
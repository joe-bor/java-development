package com.pluralsight.week7.lambda.mini_exercise;

import com.pluralsight.week7.Intern;

import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {
    public static void main(String[] args) {
        UnaryOperator unaryOperator = num1 -> num1 * num1;
        int result = unaryOperator.apply(4);
        System.out.println("result = " + result);

        // Multiple params
        TriFunction triFunction = (num1, num2, num3) -> {
            int total = num1 + num2 + num3;
            return total / 3;
        };

        int result2 = triFunction.apply(4, 8, 12);
        System.out.println("result2 = " + result2);

        // Reeturning void
        Printer printer = s1 -> System.out.println(s1);
        printer.print("hello");

        // Generic
        Predicate<String> stringPredicate = object -> object.isEmpty();
        System.out.println(stringPredicate.test(""));
        System.out.println(stringPredicate.test("Not empty"));

        // Passin lambda expression ot a method
        Predicate<String> stringPredicate1 = object -> object.startsWith("a");
        processString(object -> object.startsWith("b"), List.of("apple", "banana", "orange", "a random string", "food"));

        // Using built-in functional interfaces
        List<Integer> integerList =  List.of(1,2,3,4,5);
        integerList.forEach(integer -> System.out.println(integer));
//        integerList.forEach(integer -> System.out::println);
        integerList.forEach(System.out::println);

    }

    static void processString(Predicate<String> stringPredicate, List<String> stringList){
        for (String string : stringList){
            if (stringPredicate.test(string)){
                System.out.println(string);
            }
        }
    }
}

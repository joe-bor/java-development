package com.pluralsight.week7.lambda.mini_exercise;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T object);
}

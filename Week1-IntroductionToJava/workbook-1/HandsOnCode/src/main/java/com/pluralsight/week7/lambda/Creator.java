package com.pluralsight.week7.lambda;

@FunctionalInterface
public interface Creator<T> {
    T create();
}

package com.pluralsight.week7.streams.exercise;

import java.util.Comparator;
import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        Course course1 = new Course("Math", 80, 20);
        Course course2 = new Course("English", 24, 45);
        Course course3 = new Course("History", 50, 79);

        List<Course> courseList = List.of(course1, course2, course3);

        System.out.println("\nPrinted by course title, alphabetical");
        courseList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nPrinted by name DESC alphabetical");
        courseList.stream()
                .sorted(Comparator.comparing(Course::getTitle).reversed())
                .forEach(System.out::println);

        System.out.println("\nPrinted by # of students (low to high)");
        courseList.stream()
                .sorted(Comparator.comparingInt(Course::getMaxNumOfStudents))
                .forEach(System.out::println);

        System.out.println("\nPrinted by study points (high to low)");
        courseList.stream()
                .sorted(Comparator.comparingInt(Course::getStudyPoints).reversed())
                .forEach(System.out::println);
    }
}

package com.pluralsight.week6.Polymorphism;

public class Program {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        Shape s2 = new Square();
        Shape s3 = new Circle();

        s1.calculateArea();
        s1.calculateCircumference();

        ((Square)s2).setSideSize(2);
        s2.calculateArea();
        s2.calculateCircumference();
    }
}

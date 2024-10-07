package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        System.out.println("----- Exercises on page 66 of Intro to Java Workbook -----");
        System.out.println();

        System.out.println("Q1:");
        /*
        Create two variables to represent the salary for Bob and Gary, name them
        bobSalary and garySalary. Create a new variable named
        highestSalary. Determine whose salary is greater using Math.max() and
        store the answer in highestSalary. Set the initial salary variables to any value
        you want. Print the answer (i.e "The highest salary is ...")
        */
        int bobSalary = 123456;
        int garySalary = 1239864;
        int highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary is... " + highestSalary);
        System.out.println();

        System.out.println("Q2:");
        /*
        Find and display the smallest of two variables named carPrice and
        truckPrice. Set the variables to any value you want.
        */
        int carPrice = 5464654;
        int truckPrice = 8927892;
        System.out.println("The smallest of teh two variables is... " + Math.min(carPrice, truckPrice));
        System.out.println();

        System.out.println("Q3:");
        /* Find and display the area of a circle whose radius is 7.25 */
        float pi = 3.14f;
        float radiusOfCircle = 7.25f;
        double circleArea = radiusOfCircle * (Math.pow(pi, 2));
        System.out.println("The area of a circle whose radius is " + radiusOfCircle + " is " + circleArea);
        System.out.println();

        System.out.println("Q4:");
        /* Find and display the square root a variable after it is set to 5.0 */
        double number144 = 144;
        double squareRootOf144 = Math.sqrt(number144);
        System.out.println("The square root of the number " + number144 + " is " + squareRootOf144);
        System.out.println();

        System.out.println("Q5:");
        /*
        * Find and display the distance between the points (5, 10) and (85, 50)
        * distance formula: d = sqrt( (num2-num1)^2  + (b2-b1)^2
        */
        int a1 = 5, a2 = 10;
        int b1 = 85, b2 = 50;
        double squaredDiffOfPointsA = Math.pow((a2-a1), 2);
        double squaredDiffOfPointsB = Math.pow((b2-b1), 2);
        double distance = Math.sqrt( squaredDiffOfPointsA+ squaredDiffOfPointsB);
        System.out.println("The distance between points (" + a1 + ", " + a2 + ") and (" + b1 + ", " + b2 + ") is + " + distance + "." );
        System.out.println();

        System.out.println("Q6:");
        /* Find and display the absolute (positive) value of a variable after it is set to -3.8 */
        float negativeThreePointEight = -3.8f;
        float absValueOfNumAbove = Math.abs(negativeThreePointEight);
        System.out.println("The absolute value of " + negativeThreePointEight + " is " + absValueOfNumAbove);
        System.out.println();

        System.out.println("Q7:");
        /* Find and display a random number between 0 and 1 */
        double randomNumberBetweenZeroAndOne = Math.random();
        System.out.println("This is a random number between 0 and 1 (exclusive): " + randomNumberBetweenZeroAndOne);
        System.out.println();

        System.out.println("----- End of Exercises on page 66 of Intro to Java Workbook -----");
    }
}

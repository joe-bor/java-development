package com.pluralsight.week7.lambda.mini_exercise;

public class LambdaExample {

    public static void main(String[] args) {
        NumericOperator numericOperator = new NumericOperator() {
            @Override
            public int operate(int num1, int num2) {
                return num1 + num2;
            }
        };

        int result = numericOperator.operate(2, 3);
        System.out.println("result = " + result);

        // --------- lambda expression
        NumericOperator numericOperator1 = ((num1, num2) -> num1 + num2);
        int result1 = numericOperator1.operate(2, 3);
        System.out.println("result1 = " + result1);

        // Lambda Expression for Comparison
        NumericOperator numericOperator2 = ((num1, num2) -> Math.max(num1, num2));
        int result2 = numericOperator2.operate(10, 20);
        System.out.println("result2 = " + result2);

        // Another Functional Interface
        StringFormatter stringFormatter = s1 -> s1.toUpperCase();
        String result3 = stringFormatter.format("i was written in lowercase");
        System.out.println("result3 = " + result3);


    }
}

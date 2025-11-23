package com.revature.java8;

public class CalculatorLambda {
    public static void main(String[] args) {
        printResult(2,3,(a, b) -> a+b);
        printResult(3,2,(a,b) -> a-b);
    }
    public static void printResult(int a, int b, Calculator calculator) {
        int result = calculator.operation(a, b);
        System.out.println(result);
    }
}

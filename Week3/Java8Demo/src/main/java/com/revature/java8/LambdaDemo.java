package com.revature.java8;

public class LambdaDemo {
    public static void main(String[] args) {
        Calculator calculator = (a,b) -> a+b;
        System.out.println(calculator.operation(10, 20));
    }
}

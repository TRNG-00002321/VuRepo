package com.revature.assignment;

public class HelloLambda {
    public static void main(String[] args) {
        printHello(()->"Hello");
        printFirst("vu", s -> "Hello " + s.toUpperCase());
        printFull("vu", "phan", (a,b) -> "Hello " + a + " " + b );

    }
    public static void printHello(Hello h){
        String result = h.printHello();
        System.out.println(result);
    }
    public static void printFirst(String a, HelloFirst hellofirst) {
        String result = hellofirst.printHello(a);
        System.out.println(result);
    }
    public static void printFull(String first, String last, HelloFull hello) {
        String result = hello.helloName(first, last);
        System.out.println(result);
    }
}

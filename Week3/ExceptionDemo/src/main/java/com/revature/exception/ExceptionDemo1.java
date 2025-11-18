package com.revature.exception;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        int[] myArray = new int[5];

        try {
            myArray[5] = 10; // this will cause ArrayIndexOutOfBoundsException
            System.out.println("Array Initialized");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("Ending Execution ...");
    }
}

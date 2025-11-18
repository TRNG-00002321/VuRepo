package com.revature.exception;

public class ThrowDemo {
    public static void validateAge(int age) throws ArithmeticException {
        if(age<18){
            throw new ArithmeticException("Invalid Age");}
        else{
            System.out.println("You can vote!");
            }
    }

    public static void main(String[] args) {
        int age = 17;
        try{
            validateAge(age);
        } catch(ArithmeticException e){
            throw new RuntimeException(e);
        }

    }
}

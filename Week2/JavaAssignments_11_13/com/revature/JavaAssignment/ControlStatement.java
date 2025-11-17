package com.revature.JavaAssignment;

public class ControlStatement {
    public static void controlStatement(int n) {
        if (n < 0){
            System.out.println("This is a negative number.");
        }
        else if (n > 0){
            System.out.println("This is a positive number.");
        }
        else {
            System.out.println("This is a neutral number.");
        }
        String result = (n>0) ? "Positive" : "Not positive";
        System.out.println(result);
        switch (n){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
    }
    public static void shortCircuit(int n, int m, int d){
        if (n>m && n>d){
            System.out.println("The largest number is " + n);
        }
        else if (m>n && m>d){
            System.out.println("The largest number is " + m);
        }
        else{
            System.out.println("The largest number is " + d);
        }

    }
    public static void outPutComputation(){
        boolean a = true;
        boolean b = false;
        System.out.println(!a);
        System.out.println(a|b);
        System.out.println((!a&b)|(a&!b));
    }

}

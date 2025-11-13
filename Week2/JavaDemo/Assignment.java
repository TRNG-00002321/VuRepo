import java.util.Scanner;

public class Assignment {
    public static void main(String[] var0) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Assignment menu: ");
        System.out.println("1. Take input: ");
        System.out.println("2. Day of week: ");
        System.out.println("3. Find largest number: ");
        System.out.println("4. Print the pattern: ");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.println("Invalid choice, Try again: ");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                takeInput();
                break;
            case 2:
                daysOfWeek();
                break;
            case 3:
                largestNumber();
                break;
            case 4:
                printPattern();
                break;
        }

    }
    public static void takeInput() {
        Scanner var1 = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String var2 = var1.nextLine();
        System.out.println("Hello " + var2 + "!");
    }
    public static void daysOfWeek() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a day of Week (1-7): ");
        int day = scanner.nextInt();
        switch(day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
        }
    }
    public static void largestNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        if (num1 > num2 && num1 > num3) {
            System.out.println("The largest number is " + num1);
        }
        else if (num2 > num1 && num2 > num3) {
            System.out.println("The largest number is " + num2);
        }
        else {
            System.out.println("The largest number is " + num3);
        }
    }
    public static void printPattern(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many * do you want?: ");
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j<=i;j++)
                System.out.print(j);
            System.out.println();
        }
        for (int i = num-1; i >= 1; i--) {
            for (int j = 1; j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }

    }

}

import java.util.Scanner;

public class ScannerDemo{
	public static void main(String [] args){
	String firstName;
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter Your Name: ");
	firstName=scanner.next();
	System.out.println("Hello, " + firstName);
	}
}
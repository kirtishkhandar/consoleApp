package terminalApp;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		String [] mainMenu = {"Register", "Login", "Forgot Password", "exit"};
		for (int i = 0; i < mainMenu.length; i++) {
			System.out.print((i+1)+". "+mainMenu[i]+"\n");
		}
		int a = sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("Registration:");
			System.out.println("enter your first name");
			String firstName = sc.next();
			System.out.println("enter your last name");
			String lastName = sc.next();
			System.out.println("enter your email");
			String email = sc.next();
			System.out.println("enter your dob");
			int dob = sc.nextInt();
			
			break;
		case 2:
			System.out.println("Login");
			break;
		case 3:
			System.out.println("Forgot Password");
			break;
		default:
			break;
		}
	}

}

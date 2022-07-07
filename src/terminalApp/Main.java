package terminalApp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a = 0;
		while (a != 4) {
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			System.out.println("\n");
			System.out.println("===================================================");
			String[] mainMenu = { "Register", "Login", "Forgot Password", "exit" };
			for (int i = 0; i < mainMenu.length; i++) {
				System.out.print((i + 1) + ". " + mainMenu[i] + "\n");
			}
			a = sc.nextInt();
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
				System.out.println("");
				// call registration method
				// and print registration status in console in the registration method
				boolean registration = true;
				if (registration) {
					System.out.println("registration is successful");
				}
				break;
			case 2:
				System.out.println("Login");
				boolean login = false;
				// call method to check if already login from db
				if (login == false) {
					System.out.println("enter your username");
					String username = sc.next();
					System.out.println("enter your password");
					String password = sc.next();
					// call login method
					// set login true if login successful
					login = true;
					System.out.println("login successful");
				}
				while (login == true) {
					String[] loginMenu = { "show all tweets", "show my tweets", "show a users tweet", "logout" };
					for (int j = 0; j < loginMenu.length; j++) {
						System.out.print((j + 1) + ". " + loginMenu[j] + "\n");
					}
					int input1 = sc.nextInt();
					switch (input1) {
					case 1:
						System.out.println("Showing all tweets");
						break;
					case 2:
						System.out.println("Showing my tweets");
						break;
					case 3:
						System.out.println("enter name of user whose tweet you want to see");
						break;
					case 4:
						System.out.println("Logging out");
						// set login false in db
						login = false;
						break;
					default:
						System.out.println("invalid input");
						break;
					}
				}
				break;
			case 3:
				System.out.println("Forgot Password");
				break;
			case 4:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("invalid input");
				break;
			}

		}

}

}

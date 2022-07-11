package terminalApp;

import java.sql.SQLException;
import java.util.Scanner;

import terminalApp.model.User;
import terminalApp.service.UserService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserService userService = new UserService();

		int a = 0;
		while (a != 4) {
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			System.out.println("\n");
			System.out.println("Console App: ");
			System.out.println("===================================================");
			String[] mainMenu = { "Register", "Login", "Forgot Password", "exit" };
			for (int i = 0; i < mainMenu.length; i++) {
				System.out.print((i + 1) + ". " + mainMenu[i] + "\n");
			}
			try {
				a = sc.nextInt();
			} catch (Exception e) {
				System.err.println("Please use valid input as 1/2/3/4\nTry again");
				continue;
			}
			switch (a) {
			case 1:
				System.out.println("Registration:");
				System.out.println("enter your first name");
				String firstName = sc.next();
				System.out.println("enter your last name");
				String lastName = sc.next();
				System.out.println("enter your gender");
				String gender = sc.next();
				System.out.println("enter your dob");
				int dob;
				if(sc.hasNextInt()) {
					dob = sc.nextInt();
				}
				else {
					System.err.println("date of birth should be in numbers only DDMMYYYY");
					break;
				}
				System.out.println("enter your email");
				String email = sc.next();
				System.out.println("enter your password");
				String password = sc.next();
				System.out.println("");
				//check if user already exist
				if(userService.doesUserExist(email)) {
					System.out.println("Email is already registered with another user");
					break;
				}
				// call registration method
				boolean registration = userService
						.register(new User(firstName, lastName, gender, dob, email, password));
				// and print registration status in console in the registration method
				if (registration) {
					System.out.println("registration is successful");
				} else {
					System.out.println("registration is failed");
				}
				break;
			case 2:
				System.out.println("Login");
				boolean login = false;
				boolean userExist = false;
				// call method to check if already login from db
				System.out.println("enter your username");
				String username = sc.next();
				userExist = userService.doesUserExist(username);
				if(!userExist) {
					System.out.println("User does not exist");
					break;
				}
				login = userService.isLoggedIn(username);
				if (login == false) {
					System.out.println("enter your password");
					String password1 = sc.next();
					login = userService.login(new User(username, password1));
					// call login method
					// set login true if login successful
					if (login) {
						System.out.println("login is successful");
					} else {
						System.out.println("login is failed");
					}
				}
				while (login == true) {
					String[] loginMenu = { "show all tweets", "show my tweets", "show a users tweet", "logout" };
					for (int j = 0; j < loginMenu.length; j++) {
						System.out.print((j + 1) + ". " + loginMenu[j] + "\n");
					}
					int input1 = 0;
					try {
						input1 = sc.nextInt();
					} catch (Exception e) {
						System.err.println("Please use valid input as 1/2/3/4\nTry again");
						break;
					}
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
						userService.logout(username);
						login = false;
						break;
					default:
						System.err.println("invalid input");
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
				System.err.println("invalid input");
				break;
			}

		}

	}

}

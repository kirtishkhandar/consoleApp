package terminalApp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import terminalApp.model.Tweet;
import terminalApp.model.User;
import terminalApp.service.TweetService;
import terminalApp.service.UserService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserService userService = new UserService();
		TweetService tweetService = new TweetService();

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
				int dob = -1;
				System.out.println("Registration:");
				System.out.println("enter your first name");
				String firstName = sc.next();
				System.out.println("enter your last name");
				String lastName = sc.next();
				System.out.println("enter your gender M/F");
				String gender = sc.next();
				while (dob<0) {
					try {
						System.out.println("enter your dob in DDMMYYYY");
						dob = sc.nextInt();						
					} catch (Exception e) {
						// TODO: handle exception
						System.err.println("date of birth should be in numbers only DDMMYYYY");
						dob = -1;
						sc.next();
					}
				}
				System.out.println("enter your email");
				String email = sc.next();
				System.out.println("enter your password");
				String password = sc.next();
				System.out.println("");
				//check if user already exist
				if(userService.doesUserExist(email)) {
					System.err.println("Email is already registered with another user");
					break;
				}
				// call registration method
				boolean registration = userService
						.register(new User(firstName, lastName, gender, dob, email, password));
				// and print registration status in console in the registration method
				if (registration) {
					System.out.println("registration is successful");
				} else {
					System.err.println("registration is failed");
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
						System.err.println("login is failed");
					}
				}
				while (login == true) {
					String[] loginMenu = { "Post a tweet", "view all my tweets", "view all tweets", "show all users", "reset Password", "logout" };
					for (int j = 0; j < loginMenu.length; j++) {
						System.out.print((j + 1) + ". " + loginMenu[j] + "\n");
					}
					int input1 = 0;
					try {
						input1 = sc.nextInt();
					} catch (Exception e) {
						System.err.println("input should be in numbers only");
						break;
					}
					switch (input1) {
					case 1:
						System.out.println("Enter your tweet");
						sc.nextLine();
						String body = sc.nextLine();
						Tweet tweet1 = new Tweet(username, body, null);
						tweetService.post(tweet1);
						break;
					case 2:
						System.out.println("Showing my tweets");
						List<Tweet> myTweets = tweetService.showTweets(username);
						for (Tweet tweet : myTweets) {
							System.out.println("==================================");
							System.out.println(tweet.toString());
							}
						System.out.println("\n");
						break;
					case 3:
						System.out.println("Showing all tweets");
						List<Tweet> allTweets = tweetService.showAllTweets();
						for (Tweet tweet : allTweets) {
							System.out.println("==================================");
							System.out.println(tweet.toString());
							}
						System.out.println("\n");
						break;
					case 4:
						System.out.println("Users");
						List<User> users = userService.showAllUsers();
						for (User user : users) {
							System.out.println("==================================");
							System.out.println(user.toString());
							}
						System.out.println("\n");
						break;
					case 5:
						System.out.println("Resetting your password");
						System.out.println("Enter new password");
						String password1 = sc.next();
						User user1 = new User(username, password1);
						userService.resetPass(user1);
						System.out.println("password reset complete");
						break;
					case 6:
						System.out.println("Logging out");
						// set login false in db
						userService.logout(username);
						login = false;
						break;
					default:
						System.err.println("invalid input:"+input1);
						break;
					}
				}
				break;
			case 3:
				int fDob = -1;
				System.out.println("Forgot Password");
				System.out.println("Enter your email ID");
				String fUsername = sc.next();
				while (fDob<0) {
					try {
						System.out.println("enter your dob in DDMMYYYY");
						fDob = sc.nextInt();						
					} catch (Exception e) {
						// TODO: handle exception
						System.err.println("date of birth should be in numbers only DDMMYYYY");
						dob = -1;
						sc.next();
					}
				}
				if(userService.doesUserExist(fUsername)) {
					if(userService.isDobValid(fUsername, fDob))
						System.out.println("Resetting your password");
						System.out.println("Enter new password");
						String fpassword = sc.next();
						User user1 = new User(fUsername, fpassword);
						userService.resetPass(user1);
						System.out.println("password reset complete");
					break;
				}
				System.err.println("invalid details");
				
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

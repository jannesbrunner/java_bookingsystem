/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.util.Scanner;
import java.util.ArrayList; // for the help storage
import java.io.Serializable;

/**
 * @author Jannes Brunner, Mario Schuetz, Katharina Wunder
 *
 *         This is the main Class of the whole system. (Thus it includes the
 *         main method)
 */
public class Bookingsystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 *            Not in use yet
	 */

	Bash bsh; // the bash (for user input)
	ArrayList<HelpItem> helpstorage; // Holds help information
	Storage storage;
	String loggedUser = "";


	public static void main(String[] args) {

		// creating new System and get it run
		Bookingsystem system = new Bookingsystem();
		system.run();

	}

	public Bookingsystem() {
		this.bsh = new Bash(); // Setting up the Bash
		this.helpstorage = new ArrayList<HelpItem>(); // Setting up the storage
														// for help information
		setHelpitems(); // add new commands with description in this method

		bsh.savehelp(helpstorage, "helpsystem.bin");
		storage = new Storage();
		storage.createMovies();

		printWelcome();
	}

	public void run() {

		String command = "";
		while (!command.equals("quit")) {// termination command

			command = bsh.getInput(); // simply returns the user input as a
										// string

			switch (command) {// evaluating the commands
			case "help":

				for (HelpItem x : helpstorage) {
					System.out.println(x.getName() + " : " + x.getDescription());
				}
				System.out.println("\n");
				break;

			case "quit":
				// nothing to do here yet.
				break;

			case "program":
				// prints all available movies
				storage.allMovies();
				break;
				
			case "login":
				// user login
				login();
				break;
				
			case "register":
				// register new customer
				register();
				break;
				
			case "book":
				//book a show
				book();
				break;

			default: // if the command is unknown
				System.out.println("This command is unknown.");
				System.out.println("type help to learn more.");
			}

		}

		System.out.println("Good bye");
	}
	
	/**
	 * will print the welcome screen
	 */
	private void printWelcome(){
		System.out.println("#############################");
		System.out.println("### Welcome to JEM-Cinema ###");
		System.out.println("#############################\n");
		System.out.println("What would you like to do? \nType 'help' to see available commands.\n");
		
	}

	private void setHelpitems() {
		helpstorage.add(new HelpItem("quit", "To exit the program"));
		helpstorage.add(new HelpItem("test", "Just to test the Help system"));
		helpstorage.add(new HelpItem("program", "Prints out all available movies."));
		helpstorage.add(new HelpItem("login", "Login in to your account. Username and PIN needed."));
		helpstorage.add(new HelpItem("register", "If you are new to our service you can register here."));
		helpstorage.add(new HelpItem("book", "Book a Show"));
	}

	
	
	/**
	 * register new customers. no username duplicates
	 * @param username	loginname
	 * @param lname		lastname
	 * @param fname		firstname
	 * @param pin		password 
	 */	
	private void register(){
		if(loggedUser.equals("")){
			Scanner input = new Scanner(System.in);
			String username;
			String lname;
			String fname;
			String pin;
			
			System.out.print("Username: ");
			username = input.nextLine();		
			System.out.print("Lastname: ");
			lname = input.nextLine();
			System.out.print("Firstname: ");
			fname = input.nextLine();
			System.out.print("PIN: ");
			pin = input.nextLine();
			storage.newCustomer(username, lname, fname, pin);
		}
		else{
			System.out.println("You are already registered and logged in.\n");
		}
	}
	
	/**
	 * login for registered users
	 * @param username
	 * @param pin
	 * @param found checks for already existing username
	 */
	private void login(){
		boolean found = false;

		if(loggedUser.equals("")){
			Scanner input = new Scanner(System.in);
			String username;
			String pin;
		
			System.out.print("Username: ");
			username = input.nextLine();
			System.out.print("PIN: ");
			pin = input.nextLine();
			if(storage.userLogin(username, pin) != null){
				
				loggedUser = username;
				storage.loggedCustomer = storage.userLogin(username, pin);
				
			}
		}
		else{
			System.out.println("You are already logged in.\n");
		}
	}
	
	private void book(){
		storage.allMovies();
		System.out.println("To see more details about the movie of your choice \ntype the number in front of it.\n");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Your Choice: ");
		int movieNum = input.nextInt();
		storage.getSoC(movieNum);
		int choice = input.nextInt();
		storage.bookSeats(choice);
	}
	
}

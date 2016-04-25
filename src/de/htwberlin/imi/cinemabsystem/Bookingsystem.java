/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.util.Scanner;
import java.util.ArrayList; // for casting @loading
import java.io.FileNotFoundException;
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

	IO_system bsh; // the IO_System (for user input and file reading/writing)	
	Storage storage;
	String loggedUser = "";
	Customer currentCustomer;

	public static void main(String[] args) {

		// creating new System and get it run
		final Bookingsystem system = new Bookingsystem();
		system.run();
	}

	public Bookingsystem() {
		this.bsh = new IO_system(); // Setting up the IO_system						
		storage = new Storage();
		
		loadData(); // load Data from files into Storage
		
		System.out.println("Starting System...");
	
		printWelcome();
	}

	public void run() {

		String command = "";
		while (!command.equals("quit")) {// termination command

			command = bsh.getInput(); // simply returns the user input as a
										// string

			switch (command) {// evaluating the commands
			case "help":

				storage.printHelpinformation();				
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
				
			case "logout":
				// user logout
				this.loggedUser = "";
				this.currentCustomer = null;
				System.out.println("Good bye!");
				
				
			case "register":
				// register new customer
				register();
				break;
				
			case "book":
				//book a show
				book();
				break;
				
			case "history":
				showHistory();
				break;
				

			
			case "reset":
				// reset the ssystem
				reset();
				break;

			default: // if the command is unknown
				System.out.println("This command is unknown.");
				System.out.println("type help to learn more.");
			}

		}

		System.out.println("Good bye");
		saveAll(); // save all data on disk!
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

	// FACTORY RESET THE WHOLE SYSTEM DATA
	private void reset() {
		System.out.println("==Factory Reset===");
		this.storage = new Storage();
		storage.resetData();
		System.out.println("Factory Reset was successfull.");
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

		if(loggedUser.equals("")){
			   Scanner input = new Scanner(System.in);
			   String username;
			   String pin;
			  
			   System.out.print("Username: ");
			   username = input.nextLine();
			   System.out.print("PIN: ");
			   pin = input.nextLine();
			   if(storage.findCustomer(username, pin) != null){
			    
			    loggedUser = username;
			    currentCustomer = storage.findCustomer(username, pin);
			    System.out.println("Welcome back " + currentCustomer.getFName() + " " + currentCustomer.getLName());
			   }
			  }
		else{
			System.out.println("You are already logged in.\n");
		}
	}
	
	// shows all bookings from currentCustomer
	private void showHistory(){
		
		if(loggedUser.equals("")){
			System.out.println("Please login first!");
		}
		else{
			System.out.println("You booked the following shows: ");
			if(currentCustomer.getBooking().tickets.isEmpty()){
				System.out.println("You don't have a booking history.");
			}
			else{
				for(int i = 0; i < currentCustomer.getBooking().tickets.size(); i++){
					String movie = currentCustomer.getBooking().tickets.get(i).getMovie().getTitle();
					Double starttime = currentCustomer.getBooking().tickets.get(i).getStartTime();
					System.out.println("Titel " + movie + " Date/Time " + starttime);
				}
			}
		}		
	}
	
	private void book(){
		if(loggedUser.equals("")) {
			System.out.println("Pls login first!");
			login();
		}
		else {
		storage.allMovies();
		System.out.println("To see more details about the movie of your choice \ntype the number in front of it.\n");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Your Choice: ");
		int movieNum = input.nextInt();
		storage.getSoC(movieNum);
		int choice = input.nextInt();
		
		this.currentCustomer = storage.bookSeats(choice, currentCustomer);
		}
	}
	
	/*
	 * Loads data from particular files to the Storage
	 * 
	 */
	public void loadData() {
		
		Object raw = null;
		try {
		raw = bsh.load("customers.bin");
		storage.setCustomersfromfile(raw);
		
		raw = bsh.load("movies.bin");
		storage.setMoviesfromfile(raw);
		 
		raw = bsh.load("shows.bin");
		storage.setShowsfromfile(raw);
		
		raw = bsh.load("theaters.bin");
		storage.setTheatersfromfile(raw);
		
		raw = bsh.load("help.bin");
		storage.setHelpfromfile(raw);
		
		System.out.println(" Loading Data was successful.");
	} catch (FileNotFoundException e) {
		System.out.println("Unable to find data \n Resetting Data...");
		reset();
	}
		

	}
	
	/*
	 * Saves data from the Storage to disk
	 */
	public void saveAll() {
		
		saveCustomers();
		saveMovies();
		saveShows();
		saveTheaters();
		saveHelp();
		System.out.println("All date saved sucessfully!");		
	}
	
	//
	
	public void saveCustomers() {
		ArrayList<Customer> savec;
		savec = storage.getCustomers();
		bsh.savecustomers(savec);
	}
	
	public void saveMovies() {
		ArrayList<Movie> savem;
		savem = storage.getMovies();
		bsh.savemovies(savem);
	}
	
	public void saveShows() {
		ArrayList<Show> saves;
		saves = storage.getShows();
		bsh.saveshows(saves);
	}
	
	public void saveTheaters() {
		ArrayList<Theater> savet;
		savet = storage.getTheaters();
		bsh.savetheaters(savet);
	}
	
	public void saveHelp() {
		ArrayList<HelpItem> saveh;
		saveh = storage.getHelpstorage();
		bsh.savehelp(saveh);
	}
}

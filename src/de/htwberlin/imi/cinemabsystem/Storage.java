/**
 * This class holds all the needed information about Movies, Theaters, Customers etc.
 */
package de.htwberlin.imi.cinemabsystem;

/**
 * @author Jannes Brunner, Katharina Wunder, Mario Schuetz
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Storage {

	Customer customer;

	ArrayList<Customer> customers;
	ArrayList<Movie> movies;
	ArrayList<Show> shows;
	ArrayList<Theater> theaters;
	ArrayList<HelpItem> helpstorage; // Holds help information

	public Storage() {

		customers = new ArrayList<Customer>(); // Holds information about the
												// registred users
		movies = new ArrayList<Movie>(); // Holds information about the shown
											// movies
		shows = new ArrayList<Show>(); // Holds information about the bookleable
										// shows
		theaters = new ArrayList<Theater>(); // Holds information about the
												// available theaters in the
												// cinema
		helpstorage = new ArrayList<HelpItem>(); // Setting up the storage for
													// help information

		// ONLY FOR DEMO SET UP
//		createMovies();
//		createTheaters();
//		createShows();
//		createHelpitems();
//		testCustomer();
		// ---------------

	}

	private void createHelpitems() {
		helpstorage.add(new HelpItem("quit", "To exit the program"));
		helpstorage.add(new HelpItem("test", "Just to test the Help system"));
		helpstorage.add(new HelpItem("program", "Prints out all available movies."));
		helpstorage.add(new HelpItem("login", "Login in to your account. Username and PIN needed."));
		helpstorage.add(new HelpItem("register", "If you are new to our service you can register here."));
		helpstorage.add(new HelpItem("book", "Book a Show"));
	}

	public void printHelpinformation() {

		for (HelpItem x : helpstorage) {
			System.out.println(x.getName() + " : " + x.getDescription());
		}
	}
	
	// Set Data to fields (from *.bin files)
		public void setCustomersfromfile(Object raw) {
			ArrayList<Customer> customers = (ArrayList<Customer>) raw;
			this.customers = customers;
		}
		public void setMoviesfromfile(Object raw) {
			ArrayList<Movie> movies = (ArrayList<Movie>) raw;
			this.movies = movies;
		}
		public void setShowsfromfile(Object raw) {
			ArrayList<Show> shows = (ArrayList<Show>) raw;
			this.shows = shows;
		}
		public void setTheatersfromfile(Object raw) {
			ArrayList<Theater> theaters = (ArrayList<Theater>) raw;
			this.theaters = theaters;
		}
		public void setHelpfromfile(Object raw) {
			
			ArrayList<HelpItem> helpstorage = (ArrayList<HelpItem>) raw;
			this.helpstorage = helpstorage;
		}
	// ----------------------------------------
		
		
	// Get Data (ArrayLists) from Storage.	
	
	/**
		 * @return the customers
		 */
		public ArrayList<Customer> getCustomers() {
			return customers;
		}

		/**
		 * @return the movies
		 */
		public ArrayList<Movie> getMovies() {
			return movies;
		}

		/**
		 * @return the shows
		 */
		public ArrayList<Show> getShows() {
			return shows;
		}

		/**
		 * @return the theaters
		 */
		public ArrayList<Theater> getTheaters() {
			return theaters;
		}

		/**
		 * @return the helpstorage
		 */
		public ArrayList<HelpItem> getHelpstorage() {
			return helpstorage;
		}

	// Creates a new Customer
	public void newCustomer(String username, String lname, String fname, String pin) {
		boolean found = false;
		Iterator<Customer> it = customers.iterator();

		while (!found && it.hasNext()) {
			Customer tempCustomer = it.next();
			String tempUn = tempCustomer.getUserName();
			if (tempUn.equals(username)) {
				found = true;
			}
		}
		if (!found) {
			customers.add(new Customer(username, lname, fname, pin));
			System.out.println("You got registered as " + fname + " " + lname);
			System.out.println("Your loginname will be: " + username);
			System.out.println("Enjoy our service.\n");
		} else {
			System.out.println("Username already taken please add a number.");
		}
	}

	

	// user login
	public boolean userLogin(String username, String pin) {
		boolean found = false;
		Iterator<Customer> it = customers.iterator();

		while (!found && it.hasNext()) {
			Customer tempCustomer = it.next();
			String tempUn = tempCustomer.getUserName();
			String userpin = tempCustomer.getPin();
			if (tempUn.equals(username) && userpin.equals(pin)) {
				System.out.println("Welcome back " + tempCustomer.getFName() + " " + tempCustomer.getLName());
				found = true;
			}
		}
		if (!found) {
			System.out.println("Not a registered username or wrong password.");
		}
		return found;
	}
	
	// Print out all movies
	public void allMovies() {
		int cnt = 1;
		for (Movie amovie : movies) {
			System.out.println(cnt + " " + amovie.getTitle() + "    \n Duration: " + amovie.getDuration() + "\n");
			cnt++;
		}
	}
	
	// Show of Choice. 
	public void getSoC(int choice) {

		String userchoice = shows.get(choice).getMovie().getTitle();
		String times = "Your movie starts at \n";

		for (Show show : shows) {

			String show2compare = show.getMovie().getTitle();

			if (userchoice.equals(show2compare)) {
				times += show.getTime() + "\n";
			}
		}
		System.out.println(times);
	}
	
		
	
	/*
	 * HERE BEGINS THE DEMO SETUP!
	 * Not necessary if you load from files.
	 */
	// default customers to load the customers arraylist
		public void testCustomer() {
			customers.add(new Customer("Jay", "Bee", "Jay", "1234"));
			customers.add(new Customer("Eli", "Gould", "Eli", "0815"));
			customers.add(new Customer("mayo", "Schuetz", "Mario", "1337"));
		}
	// create new movies with title, length in min and price in EUR
	public void createMovies() {

		movies.add(new Movie("Pulp Fiction", 154, 10.5));
		movies.add(new Movie("The Usual Suspect", 106, 10.5));
		movies.add(new Movie("Star Wars 4 - 6", 378, 33.33));
		movies.add(new Movie("Tenacious D in The Pick of Destiny", 90, 10.5));
	}
	// default Cinema Setup 
	public void createTheaters() {

		theaters.add(new Theater(1, 100));
		theaters.add(new Theater(2, 80));
		theaters.add(new Theater(3, 50));
		theaters.add(new Theater(4, 140));
	}
	
	// default Shows Setup
	public void createShows() {

		shows.add(new Show(movies.get(0), theaters.get(0), 12));
		shows.add(new Show(movies.get(1), theaters.get(1), 12));
		shows.add(new Show(movies.get(2), theaters.get(2), 14));
		shows.add(new Show(movies.get(3), theaters.get(3), 12));
		shows.add(new Show(movies.get(3), theaters.get(3), 16));
	}

	
}

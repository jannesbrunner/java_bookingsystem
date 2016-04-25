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
import java.util.Scanner;

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

		

	}
	
	// Reset the whole system.
	// ALL DATA WILL BE LOST!
	public void resetData() {
		movies.clear();
		createMovies();
		theaters.clear();
		 createTheaters();
		 shows.clear();
		 createShows();
		 helpstorage.clear();
		 createHelpitems();
		 customers.clear();
		 testCustomer();
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

	public Customer findCustomer(String username, String pin) {
		Customer foundCustomer = null;
		Iterator<Customer> it = customers.iterator();

		while (foundCustomer == null && it.hasNext()) {
			Customer tempCustomer = it.next();
			String tempUn = tempCustomer.getUserName();
			String userpin = tempCustomer.getPin();
			if (tempUn.equals(username) && userpin.equals(pin)) {
				
				foundCustomer = tempCustomer;
			}
		}
		if (foundCustomer == null) {
			System.out.println("Not a registered username or wrong password.");
		}
		return foundCustomer;
	}

	// Print out all movies
	public void allMovies() {
		int cnt = 1;
		for (Movie amovie : movies) {
			System.out.println(cnt + " " + amovie.getTitle() + "    \n Duration: " + amovie.getDuration() + "\n");
			cnt++;
		}
	}

	// get Show of Choice
	public void getSoC(int choice) {

		if (choice < shows.size()) {
			String userchoice = shows.get(choice).getMovie().getTitle();
			String times = "The selected movie screens at \n";
			int cnt = 0;

			for (Show show : shows) {

				String show2compare = show.getMovie().getTitle();

				if (userchoice.equals(show2compare)) {
					cnt++;
					times += "Option #" + cnt + ": " + show.getTime() + "0\n";
				}
			}
			if (cnt != 0) {
				System.out.println(times);
			}
		} else {
			System.out.println("Not a valid choice.");
		}
	}

	// get Time of Choice
	public Customer bookSeats(int choice, Customer customer) {
		Ticket bookedticket = null; // Holds later the booked ticket
		Booking userbooking = null; 
		
		if (choice < shows.size()) {

			Show chosenOne = shows.get(choice);
			System.out.println("These are the available seats for " + chosenOne.getMovie().getTitle() + "\n");
			chosenOne.showSeating();
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.println("How many seats would you like to book? ");
			int seats = input.nextInt();

			if (seats == 1) {

				Scanner inputSeat = new Scanner(System.in);
				System.out.println(
						"Which seat would you like to book?\nPlease state a seat and row number like shown above.");
				String seatToBook = inputSeat.next();
				char temprow = seatToBook.charAt(seatToBook.length() - 1);
				int tempseat = Integer.valueOf(seatToBook.substring(0, seatToBook.length() - 1));
				chosenOne.bookSeat(temprow,	tempseat);
				System.out.println("You booked seat " + tempseat + temprow + ".");
				//Creating ticket
				bookedticket = new Ticket(001, chosenOne.getMovie(), chosenOne.getTime(), chosenOne.getTheater(), chosenOne.getSeat(temprow, tempseat));
				userbooking = customer.getBooking();
				userbooking.addTicket(bookedticket);
				customer.setBooking(userbooking);
				return customer;
				

			} else if (seats >= 2) {

				inLine(seats);
				return customer;

			}

		} else {
			System.out.println("Not a valid choice.");
			return customer;
		}
		return customer;
	}
	
	// Checks if seats in row or not
	public int inLine(int seatQuantity) {
		int inLine;

		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to choose " + seatQuantity + " seats in a row (1) or separated (2)? ");
		inLine = input.nextInt();

		return inLine;
	}
	
	// HIER ELI HIER
	public void bookSeat() {

	}

	// public void setCustomer(Customer loggedCustomer){
	// this.loggedCustomer = loggedCustomer;
	//
	// }

	
	/*
	 * HERE BEGINS THE DEMO SETUP! Not necessary if you load from files.
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
	// create Help Items
	private void createHelpitems() {
		helpstorage.add(new HelpItem("quit", "To exit the program"));
		helpstorage.add(new HelpItem("test", "Just to test the Help system"));
		helpstorage.add(new HelpItem("program", "Prints out all available movies."));
		helpstorage.add(new HelpItem("login", "Login in to your account. Username and PIN needed."));
		helpstorage.add(new HelpItem("register", "If you are new to our service you can register here."));
		helpstorage.add(new HelpItem("book", "Book a Show"));
	}

}

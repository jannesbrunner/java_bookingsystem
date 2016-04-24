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
	
	public Storage(){
		
		createMovies();
		createCustomers();
		createTheaters();
		testCustomer();
		createShows();
		
		
	}

	public void createCustomers(){		
		customers = new ArrayList<Customer>();		
	}
	
	public void newCustomer(String username, String lname, String fname, String pin){
		boolean found = false;
		Iterator<Customer> it = customers.iterator();
			
			while(!found && it.hasNext()){
				Customer tempCustomer = it.next();
				String tempUn = tempCustomer.getUserName();
				if(tempUn.equals(username)){
					found = true;
				}
			}
			if(!found){		
				customers.add(new Customer(username, lname, fname, pin));				
				System.out.println("You got registered as " + fname + " " + lname);
				System.out.println("Your loginname will be: " + username);
				System.out.println("Enjoy our service.\n");
			}
			else{
				System.out.println("Username already taken please add a number.");
			}
		}
	
	// default customers to load the customers arraylist
	public void testCustomer(){
		customers.add(new Customer("Jay", "Bee", "Jay", "1234"));
		customers.add(new Customer("Eli", "Gould", "Eli", "0815"));
		customers.add(new Customer("mayo", "Schuetz", "Mario", "1337"));		
	}
	
	// user login
	public boolean userLogin(String username, String pin){
		boolean found = false;
		Iterator<Customer> it = customers.iterator();
			
			while(!found && it.hasNext()){
				Customer tempCustomer = it.next();
				String tempUn = tempCustomer.getUserName();
				String userpin =  tempCustomer.getPin();
				if(tempUn.equals(username) && userpin.equals(pin)){
					System.out.println("Welcome back " + tempCustomer.getFName() + " " + tempCustomer.getLName());
					found = true;
				}
			}
			if(!found){
				System.out.println("Not a registered username or wrong password.");
			}
			return found;
	}
	
	// create new movies with title, length in min and price in EUR
	public void createMovies(){
		
		movies = new ArrayList<Movie>();
		movies.add(new Movie("Pulp Fiction", 154, 10.5));
		movies.add(new Movie("The Usual Suspect", 106, 10.5));
		movies.add(new Movie("Star Wars 4 - 6", 378, 33.33));
		movies.add(new Movie("Tenacious D in The Pick of Destiny", 90, 10.5));
	}
	
	
	public void allMovies(){
		int cnt = 1;
		for(Movie amovie : movies){
			System.out.println(cnt + " " + amovie.getTitle() + "    \n Duration: " + amovie.getDuration() + "\n");
			cnt++;
		}
	}
	
	public void createTheaters(){
		
		theaters = new ArrayList<Theater>();		
		theaters.add(new Theater(1, 100));		
		theaters.add(new Theater(2, 80));		
		theaters.add(new Theater(3, 50));		
		theaters.add(new Theater(4, 140));
	}
	
	/**
	 * 
	 */
	public void createShows(){
		
		shows = new ArrayList<Show>();
		shows.add(new Show(movies.get(0), theaters.get(0), 12 ));
		shows.add(new Show(movies.get(1), theaters.get(1), 12 ));
		shows.add(new Show(movies.get(2), theaters.get(2), 14 ));
		shows.add(new Show(movies.get(3), theaters.get(3), 12 ));
		shows.add(new Show(movies.get(3), theaters.get(3), 16 ));			
	}
	
	// get Show of Choice
	public void getSoC(int choice){
		
		if(choice < shows.size()){		
			String userchoice = shows.get(choice).getMovie().getTitle();
			String times = "The selected movie screens at \n";
			int cnt = 0;
	
			for(Show show : shows){
			
				String show2compare = show.getMovie().getTitle();
			
				if(userchoice.equals(show2compare)){
					cnt++;
					times += "Option #" + cnt + ": " + show.getTime() + "0\n";
				}
			}
			if(cnt != 0){
				System.out.println(times);
			}
		}
		else{
			System.out.println("Not a valid choice.");			
		}
	}
	
	// get Time of Choice
	public void bookSeats(int choice){
				
		if(choice < shows.size()){
			
			Show chosenOne = shows.get(choice);
			System.out.println("These are the available seats for " + chosenOne.getMovie().getTitle() + "\n");
			chosenOne.showSeating();
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.println("How many seats would you like to book? ");
			int seats = input.nextInt();

			if(seats == 1){
				
				Scanner inputSeat = new Scanner(System.in);
				System.out.println("Which seat would you like to book?\nPlease state a seat and row number like shown above.");
				String seatToBook = inputSeat.next();
				
				chosenOne.bookSeat(seatToBook.charAt(seatToBook.length() - 1), Integer.valueOf(seatToBook.substring(0,seatToBook.length() - 1)));
				System.out.println("You booked seat " + seatToBook.charAt(seatToBook.length() - 1) + Integer.valueOf(seatToBook.substring(0,seatToBook.length() - 1)) + ".");
				
				
				
			}
			else if(seats >= 2){
				
				inLine(seats);
			}
		
		}
		else{
			System.out.println("Not a valid choice.");
		}
			
	}
	
	public int inLine(int seatQuantity){
		int inLine;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to choose " + seatQuantity + " seats in a row (1) or separated (2)? ");
		inLine = input.nextInt();
	
		return inLine;
	}
	
	public void bookSeat(){
		
		
	}
}

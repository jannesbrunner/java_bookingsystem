/**
 * This class holds all the needed information about Movies, Theaters, Customers etc.
 */
package de.htwberlin.imi.cinemabsystem;

/**
 * @author Jannes Brunner, Katharina Wunder, Mario Schuetz
 *
 */

import java.util.ArrayList;

public class Database {
	
	Customer customer;
	ArrayList<Customer> customers;
	ArrayList<Movie> movies;
	
	public Database(){
		
		createMovies();
		createCustomers();
		testCustomer();
		
	}

	public void createCustomers(){		
		customers = new ArrayList<Customer>();
		
	}
	
	public void newCustomer(String lname, String fname, String pin){
		
		customers.add(new Customer(lname, fname, pin));
	}
	
	// default customers to load the customers arraylist
	public void testCustomer(){
		customers.add(new Customer("Bee", "Jay", "1234"));
		customers.add(new Customer("Gould", "Eli", "0815"));
		customers.add(new Customer("Schuetz", "Mario", "1337"));		
	}
	
	public void createMovies(){
		
		// create new movies with title, length in min and price in EUR
		movies = new ArrayList<Movie>();
		movies.add(new Movie("Pulp Fiction", 154, 10.5));
		movies.add(new Movie("The Usual Suspect", 106, 10.5));
		movies.add(new Movie("Star Wars 4 - 6", 378, 33.33));
		movies.add(new Movie("Tenacious D in The Pick of Destiny", 90, 10.5));
	}
	
	public void userLogin(String username, String pin){
		
		// login existing user
		
	}
	
	public void allMovies(){
		int cnt = 1;
		for(Movie amovie : movies){
			System.out.println(cnt + " " + amovie.getTitle() + "    \n Duration: " + amovie.getDuration() + "\n");
			cnt++;
		}
		System.out.println("To see more details about the movie of your choice \ntype the number of in front of it.\n");

	}
}

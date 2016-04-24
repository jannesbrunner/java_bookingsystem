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
		System.out.println("To see more details about the movie of your choice \ntype the number in front of it.\n");
	}
}

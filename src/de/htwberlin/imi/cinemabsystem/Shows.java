package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Shows {
	
	Movie movie;
	Theater theater;
	ArrayList<Movie> movies;
	ArrayList<Theater> theaters;
//	ArrayList<Seat> seats;
	
	public Shows(){
		
		createMovies();
		createTheaters();
//		createSeats();
		
		availableMovies();
		
	}
	
	public void createMovies(){
		
		// create new movies with title, length in min and price in EUR
		movies = new ArrayList<Movie>();
		movies.add(new Movie("Pulp Fiction", 154, 10.5));
		movies.add(new Movie("The Usual Suspect", 106, 10.5));
		movies.add(new Movie("Star Wars 4 - 6", 378, 33.33));
		movies.add(new Movie("Tenacious D in The Pick of Destiny", 90, 10.5));
	}
	
	public void createTheaters(){
		
		// create new showrooms with rows and seats
		theaters = new ArrayList<Theater>();
		theaters.add(new Theater(14, 80));
		theaters.add(new Theater(20, 120));
		theaters.add(new Theater(10, 55));
		theaters.add(new Theater(30, 150));
	}

//	public void createSeats(){
//		
//		// create seats in showrooms with seat# and boolean booked
//			int seatsInTheater = theater.getSeats();		
//			seats = new ArrayList<Seat>();		
//		
//			for(int i = 0; i < seatsInTheater; i++){
//				seats.add(new Seat(i+1, false));
//			}
//	}
	
	public String availableMovies(){
		String availableMovies = "";
		
		Iterator it = movies.iterator();
		int i =1;
		
		while(it.hasNext()){
			availableMovies += i + " " + it.next() + "\n \n";
			i++;
		}
		
		System.out.println("To see more details about the movie of your choice \ntype the number of in front of it.");
		return availableMovies;
	}
}

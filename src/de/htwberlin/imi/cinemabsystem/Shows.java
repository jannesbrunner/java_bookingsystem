package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;

public class Shows {
	
	Movie movie;
	Theater theater;
	
	public Shows(){
		
		createMovies();
		createTheaters();
		createSeats();
		
	}
	
	public void createMovies(){
		
		// create new movies with title and price
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Pulp Fiction", 154, 10.5));
		movies.add(new Movie("The Usual Suspect", 106, 10.5));
		movies.add(new Movie("Star Wars 4 - 6", 378, 33.33));
		movies.add(new Movie("Tenacious D in The Pick of Destiny", 90, 10.5));
		
		System.out.println(movies + "\n");
			
	}
	
	public void createTheaters(){
		
		// create new showrooms with rows and seats
		ArrayList<Theater> theaters = new ArrayList<Theater>();
		theaters.add(new Theater(14, 80));
		theaters.add(new Theater(20, 120));
		theaters.add(new Theater(10, 55));
		theaters.add(new Theater(30, 150));
		
		System.out.println(theaters + "\n");
	}

	public void createSeats(){
		
		// create seats in showrooms with seat# and boolean booked
			int seatsInTheater = theater.getSeats();		
			ArrayList<Seat> seats = new ArrayList<Seat>();		
		
			for(int i = 0; i < seatsInTheater; i++){
				seats.add(new Seat(i+1, false));
			}
	}	
}

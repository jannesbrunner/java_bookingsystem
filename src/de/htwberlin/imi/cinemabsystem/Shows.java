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
		movies.add(new Movie("Pulp Fiction", 10));
		movies.add(new Movie("The Usual Suspect", 10));
		movies.add(new Movie("Star Wars", 14));
		movies.add(new Movie("The Pick of Destiny", 10));
		
		//initialise movie showtimes date (dd/mm/yyyy) and time (hh:mm)
		Movie actualMovie = movies.get(0);
		actualMovie.setShowTimes("24/04/2016", "18:00");
		
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

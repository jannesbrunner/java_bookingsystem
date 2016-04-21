package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;

public class Shows {
	
	Movie movie;
	Theater theater;
	//Seat seat;
	
	public Shows(){
		
		createMovies();
		createTheaters();
		createSeats();
		
	}
	
	public void createMovies(){
		
		// create new movies with title and price
		Movie movie1, movie2, movie3, movie4;
		movie1 = new Movie("Pulp Fiction", 10);
		movie2 = new Movie("The Usual Suspect", 10);
		movie3 = new Movie("Star Wars", 14);
		movie4 = new Movie("The Pick of Destiny", 10);
			
	}
	
	public void createTheaters(){
		
		// create new showrooms with rows and seats
		Theater theater1, theater2, theater3, theater4;
		theater1 = new Theater(14, 80);
		theater2 = new Theater(20, 120);
		theater3 = new Theater(10, 55);
		theater4 = new Theater(30, 150);
	}

	public void createSeats(){
		
		// create seats in showrooms with seat# and boolean booked
		int seatsInTheater = theater.getSeats();
		
		ArrayList<Seat> seats = new ArrayList<Seat>();
		
		for(int i = 0; i < seatsInTheater; i++){
			Seat seat = new Seat(i+1, false);
			seats.add(seat);
		}
		
	}	
}

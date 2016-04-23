package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Shows {
	
	Movie movie;
	Theater theater;

	
	public Shows(Movie movie, Theater theater, double date){
		seating(theater);
	}
	
	
	
	public void seating(Theater theater){
		int seatsPerRow = 20;
		int seatNumber = theater.getSeats();;
		int overflowSeats = seatNumber%seatsPerRow;
		int noOverflowSeats = (seatNumber - overflowSeats)/20;
		int rows = noOverflowSeats+1;
		
		//System.out.println(seatsPerRow);
		//System.out.println(seatNumber);
		//System.out.println(overflow);
		//System.out.println(noOverflowSeats);
		//System.out.println(rows);
		
		
				
		Seat[][] room = new Seat[rows][];
		
		for (int i = 0; i < rows; i++){
		room[i] = new Seat [20];
		}
		if (overflowSeats != 0) {
		room[rows-1] = new Seat [overflowSeats];
		}
		
		for (Seat[] arr : room) {
            System.out.println(Arrays.toString(arr));
        }
	}
}

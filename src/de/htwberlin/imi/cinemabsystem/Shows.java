package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Shows {
	
	Movie movie;
	Theater theater;

	public static void main(String[] args) {
		Theater test = new Theater(200);
		seating(test);

	}
	public Shows(Movie movie, Theater theater, double date){
		seating(theater);
	}
	
	
	
	public static void seating(Theater theater){
		int seatsPerRow = 20;
		int seatNumber = theater.getSeats();;
		int overflowSeats = seatNumber%seatsPerRow;
		int noOverflowSeats = (seatNumber - overflowSeats)/20;
		int rows = noOverflowSeats+1;
		
		Seat[][] room = new Seat[rows][];
		
		for (int i = 0; i < rows; i++){
		room[i] = new Seat [20];
		}
		if (overflowSeats != 0) {
		room[rows-1] = new Seat [overflowSeats];
		}
		
		char r = 'A';
		for (int y = 0; y <= room.length-1; y++ , r++){
			for (int x = 0; x <= room[y].length-1; x++){
				room[y][x] = new Seat (r, x+1, false);
			}
		}
		
		for (int y = 0; y <= room.length-1; y++){
			for (int x = 0; x <= room[y].length-1; x++){
				Seat currentSeat = room[y][x];
				
				if (currentSeat.getSeatNum() == 14){
					currentSeat.book();
				}
				String seatBooked = "[ ]";
				if (currentSeat.isBooked()){
					seatBooked = "[X]";
				}
				
			}
		}
	
		for (int y = 0; y <= room.length-1; y++){
			for (int x = 0; x <= room[y].length-1; x++){
				Seat currentSeat = room[y][x];
				String seatBooked = "[ ]";
				if (currentSeat.isBooked()){
					seatBooked = "[X]";
				}
				System.out.print("" + currentSeat.getSeatNum() + currentSeat.getRow() + seatBooked + " ");
				
			}
			System.out.println("");
		}
	}
}

package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Show {
	
	static Movie movie;
	static Theater test = new Theater(50);
	static int seatsPerRow = 10;
	static int seatNumber = test.getSeats();;
	static int overflowSeats = seatNumber%seatsPerRow;
	static int noOverflowSeats = (seatNumber - overflowSeats)/seatsPerRow;
	static int rows = noOverflowSeats+1;
	static char r = 'A';

	
	static Seat[][] room = new Seat[rows][];
	

	public static void main(String[] args) {
		createSeating(test);
		showSeating();
		bookSeat('E', 6);
		bookSeat('F', 6);
		unbookSeat('F', 6);
		//showSeating();
		

	}
	public Show(Movie movie, Theater theater, double time){
		createSeating(theater);
		
		
	}
	
	
	
	public static void createSeating(Theater theater){
		
		for (int i = 0; i < rows; i++){
		room[i] = new Seat [seatsPerRow];
		}
		if (overflowSeats != 0) {
		room[rows-1] = new Seat [overflowSeats];
		}
		
		for (int y = 0; y <= room.length-1; y++ , r++){
			for (int x = 0; x <= room[y].length-1; x++){
				room[y][x] = new Seat (r, x+1, false);
			}
		}
		
		for (int y = 0; y <= room.length-1; y++){
			for (int x = 0; x <= room[y].length-1; x++){
				Seat currentSeat = room[y][x];
				
				if (currentSeat.getSeatNum() == 10 && currentSeat.getRow() == 'K'){
					currentSeat.book();
				}
				String seatBooked = "[ ]";
				if (currentSeat.isBooked()){
					seatBooked = "[X]";
				}
				
			}
		}
	
		}
	
	public static void showSeating(){
		
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
	
	public static void bookSeat(char row, int seat){
		
		if (seat > seatsPerRow || seat > r){
			System.out.println("Invalid seat number. Please try again.");
		}
		
		
		for (int y = 0; y <= room.length-1; y++){
			for (int x = 0; x <= room[y].length-1; x++){
				Seat currentSeat = room[y][x];
				
				if (currentSeat.getSeatNum() == seat && currentSeat.getRow() == row){
					if (currentSeat.isBooked()){
						System.out.println("This seat is already taken. Please select another seat.");
					}
					else {
						currentSeat.book();
					}
				}
				
				
			}
		}
	}
		
	public static void unbookSeat(char row, int seat){
		
		if (seat > seatsPerRow || seat > r){
			System.out.println("Invalid seat number. Please try again.");
		}
		
		
		for (int y = 0; y <= room.length-1; y++){
			for (int x = 0; x <= room[y].length-1; x++){
				Seat currentSeat = room[y][x];
				
				if (currentSeat.getSeatNum() == seat && currentSeat.getRow() == row){
					if (currentSeat.isBooked()){
						currentSeat.unbook();
					}
					else {
						System.out.println("This seat is unbooked.");
					}
				}
				
				
			}
		}
		
	}
}

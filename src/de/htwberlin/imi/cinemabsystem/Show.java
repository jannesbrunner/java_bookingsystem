package de.htwberlin.imi.cinemabsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Show implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Movie movie;
	private Theater theater;
	private double time;
	
	private int seatsPerRow;
	private int overflowSeats;
	private int noOverflowSeats;
	private int rows;
	private char r;

	
	public Seat[][] room;
	

	public static void main(String[] args) {
		
		//createSeating(test);
		//showSeating();

		//bookSeat('E', 6);
		//bookSeat('F', 6);
		//unbookSeat('F', 6);
		//showSeating();
		
	}
	public Show(Movie movie, Theater theater, double time){
		
		this.movie = movie;
		this.theater = theater;
		this.time = time;
		
		seatsPerRow = 20;
		overflowSeats = theater.getSeats()%seatsPerRow;
		noOverflowSeats = (theater.getSeats() - overflowSeats)/seatsPerRow;
		rows = noOverflowSeats+1;
		r = 'A';
		
		room = new Seat[rows][];
		
		createSeating(theater);
		
	}
	
	public Movie getMovie(){
		return movie;
	}
	
	public Theater getTheater(){
		return theater;
	}
	
	public double getTime(){
		return time;
	}
	public void createSeating(Theater theater){
		
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
	
	public void showSeating(){
		
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
	
	public void bookSeat(char row, int seat){
		
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
		
	public void unbookSeat(char row, int seat){
		
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

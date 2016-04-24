package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Show {
	
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
		
		seatsPerRow = 10;
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
			return;
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
			return;
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

	public void bookRow (int seatFrom, char rowFrom, int seatTo, char rowTo){
		
		if (seatFrom > seatsPerRow || rowFrom > r || seatTo > seatsPerRow || rowTo > r){
			System.out.println("Invalid seat number. Please try again.");
			return;
		}
		
		boolean nowBooking = false;
		
		for (int y = 0; y <= room.length-1; y++){
			for (int x = 0; x <= room[y].length-1; x++){
				Seat currentSeat = room[y][x];
				
				if (!nowBooking && (currentSeat.getSeatNum() == seatFrom && currentSeat.getRow() == rowFrom || currentSeat.getSeatNum() == seatTo && currentSeat.getRow() == rowTo)){
					if (!currentSeat.isBooked()){
						
						currentSeat.book();
						nowBooking = true;
						
					}
					
					else {
						System.out.println("Seat " + currentSeat.getSeatNum()  + currentSeat.getRow() + " is aready booked. Please try othere seats");
						return; 
					}
				}
				else if (nowBooking){
					if (!currentSeat.isBooked()){
						
						currentSeat.book();
					
					}
				}
					
				else if (nowBooking && (currentSeat.getSeatNum() == seatFrom && currentSeat.getRow() == rowFrom || currentSeat.getSeatNum() == seatTo && currentSeat.getRow() == rowTo)){
					if (!currentSeat.isBooked()){
						
						currentSeat.book();
						return;
						
					}
					
					else {
						System.out.println("Seat " + currentSeat.getSeatNum()  + currentSeat.getRow() + " is aready booked. Please try othere seats");
						return; 
					}
					
					
				}
				
				
			}
		}	
	}
	
	
}

package de.htwberlin.imi.cinemabsystem;

public class Seat {

	int seatNum;
	boolean booked;
	private String row;
	
	public Seat(char row, int seatNum, boolean booked){
		this.seatNum = seatNum;
		this.booked = booked;
		this.row = row;
	}
	
	public int getSeatNum(){
		return seatNum;
	}
	
	public String getRow(){
		return row;
	}
	
	public boolean isBooked(){
		return booked;
	}
	
	public void book(){
		if(!booked){
			booked = true;
			System.out.println("Seat booked.");
		}
		else
			System.out.println("Seat is already booked");
	}
	
	public void unbook(){
		if(booked){
			booked = false;
			System.out.println("Reservation deleted");
		}
		else
			System.out.println("Seat is not booked.");
	}
	
}

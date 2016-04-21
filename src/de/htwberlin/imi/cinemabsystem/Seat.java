package de.htwberlin.imi.cinemabsystem;

public class Seat {

	int seatNum;
	boolean booked;
	
	public Seat(int seatNum, boolean booked){
		this.seatNum = seatNum;
		this.booked = booked;
	}
	
	public int getSeatNum(){
		return seatNum;
	}
	
	public boolean getBooked(){
		return booked;
	}
	
	public void setBooked(){
		if(!booked){
			booked = true;
			System.out.println("Seat booked.");
		}
		else
			System.out.println("Seat is already booked");
	}
	
	public void setUnbooked(){
		if(booked){
			booked = false;
			System.out.println("Reservation deleted");
		}
		else
			System.out.println("Seat is not booked.");
	}
	
}

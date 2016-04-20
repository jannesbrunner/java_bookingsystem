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
		if(booked){
			booked = false;
		}
		else{
			booked = true;
		}		
	}
}

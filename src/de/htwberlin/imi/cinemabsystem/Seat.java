package de.htwberlin.imi.cinemabsystem;

public class Seat {

	private int seatNum;
	private boolean booked;
	private char row;
	
	public Seat(char row, int seatNum, boolean booked){
		this.seatNum = seatNum;
		this.booked = booked;
		this.row = row;
	}
	
	public int getSeatNum(){
		return seatNum;
	}
	
	public char getRow(){
		return row;
	}
	
	public boolean isBooked(){
		return booked;
	}
	
	public void book(){
		if(!booked){
			booked = true;
		}
		else
			System.out.println("Seat is already booked");
	}
	
	public void unbook(){
		if(booked){
			booked = false;
		}
		else
			System.out.println("Seat is not booked.");
	}
	
}

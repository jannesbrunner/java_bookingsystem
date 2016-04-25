package de.htwberlin.imi.cinemabsystem;

import java.io.Serializable;

public class Ticket implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Theater theater;
	private Movie movie;
	private Seat seat;
	private int ticketNum;
	private double startTime;
	
	public Ticket(int ticketNum, Movie movie, double startTime, Theater theater, Seat seat){
		this.ticketNum = ticketNum;
		this.startTime = startTime;
		this.movie = movie;
		this.theater = theater;
		this.seat = seat;
	}
	
	public int getTicketNum(){
		return ticketNum;
	}
	
	public void setTicketNum(){
		
	}
	
	public double getStartTime(){
		return startTime;
	}
	
	public void setStartTime(){
		
	}
	
	public Movie getMovie(){
		return movie;
	}
	
	public void setMovie(){
		
	}
	
	public Theater getTheater(){
		return theater;
	}
	
	public void setTheater(){
		
	}

	public Seat getSeat(){
		return seat;
	}
	
	public void setSeat(){
		
	}
}

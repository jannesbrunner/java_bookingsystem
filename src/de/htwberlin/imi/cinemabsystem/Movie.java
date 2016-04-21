package de.htwberlin.imi.cinemabsystem;

import java.util.Date;

public class Movie {
	
	private String title;
	private double price;
	private Date date;
	private Date time;
		
	public Movie(String title, double price){
		this.title = title;
		this.price = price;
		this.date = date;
		this.time = time;
	}
	
	public String getTitle(){
		return title;
	}
	
	public double getPrice(){
		return price;
	}
	
	public Date getDate(){
		return date;
	}
	
	public Date getTime(){
		return time;
	}
}

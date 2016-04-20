package de.htwberlin.imi.cinemabsystem;

public class Movie {
	
	private String title;
	private double price;
	private String date;
	private String time;
		
	public Movie(String title, double price, String date, String time){
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
	
	public String getDate(){
		return date;
	}
	
	public String getTime(){
		return time;
	}
}

package de.htwberlin.imi.cinemabsystem;

public class Movie {
	
	private String title;
	private double price;
	private int duration;
	
	public Movie(String title, int duration, double price){
		this.title = title;
		this.duration = duration;
		this.price = price;
	}
	
	public String getTitle(){
		return title;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getDuration(){
		return duration;
	}
}

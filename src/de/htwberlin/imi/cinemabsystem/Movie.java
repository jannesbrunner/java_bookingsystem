package de.htwberlin.imi.cinemabsystem;

public class Movie {
	
	private String title;
	private double price;
	private int length;
	
	public Movie(String title, int length, double price){
		this.title = title;
		this.length = length;
		this.price = price;
	}
	
	public String getTitle(){
		return title;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getLength(){
		return length;
	}
}

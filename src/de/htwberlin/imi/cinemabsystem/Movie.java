package de.htwberlin.imi.cinemabsystem;

import java.io.Serializable;

public class Movie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

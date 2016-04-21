package de.htwberlin.imi.cinemabsystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Movie {
	
	private String title;
	private double price;
	private String date;
	private String time;
	private HashMap<String, String> showTimes;
		
	public Movie(String title, double price){
		this.title = title;
		this.price = price;
		showTimes = new HashMap<String, String>();
		//this.date = date;
		//this.time = time;
	}
	
	public String getTitle(){
		return title;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setShowTime(){
		showTimes.put(date, time); //Format dd/mm/yyyy and hh:mm
	}
	
	public String getShowTimes(){
	        String requestedDate = "";
	        for(Iterator it = showTimes.keySet().iterator(); it.hasNext();){
	            requestedDate += (String) it.next() + " ";
	        }
	        return "Your Movie will be on air at " + requestedDate;
	}
}

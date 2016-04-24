/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;
import java.util.ArrayList;

import java.io.Serializable;
/**
 * @author Jannes Brunner, Katharina Wunder, Mario Schuetz
 *
 */
public class Customer implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String lname;
	private String fname;
	private String pin;
	
	ArrayList<Booking> bookings;

	public Customer(String username, String lname, String fname, String pin){
		this.username = username;
		this.lname = lname;
		this.fname = fname;
		this.pin = pin;
		bookings = new ArrayList<Booking>();
	}
	
	public String getUserName(){
		return username;
	}
	
	public void setUserName(){
		
	}
	
	public String getLName(){
		return lname;
	}
	
	public void setLName(){
		
	}
	
	public String getFName(){
		return fname;
	}
	public void setFName(){
		
	}
	
	public String getPin(){
		return pin;
	}
	
	public void setPin(){
		
	}
	
	public void addBooking(Booking bookingToAdd){
		bookings.add(bookingToAdd);
	}
	
	public void rmvBooking(Booking bookingToRvm){
		bookings.remove(bookingToRvm);
	}
}

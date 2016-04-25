/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;
import java.util.ArrayList;

/**
 * @author Jannes Brunner, Katharina Wunder, Mario Schuetz
 *
 */
public class Customer {
	
	private String username;
	private String lname;
	private String fname;
	private String pin;
	private Booking booking;
	

	public Customer(String username, String lname, String fname, String pin){
		this.username = username;
		this.lname = lname;
		this.fname = fname;
		this.pin = pin;
		booking = new Booking();
		// System.out.println("Booking angelegt");
	}
	
	public String getUserName(){
		return username;
	}
	
	public Booking getBooking() {
		return booking;
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
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	 
}

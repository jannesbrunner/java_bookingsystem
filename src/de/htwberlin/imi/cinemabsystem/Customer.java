/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

/**
 * @author Jannes Brunner, Katharina Wunder, Mario Schuetz
 *
 */
public class Customer {
	
	private String username;
	private String lname;
	private String fname;
	private String pin;

	public Customer(String username, String lname, String fname, String pin){
		this.username = username;
		this.lname = lname;
		this.fname = fname;
		this.pin = pin;
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
	
}

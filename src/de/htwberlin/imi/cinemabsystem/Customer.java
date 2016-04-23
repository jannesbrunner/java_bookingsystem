/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

/**
 * @author Jannes Brunner, Katharina Wunder, Mario Schuetz
 *
 */
public class Customer {
	
	private String lname;
	private String fname;
	private String pin;

	public Customer(String lname, String fname, String pin){
		this.lname = lname;
		this.fname = fname;
		this.pin = pin;
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

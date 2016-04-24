/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.io.Serializable;

/**
 * @author Mario Schuetz
 *
 */
public class Theater implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int seats;
	private int theaterNum;
	
	public Theater(int theaterNum, int seats){
		this.seats = seats;
		this.theaterNum = theaterNum;
	}
	
	public int getSeats(){
		return seats;
	}
	
	public int getTheaterNum(){
		return theaterNum;
	}
}


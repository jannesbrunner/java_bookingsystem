/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

/**
 * @author Mario Schuetz
 *
 */
public class Theater {
	
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


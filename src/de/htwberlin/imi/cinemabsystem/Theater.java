/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

/**
 * @author Mario Schuetz
 *
 */
public class Theater {
	
	int rows;
	int seats;
	
	public Theater(int rows, int seats){
		this.rows = rows;
		this.seats = seats;
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getSeats(){
		return seats;
	}
}


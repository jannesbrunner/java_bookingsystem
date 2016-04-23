package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;

public class Shows {
	
	Movie movie;
	Theater theater;
	ArrayList<Theater> theaters;
	
	public Shows(){
		createTheaters();		
	}	
	
	public void createTheaters(){
		
		// create new showrooms with rows and seats
		theaters = new ArrayList<Theater>();
		theaters.add(new Theater(14, 80));
		theaters.add(new Theater(20, 120));
		theaters.add(new Theater(10, 55));
		theaters.add(new Theater(30, 150));
	}

}

package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;

public class Shows {
	
	Movie movie;
	Theater theater;
	ArrayList<Theater> theaters;
	
	public Shows(){
		createTheaters();
		availableMovies();
		
	}
	
	
	
	public void createTheaters(){
		
		// create new showrooms with rows and seats
		theaters = new ArrayList<Theater>();
		theaters.add(new Theater(14, 80));
		theaters.add(new Theater(20, 120));
		theaters.add(new Theater(10, 55));
		theaters.add(new Theater(30, 150));
	}
	
	public void availableMovies(){
		int cnt = 1;
		for(Movie amovie : movies){
			System.out.println(cnt + " " + amovie.getTitle() + "    \n Duration: " + amovie.getDuration() + "\n");
			System.out.println("To see more details about the movie of your choice \ntype the number of in front of it.");
			cnt++;
		}

	}
}

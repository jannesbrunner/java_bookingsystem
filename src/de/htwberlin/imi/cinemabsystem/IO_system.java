/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;





/**
 * @author Jannes Brunner
 * 
 * The IO_system just reads out user data which gets typed by the user into the console.
 * It can also save and load Objects in/from files.
 * 
 *
 */
public class IO_system {

	private InputStreamReader isr;
	private BufferedReader br;

	public IO_system() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);

	}

	// USER CONSOLE INPUT
	public String getInput() // just return it as a String 
	{
		String usrdata = "";
		System.out.print(":> ");
		try {
			usrdata = input();
			return usrdata;
		} catch (IOException e) {
			System.err.println("IO Error");
			return usrdata;
		}
	}

	private String input() throws IOException {

		String input = br.readLine();
		return input;

	}
	
	public boolean checkForBins() {
		boolean bins;
		ArrayList<String> expectedBins = new ArrayList<String>();
		File f = new File(".");
		File[] fileArray = f.listFiles();
		System.out.println("Working dir is: "+f.getAbsolutePath());
		for (int i = 0; i < fileArray.length; i++) {
			String file = fileArray[i].toString();
			expectedBins.add(file);
		}
		Collections.sort(expectedBins);
		//  System.out.println(expectedBins.toString());
		System.out.println("Looking for nescessary files...");
		
		if(expectedBins.contains(".\\customers.bin") && expectedBins.contains(".\\help.bin") && expectedBins.contains(".\\movies.bin") && expectedBins.contains(".\\shows.bin") && expectedBins.contains(".\\theaters.bin")) 
		{ 
			bins = true;
			System.out.println("OK");
			return true;
			
		} else {
			bins = false;
			System.out.println("error");
			return bins;
		}
	}
	
	// SAVE AND READ OBJECT FILES
	// Note! All storable classes have to implement Serializable!
	
	/*
	 * Save method for the help system
	 */
	public void savehelp(ArrayList<HelpItem> save) {
			
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("help.bin"))) {

			out.writeObject(save);

			 // System.out.println("Serialization succeeded"); // for testing
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Serialization failed");
			System.out.println(e.getStackTrace());
		}
	}
	
	/*
	 * Save method for the costumers
	 */
	public void savecustomers(ArrayList<Customer> save) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customers.bin"))) {

			out.writeObject(save);

			 // System.out.println("Serialization succeeded"); // for testing
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Serialization failed");
			System.out.println(e.getStackTrace());
		}
	}
	
	/*
	 * Save method for the movies
	 */
	public void savemovies(ArrayList<Movie> save) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("movies.bin"))) {

			out.writeObject(save);

			 // System.out.println("Serialization succeeded"); // for testing
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Serialization failed");
			System.out.println(e.getStackTrace());
		}
	}
	
	/*
	 * Save method for the shows
	 */
	public void saveshows(ArrayList<Show> save) {
			
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("shows.bin"))) {

			out.writeObject(save);

			// System.out.println("Serialization succeeded"); // for testing
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Serialization failed");
			System.out.println(e.getStackTrace());
		}
	}
	
	/*
	 * Save method for the theaters
	 */
	public void savetheaters(ArrayList<Theater> save) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("theaters.bin"))) {

			out.writeObject(save);

			 // System.out.println("Serialization succeeded"); // for testing
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Serialization failed");
			System.out.println(e.getStackTrace());
		}
	}
	
	
	
	/*
	 * General Object from file loader.
	 * Note: You have to cast your object later.
	 */
	public Object load(String file) throws FileNotFoundException {
		// Remember: Your class must implement Serializable in order to get loaded successfully
		

		Object data = null;
		FileInputStream fis = null;
		System.out.println("Loading "+file);

		try {
			fis = new FileInputStream(file);
			ObjectInputStream o = new ObjectInputStream(fis);
			data = o.readObject();

			return data;

		} catch (IOException e) {
			System.err.println(e);
			return data;
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			return data;
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
	}
	
	

}

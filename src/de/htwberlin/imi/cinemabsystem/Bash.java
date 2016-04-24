/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.io.*;



/**
 * @author Jannes Brunner
 * 
 * The Bash just reads out user data which gets typed by the user into the console.
 * It can also save and load Objects in/from files.
 * 
 *
 */
public class Bash {

	private InputStreamReader isr;
	private BufferedReader br;

	public Bash() {
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
	
	// SAVE AND READ OBJECT FILES
	// Note! All saveable classes have to implement Serializable!
	public void savedata(Object save, String filename) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {

			out.writeObject(save);

			// System.out.println("Serialization succeeded"); // for testing
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Serialization failed");
			System.out.println(e.getStackTrace());
		}
	}
	
	private Object load(String file) {
		// Remember: Your class must implement Serializable in order to get loaded successfully
		

		Object data = null;
		FileInputStream fis = null;
		System.out.println("Loadin "+file);

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

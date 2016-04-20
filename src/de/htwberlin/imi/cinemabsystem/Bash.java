/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.io.*;

/**
 * @author Jannes Brunner
 * 
 * The Bash just reads out user data which gets typed by the user into the console.
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

}

/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList; // for the help storage

/**
 * @author Jannes Brunner, Mario Schuetz, Katharina Wunder
 *
 *         This is the main Class of the whole system. (Thus it includes the
 *         main method)
 */
public class Bookingsystem {

	/**
	 * @param args
	 *            Not in use yet
	 */

	Bash bsh; // the bash (for user input)
	ArrayList<HelpItem> helpstorage; // Holds help information
	Shows shows;

	public static void main(String[] args) {

		// creating new System and get it run
		Bookingsystem system = new Bookingsystem();
		system.run();

	}

	public Bookingsystem() {
		this.bsh = new Bash(); // Setting up the Bash
		this.helpstorage = new ArrayList<HelpItem>(); // Setting up the storage
														// for help information
		setHelpitems(); // add new commands with description in this method
		shows.createMovies();
	}

	public void run() {

		String command = "";
		while (!command.equals("quit")) {// termination command

			command = bsh.getInput(); // simply returns the user input as a
										// string

			switch (command) {// evaluating the commands
			case "help":

				for (HelpItem x : helpstorage) {
					System.out.println(x.getName() + " : " + x.getDescription());
				}

				break;

			case "quit":
				// nothing to do here yet.
				break;
				
			case "program":
				shows.availableMovies();
				break;

			default: // if the command is unknown
				System.out.println("This command is unknown.");
				System.out.println("type help to learn more.");
			}

		}

		System.out.println("Good bye");
	}

	private void setHelpitems() {
		helpstorage.add(new HelpItem("quit", "To exit the program"));
		helpstorage.add(new HelpItem("test", "Just to test the Help system"));

	}

	private class HelpItem {
		/**
		 * This is private Class / ADT for holding items for the help system.
		 */
		String name; // The name of the command
		String description; // The description of the command

		private HelpItem(String name, String description) {
			this.name = name;
			this.description = description;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

	}

}

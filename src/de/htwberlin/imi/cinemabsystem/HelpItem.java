/**
 * 
 */
package de.htwberlin.imi.cinemabsystem;

import java.io.Serializable;

/**
 * @author Jannes Brunner
 * Holds Help Information for a command
 *
 */
public class HelpItem implements Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * This is private Class / ADT for holding items for the help system.
		 */
		String name; // The name of the command
		String description; // The description of the command

		public HelpItem(String name, String description) {
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

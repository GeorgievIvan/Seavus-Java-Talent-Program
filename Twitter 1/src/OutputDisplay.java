import java.util.ArrayList;

/**
 * Used to display information on the standard output.
 * @author Ivan Georgiev
 *
 */
class OutputDisplay {
	
	/**
	 * Displays a menu for the user.
	 */
	public void displayMenu() {
		
		System.out.println("new message - Lets you enter a new message.");
		System.out.println("list messages - Lets you see the messages you have sent.");
		System.out.println("help - Lets you see this menu.");
		System.out.println("exit - Lets you exit the application.");
	}
	
	/**
	 * Displays the user's messages in descending order by date.
	 * @param messages The user's messages
	 */
	public void displayMessages(ArrayList<Message> messages) {
		
		System.out.println(String.format("You have sent %d messages\n", messages.size()));
		
		for(int i = messages.size() - 1; i >= 0; --i) {
				
			System.out.println(messages.get(i));
		}
	}
	
	/**
	 * Displays a {@link String String} to standard output stream.
	 * @param outputString The {@link String String} to be displayed.
	 */
	public void displayOutput(String outputString) {

		System.out.println(outputString);
	}
}

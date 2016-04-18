package twitter_application;

import java.util.ArrayList;

public class StandardOutputOutputDisplayer implements OutputDisplayer<String> {

	@Override
	public void displayMenu() {

		System.out.println("new message - Lets you enter a new message.");
		System.out.println("list messages - Lets you see the messages you have sent.");
		System.out.println("help - Lets you see this menu.");
		System.out.println("exit - Lets you exit the application.");
	}

	@Override
	public void displayMessages(ArrayList<Message> messages) {

		System.out.println(String.format("You have sent %d messages\n", messages.size()));

		for(Message message : messages) {
				
			System.out.println(String.format("%s\n", message));
		}
	}

	@Override
	public void displayOutput(String output) {

		System.out.println(output);
	}
}

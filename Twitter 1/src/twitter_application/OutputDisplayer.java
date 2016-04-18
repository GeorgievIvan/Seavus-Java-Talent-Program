package twitter_application;

import java.util.ArrayList;

public interface OutputDisplayer <T> {
	
	public void displayMenu();
	
	public void displayMessages(ArrayList<Message> messages);
	
	public void displayOutput(T output);
}

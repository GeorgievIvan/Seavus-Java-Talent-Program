package twitter_application;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class TwitterApplication {

	private static final String MESSAGES_FILE_PATH = "messages.txt";
	
	public static void main(String []args) throws ParseException, IOException {
		
		OutputDisplayer outputDisplayer = new StandardOutputOutputDisplayer();
		InputReader inputReader = new StandardInputInputReader();
		
		MessagePusher messagePusher = new FilleMessagePusher(MESSAGES_FILE_PATH);
		MessagePuller messagePuller = new FileMessagePuller(MESSAGES_FILE_PATH);
		
		outputDisplayer.displayMenu();
		
		boolean runAplication = true;
		
		while(runAplication) {
			
			StandardInputInputReader.UserInput userInput = (StandardInputInputReader.UserInput)inputReader.readInput();
			
			if(userInput.getMessage() != null) {
				
				try {
				
					messagePusher.pushMessage(userInput.getMessage());
				}
				catch(IOException ioException) {
					
					outputDisplayer.displayOutput(String.format("IOException while opening %s.", MESSAGES_FILE_PATH));
					
					throw ioException;
				}
				
				outputDisplayer.displayOutput("The message has been created.");
				
				continue;
			}
			
			switch(userInput.getInputCommand()) {
			
				case NEW_MESSAGE:
					outputDisplayer.displayOutput("Please enter your message:");
				break;
				
				case LIST_MESSAGES:
					ArrayList<Message> messageArrayList = null;
					
					try {
						
						messageArrayList = messagePuller.pullAllMessages();
					}
					catch(FileNotFoundException fileNotFoundException) {
						
						outputDisplayer.displayOutput(String.format("FileNotFoundException while opening %s.", MESSAGES_FILE_PATH));
						
						throw fileNotFoundException;
					}
					catch(IOException ioException) {
						
						outputDisplayer.displayOutput(String.format("IOException while working with %s.", MESSAGES_FILE_PATH));
						
						throw ioException;
					}
					catch(ParseException parseException) {
						
						outputDisplayer.displayOutput(String.format("%s is corrupt.", MESSAGES_FILE_PATH));
						
						throw parseException;
					}
					
					outputDisplayer.displayMessages(messageArrayList);
				break;
				
				case HELP:					
					outputDisplayer.displayMenu();
				break;
				
				case EXIT:
					runAplication = false;
				break;
				
				default:
					outputDisplayer.displayOutput("Invalid command.");
				break;
			}
		}
	}
}
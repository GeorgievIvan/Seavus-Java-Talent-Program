import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The main class for this exercise.
 * @author Ivan Georgiev
 *
 */
public class TwitterApplication {

	private static final String MESSAGES_FILE_PATH = "messages.txt";
	
	public static void main(String []args) throws NumberFormatException, IOException {
		
		OutputDisplay outputDisplay = new OutputDisplay();
		InputReader userInputReader = new InputReader();
		
		FileMessagePusher messagePusher = new FileMessagePusher(MESSAGES_FILE_PATH);
		FileMessagePuller messagePuller = new FileMessagePuller(MESSAGES_FILE_PATH);
		
		outputDisplay.displayMenu();
		
		boolean runAplication = true;
		
		while(runAplication) {
			
			UserInput userInput = userInputReader.readUserInput();
			
			if(userInput.getMessage() != null) {
				
				try {
				
					messagePusher.pushMessage(userInput.getMessage());
				}
				catch(IOException ioException) {
					
					outputDisplay.displayOutput(String.format("IOException while opening %s.", MESSAGES_FILE_PATH));
					
					throw ioException;
				}
				
				outputDisplay.displayOutput("The message has been created.");
				
				continue;
			}
			
			switch(userInput.getInputCommand()) {
			
				case NEW_MESSAGE:
					outputDisplay.displayOutput("Please enter your message:");
				break;
				
				case LIST_MESSAGES:
					ArrayList<Message> messageArrayList = null;
					
					try {
						
						messageArrayList = messagePuller.pullMessages();
					}
					catch(FileNotFoundException fileNotFoundException) {
						
						outputDisplay.displayOutput(String.format("FileNotFoundException while opening %s.", MESSAGES_FILE_PATH));
						
						throw fileNotFoundException;
					}
					catch(IOException ioException) {
						
						outputDisplay.displayOutput(String.format("IOException while working with %s.", MESSAGES_FILE_PATH));
						
						throw ioException;
					}
					catch(NumberFormatException numberFormatException) {
						
						outputDisplay.displayOutput(String.format("%s is corrupt.", MESSAGES_FILE_PATH));
						
						throw numberFormatException;
					}
					
					outputDisplay.displayMessages(messageArrayList);
				break;
				
				case HELP:					
					outputDisplay.displayMenu();
				break;
				
				case EXIT:
					runAplication = false;
				break;
				
				default:
					outputDisplay.displayOutput("Invalid command.");
				break;
			}
		}
	}
}
package twitter_application;

import java.util.Scanner;

public class StandardInputInputReader implements InputReader<StandardInputInputReader.UserInput> {

	enum StandardInputInputReaderState {
		
		WAITING_FOR_COMMAND, WAITING_FOR_MESSAGE
	}
	
	enum StandardInputInputReaderCommand {
		
		NEW_MESSAGE, LIST_MESSAGES, HELP, EXIT, INVALID_COMMAND
	}
	
	class UserInput {
		
		private final StandardInputInputReader.StandardInputInputReaderCommand inputCommand;
		private final Message message;

		public UserInput(final StandardInputInputReader.StandardInputInputReaderCommand inputCommand, final Message message) {
			
			this.inputCommand = inputCommand;
			
			this.message = message;
		}
		
		public StandardInputInputReader.StandardInputInputReaderCommand getInputCommand() {
			
			return inputCommand;
		}
		
		public Message getMessage() {
			
			return message;
		}
	}
	
	private StandardInputInputReaderState standardInputInputReaderState;
	private final Scanner scanner;
	
	public StandardInputInputReader() {

		standardInputInputReaderState = StandardInputInputReaderState.WAITING_FOR_COMMAND;
		
		scanner = new Scanner(System.in);
	}
	
	protected void finalize() {
		
		scanner.close();
	}
	
	@Override
	public StandardInputInputReader.UserInput readInput() {
		
		UserInput userInput = null;
		
		switch(standardInputInputReaderState) {
		
			case WAITING_FOR_COMMAND:
				userInput = readCommand();
			break;
			
			case WAITING_FOR_MESSAGE:
				userInput = readMessage();
			break;
		}
		
		return userInput;
	}
	
	private StandardInputInputReader.UserInput readCommand() {
		
		String userCommand = scanner.nextLine();
		
		UserInput userInput = null;
		
		switch(userCommand) {
		
			case "new message":
				
				standardInputInputReaderState = StandardInputInputReaderState.WAITING_FOR_MESSAGE;
				
				userInput = new UserInput(StandardInputInputReaderCommand.NEW_MESSAGE, null);
			break;
			
			case "list messages":
				
				userInput = new UserInput(StandardInputInputReaderCommand.LIST_MESSAGES, null);
			break;
			
			case "help":
				
				userInput = new UserInput(StandardInputInputReaderCommand.HELP, null);
			break;
			
			case "exit":
				
				userInput = new UserInput(StandardInputInputReaderCommand.EXIT, null);
			break;
			
			default:
				userInput = new UserInput(StandardInputInputReaderCommand.INVALID_COMMAND, null);
		}
		
		return userInput;
	}
	
	private StandardInputInputReader.UserInput readMessage() {
		
		standardInputInputReaderState = StandardInputInputReaderState.WAITING_FOR_COMMAND;
		
		String messageContent = scanner.nextLine();
		
		Message message = new Message(messageContent);
		
		UserInput userInput = new UserInput(null, message);
		
		return userInput;
	}
}


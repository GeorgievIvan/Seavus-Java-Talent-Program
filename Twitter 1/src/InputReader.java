import java.util.Scanner;

/**
 * Used to read the user's input.
 * @author Ivan Georgiev
 *
 */
class InputReader {
	
	/**
	 * Used to specify the state of the {@code InputReader}.
	 * <br>
	 * {@code WAITING_FOR_COMMAND} is the state when the {@code InputReader} is waiting for a command.
	 * <br>
	 * {@code WAITING_FOR_MESSAGE} is the state when the {@code InputReader} is waiting for a message.
	 * @author Ivan Georgiev
	 *
	 */
	enum InputReaderState {
		
		WAITING_FOR_COMMAND, WAITING_FOR_MESSAGE
	}
	
	/**
	 * Used to specify the commands that the user can enter.
	 * @author Ivan Georgiev
	 *
	 */
	enum InputCommand {
		
		NEW_MESSAGE, LIST_MESSAGES, HELP, EXIT, INVALID_COMMAND
	}
	
	/**
	 * The state that the {@code InputReader} is in.
	 */
	private InputReaderState inputReaderState;
	
	/**
	 * A connection to the standard input.
	 */
	private final Scanner scanner;
	
	
	/**
	 * Initializes the state of the {@code InputReader} and opens a connection to the standard input.
	 */
	public InputReader() {

		inputReaderState = InputReaderState.WAITING_FOR_COMMAND;
		
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Closes the connection to the standard input.
	 */
	protected void finalize() {
		
		scanner.close();
	}
	
	/**
	 * Used by {@link InputReader#readUserInput() readUserInput()} to read a command.
	 * @return The user's input.
	 */
	private UserInput readCommand() {
		
		String userCommand = scanner.nextLine();
		
		UserInput userInput = null;
		
		switch(userCommand) {
		
			case "new message":
				
				inputReaderState = InputReaderState.WAITING_FOR_MESSAGE;
				
				userInput = new UserInput(InputCommand.NEW_MESSAGE, null);
			break;
			
			case "list messages":
				
				userInput = new UserInput(InputCommand.LIST_MESSAGES, null);
			break;
			
			case "help":
				
				userInput = new UserInput(InputCommand.HELP, null);
			break;
			
			case "exit":
				
				userInput = new UserInput(InputCommand.EXIT, null);
			break;
			
			default:
				userInput = new UserInput(InputCommand.INVALID_COMMAND, null);
		}
		
		return userInput;
	}
	
	/**
	 * Used by {@link InputReader#readUserInput() readUserInput()} to read a message.
	 * @return The user's input.
	 */
	private UserInput readMessage() {
		
		inputReaderState = InputReaderState.WAITING_FOR_COMMAND;
		
		String messageContent = scanner.nextLine();
		
		Message message = new Message(messageContent);
		
		UserInput userInput = new UserInput(null, message);
		
		return userInput;
	}
	
	/**
	 * Reads the user input.
	 * <br>
	 * The {@link InputReader#readCommand() readCommand()} method is called when {@link InputReader#inputReaderState inputReaderState} equals {@code InputReaderState.WAITING_FOR_COMMAND}.
	 * <br>
	 * The {@link InputReader#readMessage() readMessage()} function is used when {@link InputReader#inputReaderState inputReaderState} equals {@code InputReaderState.WAITING_FOR_MESSAGE}.
	 * @return The user's input.
	 */
	public UserInput readUserInput() {
		
		UserInput userInput = null;
		
		switch(inputReaderState) {
		
			case WAITING_FOR_COMMAND:
				userInput = readCommand();
			break;
			
			case WAITING_FOR_MESSAGE:
				userInput = readMessage();
			break;
		}
		
		return userInput;
	}
}

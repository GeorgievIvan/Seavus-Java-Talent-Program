/**
 * Used to represent the user's input.
 * @author Ivan Georgiev
 *
 */
class UserInput {
	
	/**
	 * The command that the user entered.
	 */
	private final InputReader.InputCommand inputCommand;
	
	/**
	 * The message that the user entered.
	 */
	private final Message message;
	
	/**
	 * Initializes the command and message that the user entered.
	 * @param inputCommand The command that the user entered.
	 * @param message The message that the user entered.
	 */
	public UserInput(final InputReader.InputCommand inputCommand, final Message message) {
		
		this.inputCommand = inputCommand;
		
		this.message = message;
	}
	
	/**
	 * Returns the command that the user entered.
	 * @return The command that the user entered.
	 */
	public InputReader.InputCommand getInputCommand() {
		
		return inputCommand;
	}
	
	/**
	 * Returns the message that the user entered.
	 * @return The message that the user entered.
	 */
	public Message getMessage() {
		
		return message;
	}
}

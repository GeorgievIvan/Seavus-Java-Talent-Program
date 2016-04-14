import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Used to save the user's messages to a file.
 * @author Ivan Georgiev
 *
 */
class FileMessagePusher {

	/**
	 * The path to the file where the messages are stored.
	 */
	private final String outputFilePath;
	
	/**
	 * Initializes the path to the file where the messages are stored.
	 * @param outputFilePath The path to the file where the messages are stored.
	 */
	public FileMessagePusher(final String outputFilePath) {

		this.outputFilePath = outputFilePath;
	}

	/**
	 * Saves a user's message.
	 * @param message The user's message.
	 * @throws IOException Thrown if the file specified by {@link FileMessagePusher#outputFilePath outputFilePath} cannot be opened.
	 */
	public void pushMessage(final Message message) throws IOException {
		
		PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath, true)));
		
		printWriter.write(message.toString());
		
		printWriter.close();
	}
}

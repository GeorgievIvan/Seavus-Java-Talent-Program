package twitter_application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilleMessagePusher implements MessagePusher {

	private final String outputFilePath;
	
	public FilleMessagePusher(final String outputFilePath) {
		
		this.outputFilePath = outputFilePath;
	}
	
	@Override
	public void pushMessage(Message message) throws IOException {

		PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath, true)));
		
		printWriter.write(String.format("%s\r\n", message.toString()));
		
		printWriter.close();
	}
}

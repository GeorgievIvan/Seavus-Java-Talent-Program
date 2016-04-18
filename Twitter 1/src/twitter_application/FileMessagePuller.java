package twitter_application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileMessagePuller implements MessagePuller {
	
	private final String inputFilePath;
	
	public FileMessagePuller(final String inputFilePath) {
		
		this.inputFilePath = inputFilePath;
	}
	
	@Override
	public ArrayList<Message> pullAllMessages() throws FileNotFoundException, IOException, ParseException {

		final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
		
		final ArrayList<Message> messages = new ArrayList<Message>();
		
		while(true) {
			
			final String dateString = bufferedReader.readLine();
			final String content = bufferedReader.readLine();
			
			if(dateString == null) {
				
				break;
			}
			
			Message message = new Message(content, dateString);
			
			messages.add(message);
		}
		
		bufferedReader.close();
				
		Collections.sort(messages, new Comparator<Message>() {
			
	        @Override
	        public int compare(Message message2, Message message1)
	        {

	            return message1.getDate().compareTo(message2.getDate());
	        }
	    });
		
		return messages;
	}
}

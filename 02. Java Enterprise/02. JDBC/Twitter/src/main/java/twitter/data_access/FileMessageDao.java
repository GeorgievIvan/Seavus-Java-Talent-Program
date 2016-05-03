package twitter.data_access;

import twitter.business.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileMessageDao implements MessageDao {

	private final String filePath;
	
	public FileMessageDao(final String filePath) {
		
		this.filePath = filePath;
	}
	
	@Override
	public List<Message> readAllMessages(final boolean orderByDateDesc) {

		final File inputFile = new File(filePath);
		FileReader fileReader;
		
		try {
			
			fileReader = new FileReader(inputFile);
		}
		catch(final FileNotFoundException fileNotFoundException) {

			throw new RuntimeException(fileNotFoundException);
		}
		
		final BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		final ArrayList<Message> messages = new ArrayList<Message>();
		
		while(true) {
			
			String messageDateString = null;
			String messageText = null;
			
			try {
			
				messageDateString = bufferedReader.readLine();
				messageText = bufferedReader.readLine();
			}
			catch(final IOException ioException1) {
				
				try {
					
					bufferedReader.close();
				}
				catch(final IOException ioException2) {

					throw new RuntimeException(ioException2);
				}
				
				throw new RuntimeException(ioException1);
			}
			
			if(messageDateString == null) {
				
				break;
			}
			
			final Timestamp messageTimestamp = Timestamp.valueOf(messageDateString);
			
			final Message message = new Message(messageText, messageTimestamp);
			
			messages.add(message);
		}
		
		try {
			
			bufferedReader.close();
		}
		catch(final IOException ioException) {

			throw new RuntimeException(ioException);
		}
		
		if(orderByDateDesc) {
			
			Collections.sort(messages, new Comparator<Message>() {
				
		        @Override
		        public int compare(final Message message2, final Message message1) {
		        	
		            return  message1.getTimestamp().compareTo(message2.getTimestamp());
		        }
		    });
		}
		
		return messages;
	}
	
	@Override
	public void insertMessage(final Message message) throws RuntimeException {
	
		FileWriter fileWriter;
		
		try {
			
			fileWriter = new FileWriter(filePath, true);
		}
		catch (final IOException ioException) {
			
			throw new RuntimeException(ioException);
		}
		
		final PrintWriter printWriter = new PrintWriter(fileWriter);
		final BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
		
		try {
			
			bufferedWriter.write(message.getTimestamp().toString());
			bufferedWriter.newLine();
			bufferedWriter.write(message.getText());
			bufferedWriter.newLine();
		}
		catch(final IOException ioException) {
			
			throw new RuntimeException(ioException);
		}
		finally {
			
			try {
				
				bufferedWriter.close();
			}
			catch(final IOException ioException) {
				
				throw new RuntimeException(ioException);
			}
		}
	}
}

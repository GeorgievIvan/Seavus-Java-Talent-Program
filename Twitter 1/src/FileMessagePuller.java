import java.util.ArrayList;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Used to read the user's messages from the file where they are stored.
 * @author Ivan Georgiev
 *
 */
class FileMessagePuller {

	/**
	 * The path to the file where the user's messages are stored.
	 */
	private final String inputFilePath;
	
	/**
	 * Initializes the path to the file where the user's messages are stored.
	 * @param inputFilePath The path to the file where the user's messages are stored.
	 */
	public FileMessagePuller(final String inputFilePath) {
		
		this.inputFilePath = inputFilePath;
	}
	
	/**
	 * Returns the user's messages.
	 * @return The user's messages.
	 * @throws NumberFormatException Thrown if the file is corrupted.
	 * @throws FileNotFoundException Thrown if the file cannot be opened.
	 * @throws IOException Thrown if an {@link IOException IOException} occurs while reading the file or while closing the connection to the file.
	 */
	public ArrayList<Message> pullMessages() throws NumberFormatException, FileNotFoundException, IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
		
		ArrayList<Message> messages = new ArrayList<Message>();
		
		while(true) {
			
			String calendarString = bufferedReader.readLine();
			String messageContent = bufferedReader.readLine();
			
			if(calendarString == null) {
				
				break;
			}
			
			String []calendarStringFields = calendarString.split(" ");
			
			String []hourMinuteSecondsCalendarStringFields = calendarStringFields[0].split(":");
			String []dateMonthYearCalendarStringFields = calendarStringFields[1].split("-");
					
			final Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR, Integer.parseInt(hourMinuteSecondsCalendarStringFields[0]));
			calendar.set(Calendar.MINUTE, Integer.parseInt(hourMinuteSecondsCalendarStringFields[1]));
			calendar.set(Calendar.SECOND, Integer.parseInt(hourMinuteSecondsCalendarStringFields[2]));
			calendar.set(Calendar.DATE, Integer.parseInt(dateMonthYearCalendarStringFields[0]));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateMonthYearCalendarStringFields[1]) - 1);
			calendar.set(Calendar.YEAR, Integer.parseInt(dateMonthYearCalendarStringFields[2]));
			
			Message message = new Message(calendar, messageContent);
			
			messages.add(message);
		}
		
		bufferedReader.close();
				
		return messages;
	}
}

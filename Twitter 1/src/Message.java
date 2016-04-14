import java.util.Calendar;;

/**
 * Used to represent a user's message.
 * @author Ivan Georgiev
 *
 */
class Message {
	
	/**
	 * The time when the user posted the message.
	 */
	private final Calendar calendar;
	
	/**
	 * The content of the user's message.
	 */
	private final String content;
	
	/**
	 * Initializes the content of the message and initializes the time of the message to the current time.
	 * @param content The content of the message.
	 */
	public Message(final String content) {
		
		calendar = Calendar.getInstance();
		
		this.content = content;
	}
	
	/**
	 * Initializes the content and time of the message.
	 * @param calendar The time of the message.
	 * @param content The content of the message.
	 */
	public Message(final Calendar calendar, final String content) {
	
		this.calendar = calendar;
		
		this.content = content;
	}
	
	/**
	 * Returns the time when the message was posted.
	 * @return The time when the message was posted.
	 */
	public Calendar getCalendar() {
		
		return calendar;
	}
	
	/**
	 * Returns the content of the message.
	 * @return The content of the message.
	 */
	public String getContent() {
		
		return content;
	}
	
	@Override
	public String toString() {

		return String.format("%02d:%02d:%02d %02d-%02d-%s\r\n%s\r\n", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR), content);
	}
}

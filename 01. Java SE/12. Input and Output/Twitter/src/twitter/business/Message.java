package twitter.business;

import java.sql.Timestamp;
import java.util.Calendar;

public class Message {

	private final String text;
	private final Timestamp timestamp;
		
	public Message(final String text) {
		
		this.text = text;
		timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	public Message(final String text, final Timestamp timestamp) {
		
		this.text = text;
		this.timestamp = timestamp;
	}
		
	public String getText() {
		
		return text;
	}
	
	public Timestamp getTimestamp() {
		
		return timestamp;
	}
}

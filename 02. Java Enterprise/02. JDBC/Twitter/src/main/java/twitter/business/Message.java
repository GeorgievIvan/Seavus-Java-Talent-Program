package twitter.business;

import java.sql.Timestamp;
import java.util.Calendar;

public class Message {

	private Long id;
	private String text;
	private Timestamp timestamp;
		
	public Message(final String text) {
		
		id = null;
		this.text = text;
		timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	public Message(final String text, final Timestamp timestamp) {
		
		id = null;
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public Message(final Long id, final String text, final Timestamp timestamp) {
		
		this.id = id;
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public Long getId() {
		
		return id;
	}
	
	public String getText() {
		
		return text;
	}
	
	public Timestamp getTimestamp() {
		
		return timestamp;
	}
}

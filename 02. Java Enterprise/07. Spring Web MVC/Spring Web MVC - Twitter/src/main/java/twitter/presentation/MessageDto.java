package twitter.presentation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import twitter.business.Message;

public class MessageDto {

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("hh:mm dd.mm.yyyy");
	
	private String text;
	private Timestamp timestamp;
	
	public MessageDto() {
		
		text = null;
		timestamp = null;
	}
	
	public MessageDto(final Message message) {
		
		text = message.getText();
		timestamp = message.getTimestamp();
	}

	public String getText() {
		
		return text;
	}

	public Timestamp getTimestamp() {
		
		return timestamp;
	}

	public void setText(final String text) {
		
		this.text = text;
	}

	public void setTimestamp(final Timestamp timestamp) {
		
		this.timestamp = timestamp;
	}
	
	public String getFormatedTimestamp() {
		
		return SIMPLE_DATE_FORMAT.format(timestamp);
	}
}
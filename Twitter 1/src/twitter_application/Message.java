package twitter_application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
	
	private final String content;
	
	private final Date date;
	
	public Message(final String content) {
		
		this.content = content;
		
		date = new Date();
	}
	
	public Message(final String content, final String dateString) throws ParseException {
		
		this.content = content;
		
		date = simpleDateFormat.parse(dateString);
	}

	public String getContent() {
		
		return content;
	}
	
	public Date getDate() {
		
		return date;
	}
	
	public String getDateString() {
		
		return simpleDateFormat.format(date);
	}
	
	@Override
	public String toString() {
		
		return String.format("%s\r\n%s", simpleDateFormat.format(date), content);
	}
}

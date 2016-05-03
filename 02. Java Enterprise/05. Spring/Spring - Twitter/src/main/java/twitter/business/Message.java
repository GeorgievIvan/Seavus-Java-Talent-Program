package twitter.business;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id @GeneratedValue @Column(name = "id")
	private Long id;
	
	@Column(name = "text", nullable = false)
	private String text;
	
	@Column(name = "timestamp", nullable = false)
	private Timestamp timestamp;
	
	public Message() {
		
		id = null;
		text = null;
		timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
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
	
	public void setId(final Long id) {
		
		this.id = id;
	}
	
	public void setText(final String text) {
		
		this.text = text;
	}
	
	public void setTimestamp(final Timestamp timestamp) {
		
		this.timestamp = timestamp;
	}
}

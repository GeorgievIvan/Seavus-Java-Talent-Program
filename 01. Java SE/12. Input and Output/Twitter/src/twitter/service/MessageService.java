package twitter.service;

import twitter.business.Message;
import twitter.data_access.MessageDao;
import java.util.ArrayList;

public class MessageService {

	private final MessageDao messageDao;
	
	public MessageService(final MessageDao messageDao) {
		
		this.messageDao = messageDao;
	}
	
	public void saveMessage(final String messageText) {
		
		final Message message = new Message(messageText);
		
		messageDao.insertMessage(message);
	}
	
	public ArrayList<Message> getAllMessages(final boolean orderByDateDescending) {
		
		return messageDao.readAllMessages(orderByDateDescending);
	}
}

package twitter.service;

import twitter.business.Message;
import twitter.data_access.MessageDao;
import java.util.List;

public class MessageService {

	private final MessageDao messageDao;
	
	public MessageService(final MessageDao messageDao) {
		
		this.messageDao = messageDao;
	}
	
	public List<Message> getAllMessages(final boolean orderByDateDescending) {
		
		return messageDao.readAllMessages(orderByDateDescending);
	}
	
	public void saveMessage(final String messageText) {
		
		final Message message = new Message(messageText);

		messageDao.insertMessage(message);
	}
}

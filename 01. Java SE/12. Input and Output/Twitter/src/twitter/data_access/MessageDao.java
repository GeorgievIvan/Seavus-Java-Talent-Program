package twitter.data_access;

import twitter.business.Message;
import java.util.ArrayList;

public interface MessageDao {
	
	void insertMessage(final Message message) throws RuntimeException;
	
	ArrayList<Message> readAllMessages(final boolean orderByDateDescending) throws RuntimeException;
}

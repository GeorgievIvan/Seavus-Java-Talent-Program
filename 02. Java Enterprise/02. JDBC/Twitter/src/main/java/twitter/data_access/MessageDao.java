package twitter.data_access;

import twitter.business.Message;
import java.util.List;

public interface MessageDao {
	
	void insertMessage(final Message message) throws RuntimeException;
	
	List<Message> readAllMessages(final boolean orderByDateDescending) throws RuntimeException;
}

package twitter.data_access;

import twitter.business.Message;
import java.util.List;

public interface MessageDao {
	
	List<Message> readAllMessages(final boolean orderByDateDescending) throws RuntimeException;
	
	void insertMessage(final Message message) throws RuntimeException;
}

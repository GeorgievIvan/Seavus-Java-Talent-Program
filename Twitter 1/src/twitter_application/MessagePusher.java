package twitter_application;

import java.io.IOException;

public interface MessagePusher {

	void pushMessage(Message message) throws IOException;
}

package twitter;

import twitter.data_access.MessageDao;
import twitter.data_access.FileMessageDao;
import twitter.data_access.JdbcMessageDao;
import twitter.presentation.TwitterPresenter;
import twitter.service.MessageService;

public class TwitterApplication {

	public static void main(String []args) {
		
		MessageDao messageDao = new FileMessageDao("messages.txt");
		//MessageDao messageDao = new JdbcMessageDao("jdbc:postgresql://localhost:5432/twitter", "postgres", "Password1");
		MessageService messageController = new MessageService(messageDao);
		TwitterPresenter twitterPresenter = new TwitterPresenter(messageController);
		
		twitterPresenter.run();
	}
}
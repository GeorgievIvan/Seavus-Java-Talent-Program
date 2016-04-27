package twitter;

import twitter.data_access.MessageDao;
import twitter.data_access.FileMessageDao;
import twitter.presentation.TwitterPresenter;
import twitter.service.MessageService;

public class TwitterApplication {

	public static void main(String []args) {
		
		final MessageDao messageDao = new FileMessageDao("messages.txt");
		final MessageService messageController = new MessageService(messageDao);
		final TwitterPresenter twitterPresenter = new TwitterPresenter(messageController);
		
		twitterPresenter.run();
	}
}
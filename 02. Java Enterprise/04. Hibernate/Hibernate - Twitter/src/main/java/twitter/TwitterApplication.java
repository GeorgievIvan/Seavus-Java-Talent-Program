package twitter;

import twitter.data_access.MessageDao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import twitter.business.Message;
import twitter.data_access.FileMessageDao;
import twitter.data_access.HibernateMessageDao;
import twitter.data_access.JdbcMessageDao;
import twitter.presentation.TwitterPresenter;
import twitter.service.MessageService;

public class TwitterApplication {

	public static void main(String []args) {
		
		/*
		// File
		MessageDao messageDao = new FileMessageDao("src/main/resources/messages.txt");
		MessageService messageController = new MessageService(messageDao);
		TwitterPresenter twitterPresenter = new TwitterPresenter(messageController);
		
		twitterPresenter.run();
		*/
		
		/*
		// JDBC
		MessageDao messageDao = new JdbcMessageDao("jdbc:postgresql://localhost:5432/jdbc_twitter", "postgres", "Password1");
		MessageService messageController = new MessageService(messageDao);
		TwitterPresenter twitterPresenter = new TwitterPresenter(messageController);
		
		twitterPresenter.run();
		*/
		
		// Hibernate
		final Configuration configuration = new Configuration();
		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		final SessionFactory sessionFactory = configuration.addAnnotatedClass(Message.class).buildSessionFactory(serviceRegistry);

		MessageDao messageDao = new HibernateMessageDao(sessionFactory);
		MessageService messageController = new MessageService(messageDao);
		TwitterPresenter twitterPresenter = new TwitterPresenter(messageController);
		
		twitterPresenter.run();
		
		sessionFactory.close();
	}
}
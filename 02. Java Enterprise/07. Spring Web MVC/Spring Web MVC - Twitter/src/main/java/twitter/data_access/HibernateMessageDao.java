package twitter.data_access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import twitter.business.Message;

@Repository
public class HibernateMessageDao implements MessageDao {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public HibernateMessageDao(final HibernateDatabaseConfigurator hibernateDatabaseConfigurator) {
		
		sessionFactory = hibernateDatabaseConfigurator.getSessionFactory();
	}
		
	@Override
	public List<Message> readAllMessages(final boolean orderByDateDescending) throws RuntimeException {

		List<Message> messages = null;
		
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
						
			final String hql = "from Message order by timestamp desc";
			
			final Query query = session.createQuery(hql);
			
			messages = query.list();
			
			transaction.commit();
		}
		catch(final RuntimeException runtimeExceptione) {
			
			if(transaction != null) { 
				
				transaction.rollback(); 
			}
			
			throw runtimeExceptione;
		}
		finally {
			
			session.close();
		}
		
		return messages;
	}
	
	@Override
	public void insertMessage(final Message message) throws RuntimeException {

		final Session session = sessionFactory.openSession();
		
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
						
			session.save(message);
			
			transaction.commit();
		}
		catch(final RuntimeException runtimeExceptione) {
			
			if(transaction != null) { 
				
				transaction.rollback(); 
			}
			
			throw runtimeExceptione;
		}
		finally {
			
			session.close();
		}
	}
}

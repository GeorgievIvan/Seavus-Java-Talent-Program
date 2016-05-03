package twitter.data_access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import twitter.business.Message;

public class HibernateMessageDao implements MessageDao {
	
	private final SessionFactory sessionFactory;
	
	public HibernateMessageDao(final SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Message> readAllMessages(final boolean orderByDateDescending) throws RuntimeException {

		final Session session = sessionFactory.openSession();
		
		final String hql = "from Message order by timestamp desc";
		
		final Query query = session.createQuery(hql);
		
		final List messages = query.list();
		
		session.close();
		
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

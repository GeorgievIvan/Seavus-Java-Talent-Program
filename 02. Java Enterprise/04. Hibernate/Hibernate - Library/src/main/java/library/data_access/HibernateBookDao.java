package library.data_access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import library.business.Book;

public class HibernateBookDao implements BookDao {

	private final SessionFactory sessionFactory;
	
	public HibernateBookDao(final SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Book> readAllBooks() {
		
		final Session session = sessionFactory.openSession();
		
		final String hql = "FROM Book";
		
		final Query query = session.createQuery(hql);
		
		final List books = query.list();
		
		session.close();
		
		return books;
	}
	
	@Override
	public void insertBook(final Book book) {
		
		final Session session = sessionFactory.openSession();
		
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
						
			session.save(book);
			
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

	@Override
	public void updateBook(final Long bookId, final String newBookTitle) {

		final Session session = sessionFactory.openSession();
		
		final String hql = "update Book set title = :newBookTitle WHERE id = :bookId";
		
		final Query query = session.createQuery(hql);
		
		query.setParameter("newBookTitle", newBookTitle);
		query.setParameter("bookId", bookId);

		query.executeUpdate();
		
		session.close();
	}

	@Override
	public void deleteBook(final Long bookId) {

		final Session session = sessionFactory.openSession();
		
		final String hql = "delete from Book where id = :bookId";
		
		final Query query = session.createQuery(hql);
		
		query.setParameter("bookId", bookId);
		
		query.executeUpdate();
		
		session.close();
	}
}

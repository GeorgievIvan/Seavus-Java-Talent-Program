package library.data_access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import library.business.Book;
import library.business.Magazine;
import library.business.Publication;

public class HibernatePublicationDao implements PublicationDao {

	private final SessionFactory sessionFactory;
	
	public HibernatePublicationDao(final SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Book> readAllBooks() {

		List<Book> books = null;
		
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			final String hql = "from Book";
			
			final Query query = session.createQuery(hql);
			
			books = query.list();
			
			transaction.commit();
		}
		catch(RuntimeException runtimeExceptione) {
			
			if(transaction != null) { 
				
				transaction.rollback(); 
			}
			
			throw runtimeExceptione;
		}
		finally {
			session.close();
		}
		
		return books;
	}

	@Override
	public List<Magazine> readAllMagazines() {

		List<Magazine> magazines = null;
		
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			final String hql = "from Magazine";
			
			final Query query = session.createQuery(hql);
			
			magazines = query.list();
			
			transaction.commit();
		}
		catch(RuntimeException runtimeExceptione) {
			
			if(transaction != null) { 
				
				transaction.rollback(); 
			}
			
			throw runtimeExceptione;
		}
		finally {
			session.close();
		}
		
		return magazines;
	}

	@Override
	public Publication readPublication(Long publicationId) {
		
		List<Publication> publications = null;
		Publication publication = null;
		
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			final String hql = "from Publication p where p.id = :publicationId";
			
			final Query query = session.createQuery(hql);
			query.setParameter("publicationId", publicationId);
			
			publications = query.list();
			
			transaction.commit();
		}
		catch(RuntimeException runtimeExceptione) {
			
			if(transaction != null) { 
				
				transaction.rollback(); 
			}
			
			throw runtimeExceptione;
		}
		finally {
			session.close();
		}
		
		publication = publications.get(0);
		
		return publication;
	}

	@Override
	public void insertPublication(Publication publication) {

		Session session= sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			session.save(publication);
			
			transaction.commit();
		}
		catch(RuntimeException runtimeExceptione) {
			
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
	public void updateBook(Long bookId, String newBookTitle) {

		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Book book = session.get(Book.class, bookId);
			
			book.setTitle(newBookTitle);
			
			session.save(book);
			
			transaction.commit();
		}
		catch(RuntimeException runtimeException) {
			
			if(transaction != null) {
				
				transaction.rollback();
			}
		}
		finally {
			
			session.close();
		}
	}

	@Override
	public void updateMagazine(Long magazineId, String newMagazineTitle) {

		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Magazine magazine = (Magazine)session.get(Magazine.class, magazineId);
			
			magazine.setTitle(newMagazineTitle);
			
			session.save(magazine);
			
			transaction.commit();
		}
		catch(RuntimeException runtimeException) {
			
			if(transaction != null) {
				
				transaction.rollback();
			}
		}
		finally {
			
			session.close();
		}
	}

	@Override
	public void deletePublication(Long publicationId) {
		
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			final String hql = "delete Publication where id = :publicationId";
			
			final Query query = session.createQuery(hql);
			query.setParameter("publicationId", publicationId);
			
			query.executeUpdate();
			
			transaction.commit();
		}
		catch(RuntimeException runtimeExceptione) {
			
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

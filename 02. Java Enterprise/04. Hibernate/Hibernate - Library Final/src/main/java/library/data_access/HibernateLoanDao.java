package library.data_access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import library.business.Loan;

public class HibernateLoanDao implements LoanDao {

	private final SessionFactory sessionFactory;
	
	public HibernateLoanDao(final SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Loan> readAllLoans() {
		
		List<Loan> loans = null;
		
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			final String hql = "from Loan";
			
			final Query query = session.createQuery(hql);
			
			loans = query.list();
			
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
		
		return loans;
	}

	@Override
	public void insertLoan(Loan loan) {
		
		Session session= sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			session.save(loan);
			
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

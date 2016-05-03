package library.data_access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import library.business.Member;

public class HibernateMemberDao implements MemberDao {

	private final SessionFactory sessionFactory;
	
	public HibernateMemberDao(final SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Member> readAllMembers() {

		List<Member> members = null;
		
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			final String hql = "from Member";
			
			final Query query = session.createQuery(hql);
			
			members = query.list();
			
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
		
		return members;
	}

	@Override
	public Member readMember(Long memberId) {

		List<Member> members = null;
		Member member = null;
		final Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			final String hql = "from Member m where m.id = :memberId";
			
			final Query query = session.createQuery(hql);
			query.setParameter("memberId", memberId);
			
			members = query.list();
			
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
		
		member = members.get(0);
		
		return member;
	}

	@Override
	public void insertMember(Member member) {

		Session session= sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			session.save(member);
			
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

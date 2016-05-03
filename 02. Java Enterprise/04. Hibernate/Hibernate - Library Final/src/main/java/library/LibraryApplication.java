package library;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import library.business.*;
import library.data_access.*;
import library.presentation.*;
import library.service.*;

public class LibraryApplication {

	public static void main(String []args) {
		
		final Configuration configuration = new Configuration();
		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		final SessionFactory sessionFactory = configuration.addAnnotatedClass(Publication.class).addAnnotatedClass(Book.class).addAnnotatedClass(Magazine.class).addAnnotatedClass(Member.class).addAnnotatedClass(Loan.class).buildSessionFactory(serviceRegistry);
	
		final PublicationDao publicationDao = new HibernatePublicationDao(sessionFactory);
		final MemberDao memberDao = new HibernateMemberDao(sessionFactory);
		final LoanDao loanDao = new HibernateLoanDao(sessionFactory);
		
		final BookService bookService = new BookService(publicationDao);
		final MagazineService magazineService = new MagazineService(publicationDao);
		final MemberService memberService = new MemberService(memberDao);
		final LoanService loanService = new LoanService(publicationDao, memberDao, loanDao);
		
		final BookPresenterComponent bookPresenterComponent = new BookPresenterComponent(bookService);
		final MagazinePresenterComponent magazinePresenterComponent = new MagazinePresenterComponent(magazineService);
		final MemberPresenterComponent memberPresenterComponent = new MemberPresenterComponent(memberService);
		final LoanPresenterComponent loanPresenterComponent = new LoanPresenterComponent(loanService);
		final LibraryPresenterComponent libraryPresenterComponent = new LibraryPresenterComponent(bookPresenterComponent, magazinePresenterComponent, memberPresenterComponent, loanPresenterComponent);
		
		libraryPresenterComponent.run();
		
		sessionFactory.close();
	}
}
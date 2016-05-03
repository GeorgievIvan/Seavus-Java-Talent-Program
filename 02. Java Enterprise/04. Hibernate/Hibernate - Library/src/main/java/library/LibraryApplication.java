package library;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import library.business.Book;
import library.data_access.BookDao;
import library.data_access.HibernateBookDao;
import library.data_access.JdbcBookDao;
import library.presentation.LibraryPresenter;
import library.service.BookService;

public class LibraryApplication {

	public static void main(String []args) {
			
		/*
		// JDBC
		final String databaseUrl = "jdbc:postgresql://localhost:5432/jdbc_library";
		final String databaseUsername = "postgres";
		final String databasePassword = "Password1";
		
		final BookDao bookDao = new JdbcBookDao(databaseUrl, databaseUsername, databasePassword);
		final BookService bookService = new BookService(bookDao);
		final LibraryPresenter libraryPresenter = new LibraryPresenter(bookService);

		libraryPresenter.run();
		*/
		
		// Hibernate
		final Configuration configuration = new Configuration();
		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		final SessionFactory sessionFactory = configuration.addAnnotatedClass(Book.class).buildSessionFactory(serviceRegistry);

		final BookDao bookDao = new HibernateBookDao(sessionFactory);
		final BookService bookService = new BookService(bookDao);
		final LibraryPresenter libraryPresenter = new LibraryPresenter(bookService);

		libraryPresenter.run();
		
		sessionFactory.close();
	}
}
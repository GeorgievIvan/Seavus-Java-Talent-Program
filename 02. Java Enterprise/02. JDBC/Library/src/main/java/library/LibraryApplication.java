package library;

import library.data_access.BookDao;
import library.data_access.JdbcBookDao;
import library.presentation.LibraryPresenter;
import library.service.BookService;

public class LibraryApplication {

	public static void main(String []args) {
		
		final String databaseUrl = "jdbc:postgresql://localhost:5432/jdbc_library";
		final String databaseUsername = "postgres";
		final String databasePassword = "Password1";
		
		final BookDao bookDao = new JdbcBookDao(databaseUrl, databaseUsername, databasePassword);
		final BookService bookService = new BookService(bookDao);
		final LibraryPresenter libraryPresenter = new LibraryPresenter(bookService);
		
		libraryPresenter.run();
	}
}
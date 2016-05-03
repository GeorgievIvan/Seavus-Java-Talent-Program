package library.data_access;

import java.util.List;

import library.business.Book;

public interface BookDao {
	
	List<Book> readAllBooks();
	
	void insertBook(final Book book);
	
	void updateBook(final Long bookId, final String newBookTitle);
	
	void deleteBook(final Long bookId);
}

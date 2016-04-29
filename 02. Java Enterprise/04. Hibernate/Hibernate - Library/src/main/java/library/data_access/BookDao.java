package library.data_access;

import java.util.List;

import library.business.Book;

public interface BookDao {
	
	void insertBook(final Book book);
	List<Book> readAllBooks();
	void updateBook(final long bookId, final String newBookTitle);
	void deleteBook(final long bookId);
}

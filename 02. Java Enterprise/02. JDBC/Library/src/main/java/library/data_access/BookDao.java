package library.data_access;

import java.util.ArrayList;

import library.business.Book;

public interface BookDao {
	
	void insertBook(final Book book);
	ArrayList<Book> readAllBooks();
	void updateBook(final long bookId, final String newBookTitle);
	void deleteBook(final long bookId);
}

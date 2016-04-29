package library.service;

import java.util.List;

import library.business.Book;
import library.data_access.BookDao;

public class BookService {

	private final BookDao bookDao;
	
	public BookService(final BookDao bookDao) {
		
		this.bookDao = bookDao;
	}
	
	public void registerBook(final String bookIsbn, final String bookTitle) {
		
		Book book = new Book(bookIsbn, bookTitle);
		
		bookDao.insertBook(book);
	}
	
	public List<Book> getAllBooks() {
			
		return bookDao.readAllBooks();
	}
	
	public void updateBook(final Long bookId, final String newBookTitle) {

		bookDao.updateBook(bookId, newBookTitle);
	}
	
	public void unregisterBook(final Long bookId) {

		bookDao.deleteBook(bookId);
	}
}

package library.service;

import java.util.ArrayList;

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
	
	public ArrayList<Book> getAllBooks() {
		
		final ArrayList<Book> books = bookDao.readAllBooks();
		
		return books;
	}
	
	public void updateBook(final long bookId, final String newBookTitle) {

		bookDao.updateBook(bookId, newBookTitle);
	}
	
	public void unregisterBook(final long bookId) {

		bookDao.deleteBook(bookId);
	}
}

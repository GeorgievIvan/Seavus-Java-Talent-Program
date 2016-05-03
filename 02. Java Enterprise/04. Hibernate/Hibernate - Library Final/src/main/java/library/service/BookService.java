package library.service;

import java.util.List;

import library.business.Book;
import library.data_access.PublicationDao;;

public class BookService {

	private final PublicationDao publicationDao;
	
	public BookService(final PublicationDao publicationDao) {
		
		this.publicationDao = publicationDao;
	}
	
	public List<Book> getAllBooks() {
		
		return publicationDao.readAllBooks();
	}
	
	public void registerBook(final String bookIsbn, final String bookTitle) {
		
		final Book book = new Book();
		book.setIsbn(bookIsbn);
		book.setTitle(bookTitle);
		
		publicationDao.insertPublication(book);
	}
	
	public void updateBook(final Long bookId, final String newBookTitle) {
		
		publicationDao.updateBook(bookId, newBookTitle);
	}
	
	public void unregisterBook(final Long bookId) {
		
		publicationDao.deletePublication(bookId);
	}
}

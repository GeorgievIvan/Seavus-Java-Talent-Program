package library.data_access;

import java.util.List;

import library.business.Book;
import library.business.Magazine;
import library.business.Publication;

public interface PublicationDao {

	List<Book> readAllBooks();
	
	List<Magazine> readAllMagazines();
	
	Publication readPublication(final Long publicationId);
	
	void insertPublication(final Publication publication);
	
	void updateBook(final Long bookId, final String newBookTitle);
	
	void updateMagazine(final Long magazineId, final String newMagazineTitle);
	
	void deletePublication(final Long publicationId);
}

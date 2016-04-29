package library.business;

public class Book {

	private Long id;
	private String isbn;
	private String title;
	
	public Book(final String isbn, final String title) {
		
		id = null;
		this.isbn = isbn;
		this.title = title;
	}
	
	public Book(final Long id, final String isbn, final String title) {
		
		this.id = id;
		this.isbn = isbn;
		this.title = title;
	}
	
	public Long getId() {
		
		return id;
	}
	
	public String getIsbn() {
		
		return isbn;
	}
	
	public String getTitle() {
		
		return title;
	}
}

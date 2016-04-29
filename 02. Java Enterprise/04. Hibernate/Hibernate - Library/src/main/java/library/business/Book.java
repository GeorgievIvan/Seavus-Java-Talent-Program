package library.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id @GeneratedValue @Column(name = "id")
	private Long id;
	
	@Column(name = "isbn", nullable = false, unique = true)
	private String isbn;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	public Book() {
		
		id = null;
		isbn = null;
		title = null;
	}
	
	public Book(final String isbn, final String title) {
		
		id = null;
		this.isbn = isbn;
		this.title = title;
	}
	
	public Book(final long id, final String isbn, final String title) {
		
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
	
	public void setId(final Long id) {
		
		this.id = id;
	}
	
	public void setIsbn(final String isbn) {
		
		this.isbn = isbn;
	}
	
	public void setTitle(final String title) {
		
		this.title = title;
	}
}

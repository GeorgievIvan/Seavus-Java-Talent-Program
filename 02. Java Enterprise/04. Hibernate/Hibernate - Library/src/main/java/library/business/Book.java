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

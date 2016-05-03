package library.business;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id")), @AttributeOverride(name = "title", column = @Column(name = "title"))})  
public class Book extends Publication {

	@Column(name = "isbn", nullable = false)
	private String isbn;

	public String getIsbn() {
		
		return isbn;
	}

	public void setIsbn(final String isbn) {
		
		this.isbn = isbn;
	}
}

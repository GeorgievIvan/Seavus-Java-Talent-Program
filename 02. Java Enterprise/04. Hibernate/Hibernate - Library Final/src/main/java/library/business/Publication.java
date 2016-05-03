package library.business;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "publication")
public abstract class Publication {

	@Id @GeneratedValue @Column(name = "id")
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;

	@OneToMany(mappedBy = "publication")
	private Set<Loan> loans;

	public Long getId() {
		
		return id;
	}

	public String getTitle() {
		
		return title;
	}

	public Set<Loan> getLoans() {
		
		return loans;
	}

	public void setId(final Long id) {
		
		this.id = id;
	}

	public void setTitle(final String title) {
		
		this.title = title;
	}

	public void setLoans(final Set<Loan> loans) {
		
		this.loans = loans;
	}
}

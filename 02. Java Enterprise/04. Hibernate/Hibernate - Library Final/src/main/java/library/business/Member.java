package library.business;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id @GeneratedValue @Column(name = "id")
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "member")
	private Set<Loan> loans;

	public Long getId() {
		
		return id;
	}

	public String getEmail() {
		
		return email;
	}

	public String getName() {
		
		return name;
	}

	public Set<Loan> getLoans() {
		
		return loans;
	}

	public void setId(final Long id) {
		
		this.id = id;
	}

	public void setEmail(final String email) {
		
		this.email = email;
	}

	public void setName(final String name) {
		
		this.name = name;
	}

	public void setLoans(final Set<Loan> loans) {
		
		this.loans = loans;
	}
}

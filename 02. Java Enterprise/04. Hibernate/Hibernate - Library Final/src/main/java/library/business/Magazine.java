package library.business;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "magazine")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id")), @AttributeOverride(name = "title", column = @Column(name = "title"))})  
public class Magazine extends Publication {

	@Column(name = "issn", nullable = false)
	private String issn;

	public String getIssn() {
		
		return issn;
	}

	public void setIssn(final String issn) {
		
		this.issn = issn;
	}
}

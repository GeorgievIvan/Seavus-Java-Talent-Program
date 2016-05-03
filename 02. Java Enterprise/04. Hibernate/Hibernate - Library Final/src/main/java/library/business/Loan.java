package library.business;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

	@Id @GeneratedValue @Column(name = "id")
	private Long id;
	
	@Column(name = "startdate", nullable = false)
	private Timestamp startDate;
	
	@Column(name = "enddate", nullable = false)
	private Timestamp endDate;
	
	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Publication publication;

	public Long getId() {
		
		return id;
	}

	public Timestamp getStartDate() {
		
		return startDate;
	}

	public Timestamp getEndDate() {
		
		return endDate;
	}

	public Member getMember() {
		
		return member;
	}

	public Publication getPublication() {
		
		return publication;
	}

	public void setId(final Long id) {
		
		this.id = id;
	}

	public void setStartDate(final Timestamp startDate) {
		
		this.startDate = startDate;
	}

	public void setEndDate(final Timestamp endDate) {
		
		this.endDate = endDate;
	}

	public void setMember(final Member member) {
		
		this.member = member;
	}

	public void setPublication(final Publication publication) {
		
		this.publication = publication;
	}
}

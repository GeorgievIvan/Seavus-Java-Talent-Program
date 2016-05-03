package library.service;

import java.sql.Timestamp;
import java.util.List;

import library.business.Loan;
import library.business.Member;
import library.business.Publication;
import library.data_access.LoanDao;
import library.data_access.MemberDao;
import library.data_access.PublicationDao;

public class LoanService {

	private final PublicationDao publicationDao;
	private final MemberDao memberDao;
	private final LoanDao loanDao;

	public LoanService(final PublicationDao publicationDao, final MemberDao memberDao, final LoanDao loanDao) {
		
		this.publicationDao = publicationDao;
		this.memberDao = memberDao;
		this.loanDao = loanDao;
	}
	
	public List<Loan> getAllLoans() {
		
		return loanDao.readAllLoans();
	}
	
	public void registerLoan(final Timestamp loanStartDate, final Timestamp loanEndDate, final Long memberId, final Long publicationId) {
		
		final Member member = memberDao.readMember(memberId);
		
		final Publication publication = publicationDao.readPublication(publicationId);
		
		final Loan loan = new Loan();
		loan.setStartDate(loanStartDate);
		loan.setEndDate(loanEndDate);
		loan.setMember(member);
		loan.setPublication(publication);
		
		loanDao.insertLoan(loan);
	}
}

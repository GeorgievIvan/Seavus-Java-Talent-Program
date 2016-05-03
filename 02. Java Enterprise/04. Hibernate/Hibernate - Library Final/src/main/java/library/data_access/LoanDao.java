package library.data_access;

import java.util.List;

import library.business.Loan;

public interface LoanDao {

	List<Loan> readAllLoans();
	
	void insertLoan(final Loan loan);
}

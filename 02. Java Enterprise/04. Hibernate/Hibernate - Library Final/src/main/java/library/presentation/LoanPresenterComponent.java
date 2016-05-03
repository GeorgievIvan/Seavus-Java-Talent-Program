package library.presentation;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import library.business.Loan;
import library.service.LoanService;

public class LoanPresenterComponent extends PresenterComponent {

	private final LoanService loanService;
	
	public LoanPresenterComponent(final LoanService loanService) {
	
		this.loanService = loanService;
	}
	
	@Override
	public void run() {

		while(true) {
			
			showMenu();
			
			final String input = scanner.nextLine();
			
			switch(input) {
			
				case "1":
					listLoans();
				break;
				
				case "2":
					registerLoan();
				break;
				
				case "3":
					return;
			}
		}
	}

	@Override
	protected void showMenu() {
		
		System.out.println("--------Loans--------");
		System.out.println("1. List loans.");
		System.out.println("2. Register loan.");
		System.out.println("3. Exit.");
	}

	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
	}
	
	private void listLoans() {

		final List<Loan> loans = loanService.getAllLoans();
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
		
		System.out.println(String.format("%-10s\t%-10s\t%-10s\t%-10s\t%s", "ID", "Start date", "End date", "Member ID", "Publication ID"));	
		
		for(final Loan loan: loans) {
			
			System.out.println(String.format("%-10d\t%-10s\t%-10s\t%-10d\t%d", loan.getId(), simpleDateFormat.format(loan.getStartDate()), simpleDateFormat.format(loan.getEndDate()), loan.getMember().getId(), loan.getPublication().getId()));
		}
	}
	
	private void registerLoan() {

		try {
			
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
	
			System.out.print("Start date: ");
			final Timestamp loanStartDate = new Timestamp(simpleDateFormat.parse(scanner.nextLine()).getTime());
			
			System.out.print("End date: ");
			final Timestamp loanEndDate = new Timestamp(simpleDateFormat.parse(scanner.nextLine()).getTime());
			
			System.out.print("Member ID: ");
			final Long memberId = Long.parseLong(scanner.nextLine());
			
			System.out.print("Publication ID: ");
			final Long publicationId = Long.parseLong(scanner.nextLine());
			
			loanService.registerLoan(loanStartDate, loanEndDate, memberId, publicationId);
			
			System.out.println("The loan was successfully registered.");
		}
		catch(ParseException parseException) {
			
			System.out.println("The date format must be \"dd.mm.yyyy\".");
		}
	}
}

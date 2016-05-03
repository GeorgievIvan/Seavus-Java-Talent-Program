package library.presentation;

public class LibraryPresenterComponent extends PresenterComponent {

	private final BookPresenterComponent bookPresenterComponent;
	private final MagazinePresenterComponent magazinePresenterComponent;
	private final MemberPresenterComponent memberPresenterComponent;
	private final LoanPresenterComponent loanPresenterComponent;
	
	public LibraryPresenterComponent(final BookPresenterComponent bookPresenterComponent, final MagazinePresenterComponent magazinePresenterComponent, final MemberPresenterComponent memberPresenterComponent, final LoanPresenterComponent loanPresenterComponent) {
		
		this.bookPresenterComponent = bookPresenterComponent;
		this.magazinePresenterComponent = magazinePresenterComponent;
		this.memberPresenterComponent = memberPresenterComponent;
		this.loanPresenterComponent = loanPresenterComponent;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			showMenu();
			
			final String input = scanner.nextLine();
			
			switch(input) {
			
				case "1":
					bookPresenterComponent.run();
				break;
				
				case "2":
					magazinePresenterComponent.run();
				break;
				
				case "3":
					memberPresenterComponent.run();
				break;
				
				case "4":
					loanPresenterComponent.run();
				break;
				
				case "5":
					System.out.println("Goodbye.");
					return;
			}
		}
	}

	@Override
	protected void showMenu() {

		System.out.println("--------MENU--------");
		System.out.println("1. Books");
		System.out.println("2. Magazines");
		System.out.println("3. Members");
		System.out.println("4. Loans");
		System.out.println("5. Exit");
	}
	
	@Override
	protected void finalize() throws Throwable {

		super.finalize();
	}
}

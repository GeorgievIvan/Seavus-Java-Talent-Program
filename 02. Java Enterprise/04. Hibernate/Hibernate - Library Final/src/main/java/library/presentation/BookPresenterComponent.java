package library.presentation;

import java.util.List;

import library.business.Book;
import library.service.BookService;

public class BookPresenterComponent extends PresenterComponent {

	private final BookService bookService;
	
	public BookPresenterComponent(final BookService bookService) {
	
		this.bookService = bookService;
	}
	
	@Override
	public void run() {

		while(true) {
			
			showMenu();
			
			final String input = scanner.nextLine();
			
			switch(input) {
			
				case "1":
					listBooks();
				break;
				
				case "2":
					registerBook();
				break;
				
				case "3":
					updateBook();
				break;
				
				case "4":
					unregisterBook();
				break;
				
				case "5":
					return;
			}
		}
	}

	@Override
	protected void showMenu() {
		
		System.out.println("--------Books--------");
		System.out.println("1. List books.");
		System.out.println("2. Register book.");
		System.out.println("3. Update book.");
		System.out.println("4. Unregister book.");
		System.out.println("5. Exit.");
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
	}
	
	private void listBooks() {
		
		final List<Book> books = bookService.getAllBooks();
		
		System.out.println(String.format("%s %s %s", "ID", "ISBN", "Title"));
		
		for(final Book book : books) {
			
			System.out.println(String.format("%d %s %s", book.getId(), book.getIsbn(), book.getTitle()));
		}
	}
	
	private void registerBook() {
		
		System.out.print("ISBN: ");
		final String bookIsbn = scanner.nextLine();
	
		System.out.print("Title: ");
		final String bookTitle = scanner.nextLine();
		
		bookService.registerBook(bookIsbn, bookTitle);
		
		System.out.println("The book was successfully registered.");
	}
	
	private void updateBook() {
		
		System.out.print("ID: ");
		final Long bookId = Long.parseLong(scanner.nextLine());
	
		System.out.print("New title: ");
		final String bookNewTitle = scanner.nextLine();
		
		bookService.updateBook(bookId, bookNewTitle);
		
		System.out.println("The book was successfully updated.");
	}
	
	private void unregisterBook() {
		
		System.out.print("ID: ");
		final Long bookId = Long.parseLong(scanner.nextLine());
			
		bookService.unregisterBook(bookId);
		
		System.out.println("The book was successfully unregistered.");
	}
}

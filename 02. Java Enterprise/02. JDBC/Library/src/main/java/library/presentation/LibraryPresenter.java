package library.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import library.business.Book;
import library.service.BookService;

public class LibraryPresenter {

	private final BookService bookService;
	private final Scanner scanner;
	
	public LibraryPresenter(final BookService bookService) {
		
		this.bookService = bookService;
		
		scanner = new Scanner(System.in);
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		scanner.close();
		
		super.finalize();
	}
	
	public void run() {
		
		while(true) {
			
			showMenu();
			
			String input = scanner.nextLine();
			
			switch(input) {
			
			case "1":
				registerBook();
			break;
			
			case "2":
				listBooks();
			break;
			
			case "3":
				updateBook();
			break;
			
			case "4":
				unregisterBook();
			break;
			
			case "5":
				System.out.println("Goodbye.");
				return;
				
			default:
				System.out.println("Invalid command.");
			}
		}
	}
	
	private void registerBook() {
		
		System.out.print("ISBN: ");
		String bookIsbn = scanner.nextLine();
		
		System.out.print("Title: ");
		String bookTitle = scanner.nextLine();

		bookService.registerBook(bookIsbn, bookTitle);
		
		System.out.println("The book was successfully registered.");
	}
	
	private void listBooks() {
		
		ArrayList<Book> books = bookService.getAllBooks();
		
		System.out.println(String.format("%-13s\t%-13s\t%s", "ID", "ISBN", "Title"));
		
		for(Book book : books) {
			
			System.out.println(String.format("%-13d\t%-13s\t%s", book.getId(), book.getIsbn(), book.getTitle()));
		}
	}
	
	private void updateBook() {
		
		System.out.print("ID: ");
		long bookId = Long.parseLong(scanner.nextLine());
		
		System.out.print("New title: ");
		String newBookTitle = scanner.nextLine();
		
		bookService.updateBook(bookId, newBookTitle);
		
		System.out.println("The book was successfully updated.");
	}
	
	private void unregisterBook() {
		
		System.out.print("ID: ");
		long bookId = Long.parseLong(scanner.nextLine());
		
		bookService.unregisterBook(bookId);
		
		System.out.println("The book was successfully unregistered.");
	}
	
	private void showMenu() {
		
		System.out.println("--------MENU--------");
		System.out.println("1. Register book.");
		System.out.println("2. List books.");
		System.out.println("3. Update book.");
		System.out.println("4. Unregister book.");
		System.out.println("5. Exit.");
		System.out.println("--------------------");
	}
}

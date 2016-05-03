package library.presentation;

import java.util.Scanner;

public abstract class PresenterComponent {

	protected final Scanner scanner;
	
	public PresenterComponent() {
		
		scanner = new Scanner(System.in);
	}
	
	public abstract void run();
	
	protected abstract void showMenu();
	
	@Override
	protected void finalize() throws Throwable {
		
		scanner.close();
		
		super.finalize();
	}
}

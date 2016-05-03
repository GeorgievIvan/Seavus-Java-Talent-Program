package twitter.presentation;

import twitter.business.Message;
import twitter.service.MessageService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class TwitterPresenter {
	
	private final Scanner scanner;
	private final MessageService messageController;
	
	public TwitterPresenter(final MessageService messageController) {
		
		scanner = new Scanner(System.in);
		
		this.messageController = messageController;
	}

	protected void finalize() throws Throwable {
		
		scanner.close();
	}
	
	public void run() {
		
		while(true) {
			
			showMenu();
			
			final String userInput = scanner.nextLine();
			
			switch(userInput) {
			
				case "1":
					listMessages();
				break;
				
				case "2":
					newMessage();
				break;
	
				case "3":
					System.out.println("Goodbye.");
					return;

				default:
					System.out.println("Invalid command.");
			}
		}
	}
	
	private void showMenu() {
		
		System.out.println("--------MENU--------");
		System.out.println("1. list messages.");
		System.out.println("2. new message.");
		System.out.println("3. exit.");
		System.out.println("--------------------");
	}
	
	private void listMessages() {
		
		final List<Message> messages = messageController.getAllMessages(true);
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
		
		System.out.println(String.format("%-19s\t%s", "Timestamp", "Text"));
		
		for(final Message message : messages) {
			
			System.out.println(String.format("%-19s\t%s", simpleDateFormat.format(message.getTimestamp()), message.getText()));
		}
	}
	
	private void newMessage() {
		
		System.out.println("Enter your message:");
		
		final String messageText = scanner.nextLine();
				
		messageController.saveMessage(messageText);
		
		System.out.println("Your message was saved.");
	}
}

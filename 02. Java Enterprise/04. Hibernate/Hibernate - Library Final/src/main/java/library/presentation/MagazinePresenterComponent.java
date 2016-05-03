package library.presentation;

import java.util.List;

import library.business.Magazine;
import library.service.MagazineService;

public class MagazinePresenterComponent extends PresenterComponent {

	private final MagazineService magazineService;
	
	public MagazinePresenterComponent(final MagazineService magazineService) {
	
		this.magazineService = magazineService;
	}
	
	@Override
	public void run() {

		while(true) {
			
			showMenu();
			
			final String input = scanner.nextLine();
			
			switch(input) {
			
				case "1":
					listMagazines();
				break;
				
				case "2":
					registerMagazine();
				break;
				
				case "3":
					updateMagazine();
				break;
				
				case "4":
					unregisterMagazine();
				break;
				
				case "5":
					return;
			}
		}
	}

	@Override
	protected void showMenu() {

		System.out.println("--------Magazines--------");
		System.out.println("1. List magazines.");
		System.out.println("2. Register magazine.");
		System.out.println("3. Update magazine.");
		System.out.println("4. Unregister magazine.");
		System.out.println("5. Exit.");
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
	}
	
	private void listMagazines() {
		
		final List<Magazine> magazines = magazineService.getAllMagazines();
		
		System.out.println(String.format("%s %s %s", "ID", "ISSN", "Title"));
		
		for(final Magazine magazine : magazines) {
			
			System.out.println(String.format("%d %s %s", magazine.getId(), magazine.getIssn(), magazine.getTitle()));
		}
	}
	
	private void registerMagazine() {
		
		System.out.print("ISSN: ");
		final String magazineIssn = scanner.nextLine();
	
		System.out.print("Title: ");
		final String magazineTitle = scanner.nextLine();
		
		magazineService.registerMagazine(magazineIssn, magazineTitle);
		
		System.out.println("The magazine was successfully registered.");
	}
	
	private void updateMagazine() {
		
		System.out.print("ID: ");
		final Long magazineId = Long.parseLong(scanner.nextLine());
	
		System.out.print("New title: ");
		final String magazineNewTitle = scanner.nextLine();
		
		magazineService.updateMagazine(magazineId, magazineNewTitle);
		
		System.out.println("The magazine was successfully updated.");
	}
	
	private void unregisterMagazine() {
		
		System.out.print("ID: ");
		final Long magazineId = Long.parseLong(scanner.nextLine());
			
		magazineService.unregisterMagazine(magazineId);
		
		System.out.println("The magazine was successfully unregistered.");
	}
}

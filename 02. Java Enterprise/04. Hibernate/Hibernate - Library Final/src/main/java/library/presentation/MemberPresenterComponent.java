package library.presentation;

import java.util.List;

import library.business.Member;
import library.service.MemberService;

public class MemberPresenterComponent extends PresenterComponent {

	private final MemberService memberService;
	
	public MemberPresenterComponent(final MemberService memberService) {
		
		this.memberService = memberService;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			showMenu();
			
			final String input = scanner.nextLine();
			
			switch(input) {
			
				case "1":
					listMembers();
				break;
				
				case "2":
					registerMember();
				break;
				
				case "3":
					return;
			}
		}

	}

	@Override
	protected void showMenu() {
		
		System.out.println("--------Members--------");
		System.out.println("1. List members.");
		System.out.println("2. Register member.");
		System.out.println("3. Exit.");
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
	}
	
	private void listMembers() {
		
		final List<Member> members = memberService.getAllMembers();
		
		System.out.println(String.format("%s %s %s", "ID", "Email", "Name"));
		
		for(final Member member : members) {
			
			System.out.println(String.format("%d %s %s", member.getId(), member.getEmail(), member.getName()));
		}
	}
	
	private void registerMember() {
		
		System.out.print("Email: ");
		final String memberEmail = scanner.nextLine();

		System.out.print("Name: ");
		final String memberName = scanner.nextLine();
		
		memberService.registerMember(memberEmail, memberName);
	
		System.out.println("The member was successfully registered.");
	}
}

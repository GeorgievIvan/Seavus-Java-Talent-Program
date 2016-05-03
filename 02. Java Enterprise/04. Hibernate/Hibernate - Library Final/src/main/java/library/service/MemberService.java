package library.service;

import java.util.List;

import library.business.Member;
import library.data_access.MemberDao;

public class MemberService {

	private final MemberDao memberDao;
	
	public MemberService(final MemberDao memberDao) {
		
		this.memberDao = memberDao;
	}
	
	public List<Member> getAllMembers() {
		
		return memberDao.readAllMembers();
	}
	
	public Member getMember(final Long memberId) {
		
		return memberDao.readMember(memberId);
	}
	
	public void registerMember(final String memberEmail, final String memberName) {
		
		final Member member = new Member();
		member.setEmail(memberEmail);
		member.setName(memberName);
		
		memberDao.insertMember(member);
	}
}

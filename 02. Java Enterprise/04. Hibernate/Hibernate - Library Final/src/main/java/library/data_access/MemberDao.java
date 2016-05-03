package library.data_access;

import java.util.List;

import library.business.Member;

public interface MemberDao {

	List<Member> readAllMembers();
	
	Member readMember(final Long memberId);
	
	void insertMember(final Member member);
}
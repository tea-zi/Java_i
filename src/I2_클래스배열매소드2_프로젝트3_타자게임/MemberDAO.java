package I2_클래스배열매소드2_프로젝트3_타자게임;

import java.util.Scanner;

public class MemberDAO {
	int max;
	Member[] memberList;
	int memberCount;
	Scanner scan = new Scanner(System.in);
	void init(int size) {
		max = size;
		memberList = new Member[max];
		memberCount = 0;
	}
	
	void insertMember(Member member) {
		
		memberList[memberCount] = member;
		memberCount += 1;
	}
	
	boolean checkMemberId(String id) {
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				return true;
			}
		}		
		return false;
	}
	boolean checkMemberIdAndPw(String id , String pw) {
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id) &&
					memberList[i].pw.equals(pw)) {
				return true;
			}
		}		
		return false;
	}
	void updateMember(int index , Member member) {
		memberList[index] = member;		
	}
	int getMemberIndex(String id) {
		int index = 0;
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}
	void removeMember(int index) {
		for(int i = index; i < memberCount - 1 ; i++) {
			memberList[i] = memberList[i + 1];
		}
		memberCount -= 1;
	}
	
	Member getMember(String id) {
		Member member = null;
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				member = memberList[i];
				break;
			}
		}
		return member;
	}
	void printMemberList() {
		for(int i = 0; i < memberCount; i++) {
			memberList[i].printMember();
		}
	}
	
	void join() {
		System.out.println("[회원가입] 아이디입력 : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if (result == true) {
			System.out.println("[중복아이디]");
		} else {
			System.out.println("[회원가입] 비밀번호입력 : ");
			String pw = scan.next();
			System.out.println("[회원가입] 이름입력 : ");
			String name = scan.next();
			Member member = new Member();
			member.id = id;
			member.pw = pw;
			member.name = name;
			insertMember(member);
			System.out.println("[회원가입 성공]");
		}
	}
	Member login() {
		System.out.println("[로그인] 아이디입력 : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if (result == false) {
			System.out.println("[없는아이디]");
			return null;
		} else {
			return getMember(id);
		}
		
	}
	
}

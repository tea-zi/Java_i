package I2_클래스배열매소드2_프로젝트1_멤버2;
import java.util.Scanner;
public class MemberDAO {
	Scanner scan;
	int max;
	Member[] memberList;
	int memberCount;
	
	void init(int size) {
		scan = new Scanner(System.in);
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
		System.out.println("[추가] 아이디입력 : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if(result == true) {
			System.out.println("[중복아이디]");
		}else {
			System.out.println("[추가] 비밀번호입력 : ");
			String pw = scan.next();
			System.out.println("[추가] 이름입력 : ");
			String name = scan.next();
			Member member = new Member();
			member.id = id;
			member.pw = pw;
			member.name = name;
			insertMember(member);
			System.out.println("[추가성공]");
		}
	}
	void delete() {
		System.out.println("[삭제] 아이디입력 : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if(result == false) {
			System.out.println("[아이디를 찾을수 없습니다]");
		}else {
			int index = getMemberIndex(id);
			removeMember(index);
			System.out.println("[삭제성공]");
		}
	}
	void update() {
		System.out.println("[수정] 아이디입력 : ");
		String id = scan.next();
		System.out.println("[수정] 비밀번호입력 : ");
		String pw = scan.next();
		boolean result = checkMemberIdAndPw(id , pw);
		if(result == false) {
			System.out.println("[아이디를 찾을수 없습니다]");
		}else {
			
			
			System.out.println("[수정] 이름입력 : ");
			String name = scan.next();
			Member member = getMember(id);
			member.name = name;
			System.out.println("[수정완료]");
		}
	}
	void printAll() {
		printMemberList();
	}
	
}

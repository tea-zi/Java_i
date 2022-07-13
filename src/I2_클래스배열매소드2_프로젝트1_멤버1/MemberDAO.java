package I2_클래스배열매소드2_프로젝트1_멤버1;
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
	
	void printMemberList() {
		for(int i = 0; i < memberCount; i++) {
			memberList[i].printMember();
		}
	}
	void join() {
		System.out.println("[추가] 아이디입력 : ");
		String id = scan.next();
		
		boolean result = false;		
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				result =  true;
			}
		}	
		
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
			memberList[memberCount] = member;
			memberCount += 1;
			System.out.println("[추가성공]");
		}
	}
	void delete() {
		System.out.println("[삭제] 아이디입력 : ");
		String id = scan.next();
		
		boolean result = false;		
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				result =  true;
			}
		}	
		
		if(result == false) {
			System.out.println("[아이디를 찾을수 없습니다]");
		}else {
			
			int index = 0;
			for(int i = 0; i < memberCount; i++) {
				if(memberList[i].id.equals(id)) {
					index = i;
					
				}
			}
						
			for(int i = index; i < memberCount - 1 ; i++) {
				memberList[i] = memberList[i + 1];
			}
			memberCount -= 1;
			
			System.out.println("[삭제성공]");
		}
	}
	void update() {
		System.out.println("[수정] 아이디입력 : ");
		String id = scan.next();
		System.out.println("[수정] 비밀번호입력 : ");
		String pw = scan.next();
		
		
		boolean result = false;
		
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id) &&
					memberList[i].pw.equals(pw)) {
				result =  true;
			}
		}		
		
		if(result == false) {
			System.out.println("[아이디를 찾을수 없습니다]");
		}else {
			
			
			System.out.println("[수정] 이름입력 : ");
			String name = scan.next();
			
			Member member = null;
			for(int i = 0; i < memberCount; i++) {
				if(memberList[i].id.equals(id)) {
					member = memberList[i];
					break;
				}
			}
			
			if(member != null) {
				member.name = name;
				System.out.println("[수정완료]");
			}
			else {
				System.out.println("실패");
			}
		}
	}
	void printAll() {
		printMemberList();
	}
	
}

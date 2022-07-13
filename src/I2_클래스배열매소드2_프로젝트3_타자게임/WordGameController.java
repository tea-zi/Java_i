package I2_클래스배열매소드2_프로젝트3_타자게임;

import java.util.Scanner;

public class WordGameController {
	Scanner scan; 

	WordDAO wordDAO;
	ScoreDAO scoreDAO;
	MemberDAO memberDAO;
	Member memberlog;
	
	void init() {
		scan = new Scanner(System.in);

		wordDAO = new WordDAO();			
		scoreDAO = new ScoreDAO();
		memberDAO = new MemberDAO();
		
		
		memberDAO.init(100);		
		wordDAO.init(100);
		scoreDAO.init(5);
		wordDAO.insertSampleList();		
		memberlog = null;
				
		mainMeue();
	}
	
	
	void mainMeue() {
		while(true) {
			System.out.println("[1] 회원가입 [2] 로그인 [0] 종료");
			int sel = scan.nextInt();
			if(sel == 1) {
				memberDAO.join();
			}
			else if(sel == 2) {
				memberlog = memberDAO.login();
				if(memberlog == null) {
					System.out.println("[로그인실패]");
				}else {
					System.out.println("[로그인성공]");
					gameMenu();
				}
			}
			else if(sel == 0) {
				System.out.println("[종료]");
				break;
			}
		}
	}
	void gameMenu() {		
		while(true) {
			String menu = "[1] 단어추가 [2] 단어삭제 [3] 게임 [4] 랭킹확인 [0] 로그아웃\n";
			System.out.println(menu);
			int sel = scan.nextInt();
			
			if(sel == 0) {
				System.out.println("[로그아웃]");
				break;
			}else if(sel == 1) {
				wordDAO.insertWord();
			}else if(sel == 2) {
				wordDAO.removeWord();
			}else if(sel == 3) {
				wordDAO.gameStart(memberlog, 10 , scoreDAO);
			}else if(sel == 4) {
				scoreDAO.printRank();
			}
		}
		
	}
	
	
}

package I2_클래스배열매소드2_알고리즘;

import java.util.Arrays;
import java.util.Random;

class OMRCard {
	int[] 답안지 = null;
	boolean[] 답안지체크 = null;
	String studentName;
	int score;
	int size;

	void init(String name, int size) {
		this.studentName = name;
		this.size = size;
		답안지 = new int[size];
		답안지체크 = new boolean[size];
		score = 0;
	}

	void mark(int index, int value) {
		답안지[index] = value;
	}

	void 채점(int 정답[]) {
		for (int i = 0; i < 정답.length; i++) {
			if (정답[i] == 답안지[i]) {
				답안지체크[i] = true;
				score += 10;
			} else {
				답안지체크[i] = false;
			}
		}
	}

	void print(String name) {
		System.out.print(name + " : ");
		for (int i = 0; i < 답안지체크.length; i++) {
			if (답안지체크[i] == true) {
				System.out.print("[o]");
			} else {
				System.out.print("[x]");
			}
		}
		System.out.println(" " + score + "점");
	}
}

class OMRCardDAO {
	OMRCard[] cardList = null;

	void init(int memberSize, Member[] memberList, int cardSize) {

		cardList = new OMRCard[memberSize];
		for (int i = 0; i < memberSize; i++) {
			Member member = memberList[i];
			cardList[i] = new OMRCard();
			cardList[i].init(member.name, cardSize);
		}
	}

	void setAllMarkRandom() {
		Random ran = new Random();
		for (int i = 0; i < cardList.length; i++) {
			for (int j = 0; j < cardList[i].size; j++) {
				int r = ran.nextInt(5) + 1; // 1~5
				cardList[i].mark(j, r);
			}
		}
	}

	void setAll채점(int[] 정답) {
		for (int i = 0; i < cardList.length; i++) {
			cardList[i].채점(정답);
		}
	}

	void printList(Member[] memberList) {
		for (int i = 0; i < cardList.length; i++) {
			cardList[i].print(memberList[i].name);
		}
	}
}

class Member {
	int number;
	String name;
	int rank;
}

class MemberDAO {
	int number = 0;
	Member[] memberList = null;
	int size = 0;

	void init(String[] nameList) {
		number = 1000;
		size = nameList.length;
		memberList = new Member[size];
		for (int i = 0; i < size; i++) {
			memberList[i] = new Member();
			memberList[i].name = nameList[i];
			number += 1;
			memberList[i].number = number;
		}
	}
}

public class I1_클래스배열1_알고리즘_OMRCardDAO {
	public static void main(String[] args) {
		// omr 정답
		int[] 정답답안지 = { 1, 4, 2, 5, 5, 3, 2, 1, 3, 1 };
		// 학생 4명
		String[] nameList = { "이만수", "이철민", "김신영", "이종복" };
		// 학생번호 1000번부터 시작한다.

		MemberDAO memberDAO = new MemberDAO();
		memberDAO.init(nameList);

		OMRCardDAO cardDAO = new OMRCardDAO();
		cardDAO.init(memberDAO.size, memberDAO.memberList, 정답답안지.length);
		cardDAO.setAllMarkRandom();
		cardDAO.setAll채점(정답답안지);
		cardDAO.printList(memberDAO.memberList);

	}
}
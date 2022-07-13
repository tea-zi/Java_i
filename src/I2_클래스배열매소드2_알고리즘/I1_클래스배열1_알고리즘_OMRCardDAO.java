package I2_Ŭ�����迭�żҵ�2_�˰���;

import java.util.Arrays;
import java.util.Random;

class OMRCard {
	int[] ����� = null;
	boolean[] �����üũ = null;
	String studentName;
	int score;
	int size;

	void init(String name, int size) {
		this.studentName = name;
		this.size = size;
		����� = new int[size];
		�����üũ = new boolean[size];
		score = 0;
	}

	void mark(int index, int value) {
		�����[index] = value;
	}

	void ä��(int ����[]) {
		for (int i = 0; i < ����.length; i++) {
			if (����[i] == �����[i]) {
				�����üũ[i] = true;
				score += 10;
			} else {
				�����üũ[i] = false;
			}
		}
	}

	void print(String name) {
		System.out.print(name + " : ");
		for (int i = 0; i < �����üũ.length; i++) {
			if (�����üũ[i] == true) {
				System.out.print("[o]");
			} else {
				System.out.print("[x]");
			}
		}
		System.out.println(" " + score + "��");
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

	void setAllä��(int[] ����) {
		for (int i = 0; i < cardList.length; i++) {
			cardList[i].ä��(����);
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

public class I1_Ŭ�����迭1_�˰���_OMRCardDAO {
	public static void main(String[] args) {
		// omr ����
		int[] �������� = { 1, 4, 2, 5, 5, 3, 2, 1, 3, 1 };
		// �л� 4��
		String[] nameList = { "�̸���", "��ö��", "��ſ�", "������" };
		// �л���ȣ 1000������ �����Ѵ�.

		MemberDAO memberDAO = new MemberDAO();
		memberDAO.init(nameList);

		OMRCardDAO cardDAO = new OMRCardDAO();
		cardDAO.init(memberDAO.size, memberDAO.memberList, ��������.length);
		cardDAO.setAllMarkRandom();
		cardDAO.setAllä��(��������);
		cardDAO.printList(memberDAO.memberList);

	}
}
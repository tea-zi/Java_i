package I1_클래스배열매소드1_알고리즘;

import java.util.Random;

class RanNum {
	int num;
	boolean check;

	void init(int num, boolean check) {
		this.num = num;
		this.check = check;
	}

	void print() {
		System.out.println(num + " ");
	}
}

class RanNumDAO {
	RanNum[] ranList = null;
	int size = 0;
	Random ran = null;

	void init(int size) {
		ran = new Random();
		this.size = size;
		ranList = new RanNum[size];
		for (int i = 0; i < size; i++) {
			ranList[i] = new RanNum();
			ranList[i].init(0, false);
		}
	}

	void setRandom() {
		for (int i = 0; i < size; i++) {
			int rNum = ran.nextInt(5);
			;
			if (ranList[rNum].check == false) {
				ranList[rNum].init(i + 1, true);
			} else {
				i -= 1;
			}
		}
	}

	void printList() {
		for (int i = 0; i < 5; i++) {
			ranList[i].print();
		}
	}
}

public class I1_클래스배열1_알고리즘_중복숫자DAO {
	public static void main(String[] args) {

		// 문제) RanNum 클래스를 활용해서 중복숫자금지 출력
		// num에 1~5사이숫자를 랜덤으로 저장한다. (조건 중복숫자금지)
		RanNumDAO dao = new RanNumDAO();
		dao.init(5);
		dao.setRandom();
		dao.printList();

	}
}
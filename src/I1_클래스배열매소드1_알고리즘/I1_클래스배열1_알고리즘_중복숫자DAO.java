package I1_Ŭ�����迭�żҵ�1_�˰���;

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

public class I1_Ŭ�����迭1_�˰���_�ߺ�����DAO {
	public static void main(String[] args) {

		// ����) RanNum Ŭ������ Ȱ���ؼ� �ߺ����ڱ��� ���
		// num�� 1~5���̼��ڸ� �������� �����Ѵ�. (���� �ߺ����ڱ���)
		RanNumDAO dao = new RanNumDAO();
		dao.init(5);
		dao.setRandom();
		dao.printList();

	}
}
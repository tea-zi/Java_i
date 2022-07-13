package I1_Ŭ�����迭�żҵ�1_�˰���;

import java.util.Arrays;

/*
�Ʒ� data�� �л� ��ȣ�� ������ ���ڿ��� �����ѵ������̴�.
��ȣ�� 1001������ 1004 ���̰�,
������ 0~100�� �����̰� , 60���̻��� �հ��̴�.
*/
class Node1 {
	int number;
	int score;

	void print() {
		System.out.println(number + " " + score);
	}
}

class Return1 {
	Node1[] getWinnerList(String[][] data) {
		// ����1) ������ 60���̻��� �հݻ��̴�.
		// �հݻ����� result �� ������ ����
		Node1[] result = null;
		int idx = 0;
		for (int i = 0; i < data.length; i++) {
			int num = Integer.parseInt(data[i][1]);
			if (num >= 60) {
				idx++;
			}
		}
		result = new Node1[idx];
		int i = 0;
		while (i < idx) {
			for (int j = 0; j < data.length; j++) {
				int num = Integer.parseInt(data[j][1]);
				if (num >= 60) {
					result[i] = new Node1();
					result[i].number = Integer.parseInt(data[j][0]);
					result[i].score = Integer.parseInt(data[j][1]);
					i++;
				}
			}
		}
		return result;
	}

	Node1 getRank1(String[][] data) {

		// ����2) ��ü�л��� 1���л� �Ѹ��� �����͸� result �� ������ ����
		Node1 result = null;
		int max = 0;
		int maxidx = 0;
		for (int i = 0; i < data.length; i++) {
			int num = Integer.parseInt(data[i][1]);
			if (max < num) {
				max = num;
				maxidx = i;
			}
		}
		result = new Node1();
		result.number = Integer.parseInt(data[maxidx][0]);
		result.score = max;
		return result;
	}
}

public class I1_Ŭ�����迭1_�˰���_����1 {
	public static void main(String[] args) {

		String data[][] = { { "1001", "34" }, { "1002", "46" }, { "1003", "81" }, { "1004", "10" }, };

		Return1 re = new Return1();
		Node1 winList[] = re.getWinnerList(data);
		for (int i = 0; i < winList.length; i++) {
			winList[i].print();
		}
		// ------------------------------------------

		Node1 getRank1 = re.getRank1(data);
		getRank1.print();
	}
}
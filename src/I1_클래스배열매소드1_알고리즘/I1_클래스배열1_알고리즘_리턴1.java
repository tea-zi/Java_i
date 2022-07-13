package I1_클래스배열매소드1_알고리즘;

import java.util.Arrays;

/*
아래 data는 학생 번호와 점수를 문자열로 저장한데이터이다.
번호는 1001번에서 1004 번이고,
점수는 0~100점 사이이고 , 60점이상이 합격이다.
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
		// 문제1) 점수가 60점이상은 합격생이다.
		// 합격생들을 result 에 저장후 리턴
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

		// 문제2) 전체학생중 1등학생 한명의 데이터를 result 에 저장후 리턴
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

public class I1_클래스배열1_알고리즘_리턴1 {
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
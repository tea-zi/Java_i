package I1_클래스배열매소드1_평가문제;

class Node3 {
	int number;
	String name;
	String address;
	int scoreList[] = new int[3];
	int total;
	int avg;
	int rank;

	void into(String number, String name, String address, String[] score) {
		this.number = Integer.parseInt(number);
		this.name = name;
		this.address = address;
		for (int i = 0; i < 3; i++) {
			scoreList[i] = Integer.parseInt(score[i + 1]);
			total += scoreList[i];
		}
		avg = total / 3;
	}

	void print() {
		System.out.print(number + " " + name + " " + address + " ");
		for (int i = 0; i < 3; i++) {
			System.out.print(scoreList[i] + " ");
		}
		System.out.println(total + " " + avg + " " + rank);
	}

}

class Return3 {
	Node3[] getList(String[][] student, String[][] score) {
		// 문제1) 아래순서대로 전체 학생 출력
		// [학생번호] [이름] [지역] [국어] [수학] [영어] [총합] [평균] [랭크]
		Node3[] result = null;
		result = new Node3[student.length];
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < score.length; j++) {
				if (score[j][0].equals(student[i][2])) {
					result[i] = new Node3();
					result[i].into(student[i][2], student[i][0], student[i][1], score[j]);
				}
			}

		}
		for (int i = 0; i < result.length; i++) {
			result[i].rank = 1;
			for (int j = 0; j < result.length; j++) {
				if (result[i].total < result[j].total) {
					result[i].rank++;
				}
			}
		}
		return result;
	}
}

public class I1_클래스배열1_평가문제_리턴3 {
	public static void main(String[] args) {

		String[][] student = { { "이만수", "신촌", "1001" }, { "김철민", "강남", "1002" }, { "심장호", "대치", "1003" },
				{ "유재석", "강동", "1004" } };
		String[][] score = { { "1001", "100", "20", "30" }, { "1002", "10", "60", "60" }, { "1003", "23", "63", "31" },
				{ "1004", "45", "30", "35" }, };

		Return3 re = new Return3();
		Node3[] list = re.getList(student, score);

		for (int i = 0; i < list.length; i++) {
			list[i].print();
		}
	}
}
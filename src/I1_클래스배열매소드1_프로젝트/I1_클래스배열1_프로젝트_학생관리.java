package I1_클래스배열매소드1_프로젝트;

class Student {
	int number;
	String name;
	String address;
	int[] scoreList = new int[3];

	void init(String number, String name, String address, String[] score) {
		this.number = Integer.parseInt(number);
		this.name = name;
		this.address = address;
		for (int i = 0; i < 3; i++) {
			scoreList[i] = Integer.parseInt(score[i]);
		}
	}

	void print() {
		System.out.print(number + " " + name + " " + address + " ");
		for (int i = 0; i < 3; i++) {
			System.out.print(scoreList[i] + " ");
		}
		System.out.println();
	}
}

class StudentDAO {

	Student[] getList(String[][] student, String[][] score) {
		// 문제1) 전체 회원리스트를 만들어서 리턴
		Student[] result = null;
		result = new Student[student.length];
		for (int i = 1; i < result.length; i++) {
			String[] arr = new String[3];
			for (int j = 1; j < score.length; j++) {
				if (student[i][2].equals(score[j][0])) {
					if (score[j][1].equals("국어")) {
						arr[0] = score[j][2];
					}
					if (score[j][1].equals("수학")) {
						arr[1] = score[j][2];
					}
					if (score[j][1].equals("영어")) {
						arr[2] = score[j][2];
					}
				}
			}
			result[i] = new Student();
			result[i].init(student[i][2], student[i][0], student[i][1], arr);
		}
		return result;
	}

	Student[] getRank1List(String[][] student, String[][] score) {
		// 문제2) 각과목별 1등의 데이터만 클래스 배열로 만들어서 리턴
		Student[] result = null;
		int max = 0;
		int idx = 0;
		result = new Student[3];
		String[] subject = { "국어", "수학", "영어" };
		for (int i = 0; i < result.length; i++) {
			for (int j = 1; j < score.length; j++) {
				if (score[j][1].equals(subject[i])) {
					int num = Integer.parseInt(score[j][2]);
					if (num > max) {
						max = num;
						idx = j;
					}
				}
			}
			result[i] = new Student();
			String arr[] = new String[3];
			for (int j = 1; j < score.length; j++) {
				if (score[idx][0].equals(score[j][0])) {
					if (score[j][1].equals("국어")) {
						arr[0] = score[j][2];
					}
					if (score[j][1].equals("수학")) {
						arr[1] = score[j][2];
					}
					if (score[j][1].equals("영어")) {
						arr[2] = score[j][2];
					}
				}
			}
			for (int j = 1; j < student.length; j++) {
				if (score[idx][0].equals(student[j][2])) {
					result[i].init(student[j][2], student[j][0], student[j][1], arr);
					break;
				}
			}
		}
		return result;
	}

}

public class I1_클래스배열1_프로젝트_학생관리 {
	public static void main(String[] args) {
		StudentDAO re = new StudentDAO();
		String[][] student = { { "이름", "지역", "번호" }, { "김철만", "신촌", "1001" }, { "오상덕", "강남", "1002" },
				{ "민철이", "대치", "1003" }, { "유재석", "강동", "1004" } };
		String[][] score = { { "번호", "과목", "점수" }, { "1001", "국어", "20" }, { "1002", "국어", "50" },
				{ "1003", "국어", "60" }, { "1004", "국어", "17" }, { "1001", "수학", "65" }, { "1002", "수학", "15" },
				{ "1003", "수학", "80" }, { "1004", "수학", "70" }, { "1001", "영어", "43" }, { "1002", "영어", "90" },
				{ "1003", "영어", "30" }, { "1004", "영어", "70" } };
		Student[] nodeList = re.getList(student, score);
		for (int i = 1; i < nodeList.length; i++) {
			nodeList[i].print();
		}

		System.out.println("---------------------------------------");

		String[] subject = { "국어", "수학", "영어" };
		Student[] rankList = re.getRank1List(student, score);
		for (int i = 0; i < rankList.length; i++) {
			System.out.printf("%s 1등\n", subject[i]);
			rankList[i].print();
		}
	}
}
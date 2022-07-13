package I1_Ŭ�����迭�żҵ�1_������Ʈ;

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
		// ����1) ��ü ȸ������Ʈ�� ���� ����
		Student[] result = null;
		result = new Student[student.length];
		for (int i = 1; i < result.length; i++) {
			String[] arr = new String[3];
			for (int j = 1; j < score.length; j++) {
				if (student[i][2].equals(score[j][0])) {
					if (score[j][1].equals("����")) {
						arr[0] = score[j][2];
					}
					if (score[j][1].equals("����")) {
						arr[1] = score[j][2];
					}
					if (score[j][1].equals("����")) {
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
		// ����2) ������ 1���� �����͸� Ŭ���� �迭�� ���� ����
		Student[] result = null;
		int max = 0;
		int idx = 0;
		result = new Student[3];
		String[] subject = { "����", "����", "����" };
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
					if (score[j][1].equals("����")) {
						arr[0] = score[j][2];
					}
					if (score[j][1].equals("����")) {
						arr[1] = score[j][2];
					}
					if (score[j][1].equals("����")) {
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

public class I1_Ŭ�����迭1_������Ʈ_�л����� {
	public static void main(String[] args) {
		StudentDAO re = new StudentDAO();
		String[][] student = { { "�̸�", "����", "��ȣ" }, { "��ö��", "����", "1001" }, { "�����", "����", "1002" },
				{ "��ö��", "��ġ", "1003" }, { "���缮", "����", "1004" } };
		String[][] score = { { "��ȣ", "����", "����" }, { "1001", "����", "20" }, { "1002", "����", "50" },
				{ "1003", "����", "60" }, { "1004", "����", "17" }, { "1001", "����", "65" }, { "1002", "����", "15" },
				{ "1003", "����", "80" }, { "1004", "����", "70" }, { "1001", "����", "43" }, { "1002", "����", "90" },
				{ "1003", "����", "30" }, { "1004", "����", "70" } };
		Student[] nodeList = re.getList(student, score);
		for (int i = 1; i < nodeList.length; i++) {
			nodeList[i].print();
		}

		System.out.println("---------------------------------------");

		String[] subject = { "����", "����", "����" };
		Student[] rankList = re.getRank1List(student, score);
		for (int i = 0; i < rankList.length; i++) {
			System.out.printf("%s 1��\n", subject[i]);
			rankList[i].print();
		}
	}
}
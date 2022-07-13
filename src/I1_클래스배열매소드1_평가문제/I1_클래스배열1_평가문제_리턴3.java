package I1_Ŭ�����迭�żҵ�1_�򰡹���;

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
		// ����1) �Ʒ�������� ��ü �л� ���
		// [�л���ȣ] [�̸�] [����] [����] [����] [����] [����] [���] [��ũ]
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

public class I1_Ŭ�����迭1_�򰡹���_����3 {
	public static void main(String[] args) {

		String[][] student = { { "�̸���", "����", "1001" }, { "��ö��", "����", "1002" }, { "����ȣ", "��ġ", "1003" },
				{ "���缮", "����", "1004" } };
		String[][] score = { { "1001", "100", "20", "30" }, { "1002", "10", "60", "60" }, { "1003", "23", "63", "31" },
				{ "1004", "45", "30", "35" }, };

		Return3 re = new Return3();
		Node3[] list = re.getList(student, score);

		for (int i = 0; i < list.length; i++) {
			list[i].print();
		}
	}
}
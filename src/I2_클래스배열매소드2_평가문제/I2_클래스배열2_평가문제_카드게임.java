package I2_Ŭ�����迭�żҵ�2_�򰡹���;

import java.util.Random;
import java.util.Scanner;

class card {
	String shape;
	int number;
}

class player {
	card card1;
	card card2;
	int total;
}

class playerDAO {
	player[] p = new player[5];
	int size = 0;

	void playercheck(int sel, card deck[]) {
		int c = 0;
		if (sel > 5) {
		}
		size = sel;
		for (int i = 0; i < size; i++) {
			p[i] = new player();
			p[i].card1 = deck[c];
			c++;
			p[i].card2 = deck[c];
			c++;
			System.out.println("Player" + (i + 1) + " : " + p[i].card1.shape + " " + p[i].card1.number + " / "
					+ p[i].card2.shape + " " + p[i].card2.number);
		}

	}

	void score(String shapeList[]) {
		System.out.println("----------------score----------------");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < shapeList.length; j++) {
				if (p[i].card1.shape.equals(shapeList[j])) {
					p[i].total += j + 1;
				}
				if (p[i].card2.shape.equals(shapeList[j])) {
					p[i].total += j + 1;
				}
			}
			p[i].total += p[i].card1.number;
			p[i].total += p[i].card2.number;

			System.out.println("Player" + (i + 1) + " total : " + p[i].total);
		}
	}

	void compare() {
		int win = 0;
		int max = 0;
		for (int i = 0; i < size; i++) {
			if (max < p[i].total) {
				max = p[i].total;
				win = i + 1;
			}
		}

		boolean check[] = new boolean[size];
		int cnt = 0;

		for (int i = 0; i < size; i++) {
			check[i] = false;
			if (max == p[i].total) {
				check[i] = true;
				cnt++;
			}
		}

		if (cnt == 1) {
			System.out.println("Player" + win + " Win!!!");
		} else {
			for (int i = 0; i < size; i++) {
				if (check[i] == true) {
					System.out.print("Player" + (i + 1) + " ");
				}
			}
			System.out.println("Draw");
		}
	}
}

class cardDAO {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	String shapeList[] = { "���̾�", "��Ʈ", "�����̵�", "Ŭ�ι�" };
	int size = 40;
	card deck[] = new card[size];

	void decksetting() {
		int cnt = 0;
		int num = 0;
		for (int i = 0; i < size; i++) {
			num++;
			deck[i] = new card();
			deck[i].number = num;
			deck[i].shape = shapeList[cnt];
			if (num == 10) {
				cnt++;
				num = 0;
			}
			System.out.println(deck[i].shape + " " + deck[i].number);
		}

	}

	void shuffle() {
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(size);
			card temp = deck[0];
			deck[0] = deck[r];
			deck[r] = temp;
		}

		for (int i = 0; i < size; i++) {
			System.out.println(deck[i].shape + " " + deck[i].number);
		}
	}

	void run() {
		decksetting();
		shuffle();

		playerDAO pl = new playerDAO();

		System.out.print("�����ο�(�ּ�2��/�ִ�5��) : ");
		int sel = scan.nextInt();
		if (sel > 5 || sel <= 1) {
			return;
		}
		pl.playercheck(sel, deck);
		pl.score(shapeList);
		pl.compare();

	}
}

public class I2_Ŭ�����迭2_�򰡹���_ī����� {
	// ī�����
	// 1) ī���� : ���̾� , ��Ʈ , �����̵� , Ŭ�ι�
	// 2) ���� : 1~10
	// 3) �� 40���� �ִ�.
	// 4) �÷��̾�� �Ű��� 40�忡�� 2�徿 �������� ���� ,
	// �� ī���� ������ ū���� �̱��.

	// [��������] ���ڿ� ����� ������ ���� ū���� �̱��.
	// ���ڴ� 1~10 ���̴�.
	// ����� ���̾� , ��Ʈ , �����̵� , Ŭ�ι�
	// ������� 1,2,3,4 ���̴�.
	// ��) �÷��̾�1 [���̾� 4] ==> 1 + 4 ==> 5��
	// ��) �÷��̾�2 [�����̵� 1] ==> 3 + 1 ==> 4��
	// �÷��̾�1 �¸�

	public static void main(String[] args) {
		cardDAO re = new cardDAO();
		re.run();
	}
}

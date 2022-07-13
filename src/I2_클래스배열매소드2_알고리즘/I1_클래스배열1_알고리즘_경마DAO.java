package I2_클래스배열매소드2_알고리즘;

import java.util.Random;

class Horse {
	String name = "";
	int pos = 0;
	int rank = 0;
	boolean win = false;
}

class HorseDAO {
	Random ran = new Random();
	int size = 4;
	Horse[] horseList = new Horse[size];
	int line = 20;
	int track[][] = new int[size][line];

	void init() {
		String names = "abcd";
		for (int i = 0; i < size; i++) {
			horseList[i] = new Horse();
			horseList[i].name = names.charAt(i) + "";
		}

	}

	void PrintHorse() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int n = 0; n < line; n++) {
				if (horseList[i].pos == n) {
					System.out.print("[" + horseList[i].name + "]");
				} else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}

	}

	void Play() {
		boolean loop = true;
		int count = 0;
		while (loop) {
			PrintHorse();
			for (int i = 0; i < size; i++) {
				if (horseList[i].win == true)
					continue;
				int r = ran.nextInt(4) + 1;
				horseList[i].pos += r;
				if (horseList[i].pos >= 19) {
					horseList[i].pos = 19;
					horseList[i].rank = count + 1;
					horseList[i].win = true;
					count += 1;
					if (count >= size) {
						loop = false;
						break;
					}
				}
			}

		}

	}
}

public class I1_클래스배열1_알고리즘_경마DAO {
	public static void main(String[] args) {
		HorseDAO horseDAO = new HorseDAO();
		horseDAO.init();
		horseDAO.Play();
		horseDAO.PrintHorse();
	}
}
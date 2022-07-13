package I2_클래스배열매소드2_평가문제;

import java.util.Arrays;
import java.util.Random;

class lotto {
	int[] data = new int[8];
}

class lottoDAO {
	Random ran = new Random();

	lotto lottoList[] = new lotto[5];

	void setting() {
		int win = 0;
		for (int i = 0; i < 5;) {
			lotto arr = new lotto();
			for (int j = 0; j < 8; j++) {
				int r = ran.nextInt(2);
				if (r == 0) {
					arr.data[j] = 1;
				} else if (r == 1) {
					arr.data[j] = 7;
				}
			}
			System.out.println(Arrays.toString(arr.data));
			// check
			if (win == 0) {
				if (check(arr) == true) {
					lottoList[i] = new lotto();
					lottoList[i] = arr;
					win = 1;
					i++;
				}
			} else {
				if (check(arr) == false) {
					lottoList[i] = new lotto();
					lottoList[i] = arr;
					win = 1;
					i++;
				}
			}
		}
		System.out.println("-----------------------------");
	}

	boolean check(lotto l) {
		int cnt = 0;
		for (int i = 0; i < l.data.length; i++) {
			if (l.data[i] == 7) {
				cnt++;
				if (cnt == 3) {
					return true;
				}
			}
		}
		return false;
	}

	void print() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(lottoList[i].data[j] + " ");
			}
			System.out.println();
		}
	}

	void shuffle() {
		for (int i = 0; i < 100; i++) {
			int r1 = ran.nextInt(5);
			int r2 = ran.nextInt(5);
			lotto temp = lottoList[r1];
			lottoList[r1] = lottoList[r2];
			lottoList[r2] = temp;
		}
	}

	void run() {

		setting();
		print();
		System.out.println("--------------------------");
		shuffle();
		print();
		System.out.println("--------------------------");
	}
}

public class I2_클래스배열2_프로젝트_복권 {
	public static void main(String[] args) {
		// 1. 8칸짜리 복권이 있다.
		// 2. 1이나 7을 랜덤으로 8칸에 저장한다.
		// 3. 7이 연속으로 3개면 당첨 복권이다.
		// 4. 복권 5매를 제작할려고 한다.
		// 5. 단! 1개는 당첨이고 4개는 꽝으로 제작
		lottoDAO re = new lottoDAO();
		re.run();
	}
}
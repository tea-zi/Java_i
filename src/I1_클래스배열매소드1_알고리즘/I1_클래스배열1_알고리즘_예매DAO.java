package I1_클래스배열매소드1_알고리즘;

import java.util.Scanner;

class Seat {
	int num;
	boolean check;

	void setData(int num, boolean check) {
		this.num = num;
		this.check = check;
	}

	void showNum() {
		System.out.print(num + " ");
	}

	void showData() {

		if (check == true) {
			System.out.print("■ ");
		} else {
			System.out.print("□ ");
		}
	}
}

class SeatDAO { // Data Access Object (배열)
	Seat[] seatList = null;
	int size = 0;

	void init(int size) {
		this.size = size;
		seatList = new Seat[size];
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat();
			seatList[i].setData(i + 1, false);
		}
	}

	boolean checkSelect(int num) {
		if (num < 1 || num > size) {
			return false;
		} else {
			return true;
		}
	}

	void play() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			for (int i = 0; i < seatList.length; i++) {
				seatList[i].showNum();
			}
			System.out.println();
			for (int i = 0; i < seatList.length; i++) {
				seatList[i].showData();
			}
			System.out.println();
			System.out.println("번호를 입력하세요 [종료 : 0] >> ");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			}
			if (checkSelect(sel) == false) {
				continue;
			}
			sel -= 1;

			if (seatList[sel].check == false) {
				seatList[sel].check = true;
			}
		}
		scan.close();
	}
}

public class I1_클래스배열1_알고리즘_예매DAO {
	public static void main(String[] args) {

		SeatDAO dao = new SeatDAO();
		dao.init(8);
		dao.play();

	}
}
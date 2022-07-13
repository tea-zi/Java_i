package I2_클래스배열매소드2_프로젝트2_영화예매;

public class Seat {
	String userID;
	int number;
	boolean check;
	
	void showNum() {
		System.out.print(number + " ");
	}
	void showData() {
		
		if(check == true) {
			System.out.print("■ ");
		}
		else {
			System.out.print("□ ");
		}
	}	
}

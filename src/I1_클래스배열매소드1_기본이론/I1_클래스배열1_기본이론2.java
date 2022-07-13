package I1_클래스배열매소드1_기본이론;

class User {
	String name;
	int score;

	void init(String n, int s) { // 인자를 저장하는 변수 "매개변수"
		this.name = n;
		this.score = s;
	}

	void printData() {
		System.out.println(this.name + " : " + this.score);
	}
}

public class I1_클래스배열1_기본이론2 {
	public static void main(String[] args) {
		User[] st = new User[3];
		for (int i = 0; i < st.length; i++) {
			st[i] = new User();
		}
		st[0].init("김철수", 100); // 들어가는 값을 "인자"
		st[1].init("이만수", 20);
		st[2].init("박영희", 70);

		for (int i = 0; i < st.length; i++) {
			st[i].printData();
		}

	}
}
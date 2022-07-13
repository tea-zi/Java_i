package I1_클래스배열매소드1_평가문제;

/*
아래 data는 회원 번호와 이름 판매금액 을 문자열로 저장한데이터이다.
*/
class Node2 {
	int number;
	String name;
	int price;

	void print() {
		System.out.println(number + " " + name + " " + price);
	}
}

class Return2 {
	Node2[] getList(String data) {

		/*
		 * 문제1) 아래와같이 클래스배열로 만들고 리턴 ===================== 10001 김철수 2670 10002 이영희 1950
		 * 10003 유재석 4080 10004 박명수 7130 =====================
		 */
		Node2[] result = null;
		String da[] = data.split("\n");
		result = new Node2[da.length];
		for (int i = 0; i < da.length; i++) {
			String[] d = da[i].split("/");
			result[i] = new Node2();
			result[i].number = Integer.parseInt(d[0]);
			result[i].name = d[1];
			result[i].price = Integer.parseInt(d[2]);
		}
		return result;
	}

	Node2 getRank1(String data) {
		/*
		 * 문제2) 판매금액이 1등인 회원정보 리턴
		 * 
		 */
		Node2 result = null;
		String da[] = data.split("\n");
		int max = 0;
		int idx = 0;
		for (int i = 0; i < da.length; i++) {
			String[] d = da[i].split("/");
			int num = Integer.parseInt(d[2]);
			if (max < num) {
				max = num;
				idx = i;
			}
		}

		result = new Node2();
		String[] d = da[idx].split("/");
		result.number = Integer.parseInt(d[0]);
		result.name = d[1];
		result.price = Integer.parseInt(d[2]);
		return result;
	}
}

public class I1_클래스배열1_평가문제_리턴2 {
	public static void main(String[] args) {
		String data = "";
		data += "10001/김철수/600\n";
		data += "10002/이영희/800\n";
		data += "10001/김철수/1400\n";
		data += "10003/유재석/780\n";
		data += "10002/이영희/950\n";
		data += "10004/박명수/330\n";
		data += "10001/김철수/670\n";
		data += "10003/유재석/3300\n";
		data += "10002/이영희/200\n";
		data += "10004/박명수/6800\n";
		data = data.substring(0, data.length() - 1); // 마지막 글삭제
		System.out.println(data);

		System.out.println("--------------------------");

		Return2 re = new Return2();
		Node2[] list = re.getList(data);
		for (int i = 0; i < list.length; i++) {
			list[i].print();
		}
		// ------------------------------------------------
		System.out.println("-------------------------");
		Node2 rank1 = re.getRank1(data);
		rank1.print();
	}
}
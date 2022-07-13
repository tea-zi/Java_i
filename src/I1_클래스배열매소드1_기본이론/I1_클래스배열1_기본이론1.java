package I1_클래스배열매소드1_기본이론;

class Product {
	String name;
	int price;

	void init(String name, int price) {
		this.name = name;
		this.price = price;
	}

	void printData() {
		System.out.println(name + " " + price);
	}
}

public class I1_클래스배열1_기본이론1 {
	public static void main(String[] args) {

		// -------------------------------------------------
		Product[] prList = new Product[2];
		prList[0] = new Product();
		prList[1] = new Product();

		prList[0].name = "새우깡";
		prList[1].name = "고래밥";
		prList[0].price = 1000;
		prList[1].price = 2000;

		for (int i = 0; i < prList.length; i++) {
			prList[i].printData();
		}
		System.out.println("----------------------");

		Product[] prList2 = new Product[2];
		prList2[0] = new Product();
		prList2[1] = new Product();

		prList2[0].init("새우깡", 1000);
		prList2[1].init("고래밥", 2000);

		for (int i = 0; i < prList.length; i++) {
			prList2[i].printData();
		}

	}
}
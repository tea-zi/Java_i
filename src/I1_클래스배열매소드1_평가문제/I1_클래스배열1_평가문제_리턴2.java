package I1_Ŭ�����迭�żҵ�1_�򰡹���;

/*
�Ʒ� data�� ȸ�� ��ȣ�� �̸� �Ǹűݾ� �� ���ڿ��� �����ѵ������̴�.
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
		 * ����1) �Ʒ��Ͱ��� Ŭ�����迭�� ����� ���� ===================== 10001 ��ö�� 2670 10002 �̿��� 1950
		 * 10003 ���缮 4080 10004 �ڸ�� 7130 =====================
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
		 * ����2) �Ǹűݾ��� 1���� ȸ������ ����
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

public class I1_Ŭ�����迭1_�򰡹���_����2 {
	public static void main(String[] args) {
		String data = "";
		data += "10001/��ö��/600\n";
		data += "10002/�̿���/800\n";
		data += "10001/��ö��/1400\n";
		data += "10003/���缮/780\n";
		data += "10002/�̿���/950\n";
		data += "10004/�ڸ��/330\n";
		data += "10001/��ö��/670\n";
		data += "10003/���缮/3300\n";
		data += "10002/�̿���/200\n";
		data += "10004/�ڸ��/6800\n";
		data = data.substring(0, data.length() - 1); // ������ �ۻ���
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
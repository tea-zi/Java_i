package I2_Ŭ�����迭�żҵ�2_�򰡹���;

import java.util.Arrays;

class item {
	int itemNumber;
	String itemName;
}

class itemDAO {
	item[] itemList = null;

	void itemSetting(String itemData) {
		String data[] = itemData.split(",");
		itemList = new item[data.length];
		for (int i = 0; i < data.length; i++) {
			String item[] = data[i].split("/");
			itemList[i] = new item();
			itemList[i].itemNumber = Integer.parseInt(item[0]);
			itemList[i].itemName = item[1];
		}
	}

	void itemListPrint() {
		for (int i = 0; i < itemList.length; i++) {
			System.out.println(itemList[i].itemNumber + " " + itemList[i].itemName);
		}
	}
}

class User {
	int userNumber;
	String userName;
}

class UserDAO {
	User[] userList = null;

	void userRegistration(String userData) {
		String[] data = userData.split(",");
		userList = new User[data.length];
		for (int i = 0; i < data.length; i++) {
			String user[] = data[i].split("/");
			userList[i] = new User();
			userList[i].userNumber = Integer.parseInt(user[0]);
			userList[i].userName = user[1];
		}
	}

	void userListPrint() {
		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i].userNumber + " " + userList[i].userName);
		}
	}
}

class Cart {
	int userNumber;
	int itemNumber;;
}

class CartDAO {
	Cart[] cartList = null;

	void cartCheck(String cartData) {
		String data[] = cartData.split("\n");
		cartList = new Cart[data.length];
		for (int i = 0; i < data.length; i++) {
			String cart[] = data[i].split("/");
			cartList[i] = new Cart();
			cartList[i].userNumber = Integer.parseInt(cart[0]);
			cartList[i].itemNumber = Integer.parseInt(cart[1]);
		}
	}

	void cartListPrint() {
		for (int i = 0; i < cartList.length; i++) {
			System.out.println(cartList[i].userNumber + " " + cartList[i].itemNumber);
		}
	}

	void purchaseByuser(User[] userList, item[] itemList) {
		for (int i = 0; i < userList.length; i++) {
			int[] cnt = new int[itemList.length];
			for (int j = 0; j < cartList.length; j++) {
				if (userList[i].userNumber == cartList[j].userNumber) {
					for (int k = 0; k < itemList.length; k++) {
						if (cartList[j].itemNumber == itemList[k].itemNumber) {
							cnt[k]++;
						}
					}
				}
			}
			System.out.print(userList[i].userName + " ==> ");
			int c = 0;
			for (int j = 0; j < cnt.length; j++) {
				if (cnt[j] == 0) {
					continue;
				}
				if (c > 0) {
					System.out.print(", ");
				}
				System.out.print(itemList[j].itemName + cnt[j]);
				c++;
			}
			System.out.println();
		}
	}

	void purchaseByitem(User[] userList, item[] itemList) {
		for (int i = 0; i < itemList.length; i++) {
			int iNum = itemList[i].itemNumber;
			boolean check[] = new boolean[userList.length];
			for (int j = 0; j < cartList.length; j++) {
				int ciNum = cartList[j].itemNumber;
				int cuNum = cartList[j].userNumber;
				if (iNum == ciNum) {
					for (int k = 0; k < userList.length; k++) {
						int uNum = userList[k].userNumber;
						if (cuNum == uNum) {
							check[k] = true;
						}
					}
				}
			}
			System.out.print(itemList[i].itemName + " ==> ");
			int cnt = 0;
			for (int j = 0; j < check.length; j++) {
				if (check[j] == true) {
					if (cnt > 0) {
						System.out.print(" ,");
					}
					System.out.print(userList[j].userName);
					cnt++;
				}
			}
			System.out.println();
		}
	}
}

public class I2_Ŭ�����迭2_������Ʈ_īƮ {
	public static void main(String[] args) {
		String itemData = "1001/����,1002/�����,1003/ĭ��";
		String userData = "3001/�̸���,3002/��ö��,3003/�̿���";

		String cartData = "";
		cartData += "3001/1001\n";
		cartData += "3001/1001\n";
		cartData += "3003/1002\n";
		cartData += "3001/1001\n";
		cartData += "3001/1003\n";
		cartData += "3003/1002\n";
		cartData += "3003/1001\n";
		cartData += "3002/1001";

		itemDAO i = new itemDAO();
		i.itemSetting(itemData);
		i.itemListPrint();
		System.out.println("---------------");
		UserDAO u = new UserDAO();
		u.userRegistration(userData);
		u.userListPrint();
		System.out.println("---------------");
		CartDAO c = new CartDAO();
		c.cartCheck(cartData);
		c.cartListPrint();
		System.out.println("---------------");
		// ����1) ȸ���� ������ ���Ÿ�� ���
		// ��) �̸���==> ����3,ĭ��1 / ��ö�� ==> ����1 / �̿��� ==> ����2,�����1
		c.purchaseByuser(u.userList, i.itemList);

		System.out.println("----------------------");
		// ����2) �����ۺ��� ������ ȸ���̸� ���
		// ��) ����==> �̸���,��ö��,�̿��� / �����==> �̿��� / ĭ��==> �̸���
		c.purchaseByitem(u.userList, i.itemList);
	}
}
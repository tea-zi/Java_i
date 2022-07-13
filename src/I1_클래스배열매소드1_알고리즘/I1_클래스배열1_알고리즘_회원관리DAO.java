package I1_클래스배열매소드1_알고리즘;

import java.util.Scanner;

class Member {
	String id;
	String name;
}

class ClientDAO {
	Scanner scan = new Scanner(System.in);
	Member[] clientList = new Member[100];
	int clientCount = 0;

	void insertClient(Member client) {
		clientList[clientCount] = client;
		clientCount += 1;
	}

	void removeClient(String id) {
		int index = -1;
		for (int i = 0; i < clientCount; i++) {
			if (clientList[i].id.equals(id)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("삭제없음");
		} else {
			for (int i = index; i < clientCount - 1; i++) {
				clientList[i] = clientList[i + 1];
			}
			clientCount -= 1;
		}
	}

	void printClintList() {
		for (int i = 0; i < clientCount; i++) {
			System.out.println(clientList[i].id + " " + clientList[i].name);
		}
	}

	void join() {
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		System.out.println("이름 입력 : ");
		String name = scan.next();

		Member client = new Member();
		client.id = id;
		client.name = name;
		insertClient(client);
	}

	void remove() {
		System.out.println("아이디입력 : ");
		String id = scan.next();
		removeClient(id);
	}
}

public class I1_클래스배열1_알고리즘_회원관리DAO {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ClientDAO clientDAO = new ClientDAO();
		while (true) {
			System.out.println("[1]추가 [2]삭제 [3]출력 [0]종료");
			int sel = scan.nextInt();
			if (sel == 1) {
				clientDAO.join();
			} else if (sel == 2) {
				clientDAO.remove();
			} else if (sel == 3) {
				clientDAO.printClintList();
			} else if (sel == 0) {
				break;
			}
		}
	}
}
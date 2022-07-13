package I2_클래스배열매소드2_알고리즘;

class Student {
	String name;
}

class StudentDAO {
	Student[] stList;
	int stCount;
	SubjectDAO subDAO;

	void init(SubjectDAO subDao) {
		this.subDAO = subDao;
	}

	void test(String stName) {
		Subject[] subList; // 학생 이름이 있는 과목의 배열이 필요하다. aaa ==> {kor , math}

		subList = subDAO.getOneStudentSubList(stName);

		for (int i = 0; i < subList.length; i++) {
			System.out.println(subList[i].stName + " " + subList[i].subName);
		}

	}
}

class Subject {
	String subName;
	String stName;
}

class SubjectDAO {
	Subject[] subList;
	int subCount;
	StudentDAO stDAO;

	void init(StudentDAO stDAO) {
		this.stDAO = stDAO;
	}

	Subject[] getOneStudentSubList(String st) {
		int count = 0;
		for (int i = 0; i < subCount; i++) {
			if (st.equals(subList[i].stName)) {
				count += 1;
			}
		}
		System.out.println(count);

		Subject[] temp = new Subject[count];
		int k = 0;
		for (int i = 0; i < subCount; i++) {
			if (st.equals(subList[i].stName)) {
				temp[k] = subList[i];
				k += 1;
			}
		}
		return temp;
	}

}

public class I1_클래스배열1_알고리즘_학생성적관리DAO {
	public static void main(String[] args) {
		String stData[] = { "aaa", "bbb", "ccc" };
		String subData[][] = { { "kor", "aaa" }, { "kor", "ccc" }, { "math", "aaa" }, { "math", "bbb" },
				{ "eng", "ccc" }, };
		StudentDAO stDAO = new StudentDAO();
		SubjectDAO subDAO = new SubjectDAO();

		Student[] stList = new Student[stData.length];
		for (int i = 0; i < stData.length; i++) {
			Student st = new Student();
			st.name = stData[i];
			stList[i] = st;

		}
		stDAO.stList = stList;
		stDAO.stCount = stData.length;

		Subject[] subList = new Subject[subData.length];
		for (int i = 0; i < subData.length; i++) {
			Subject sbj = new Subject();
			sbj.subName = subData[i][0];
			sbj.stName = subData[i][1];
			subList[i] = sbj;
		}
		subDAO.subList = subList;
		subDAO.subCount = subData.length;

		stDAO.init(subDAO);
		subDAO.init(stDAO);

		stDAO.test("aaa");

	}
}
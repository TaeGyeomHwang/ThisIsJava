package ch08.example.exam4;

import java.util.*;

public class StudentDriver {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Student[] student = new Student[2];
		String[] name = { "선남", "선녀" };

		for (int i = 0; i < student.length; i++) {
			student[i] = new Student(name[i]);

			try {
				invokeMethod(student[i], "퀴즈", "setQuiz", "valScore");
				invokeMethod(student[i], "중간시험", "setMidterm", "valScore");
				invokeMethod(student[i], "기말시험", "setFinalterm", "valScore");
				System.out.println(student[i].getString());

				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void invokeMethod(Student s, String keyword, String method1, String method2) throws Exception {
		while (true) {
			System.out.printf(s.getName() + "의 " + keyword + "점수를 입력하라: ");
			int score = Integer.parseInt(scan.nextLine());
			s.getClass()
				.getDeclaredMethod(method1, int.class)
				.invoke(s, score);
			//이 함수를 호출하면 Object 타입이 되므로 강제 형변환 한다.
			if ((boolean) s.getClass()	
					.getDeclaredMethod(method2, int.class)
					.invoke(s, score)) {
				break;
			}
		}
	}
}

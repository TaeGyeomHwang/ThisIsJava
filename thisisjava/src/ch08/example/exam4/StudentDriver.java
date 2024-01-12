package ch08.example.exam4;

import java.util.*;

public class StudentDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] student = new Student[2];
		String[] name = { "선남", "선녀" };

		for (int i = 0; i < student.length; i++) {
			student[i] = new Student(name[i]);

			System.out.printf(name[i] + "의 퀴즈 점수를 입력하라: ");
			int quiz = Integer.parseInt(scan.nextLine());
			if (quiz < 0 || quiz > 100) {
				System.out.println("적절하지 않은 점수다.");
				do {
					System.out.printf(name[i] + "의 퀴즈 점수를 입력하라: ");
					quiz = Integer.parseInt(scan.nextLine());
				} while (quiz < 0 && quiz > 100);
			}
			System.out.printf(name[i] + "의 중간시험 점수를 입력하라: ");
			int midterm = Integer.parseInt(scan.nextLine());
			if (midterm < 0 || midterm > 100) {
				System.out.println("적절하지 않은 점수다.");
				do {
					System.out.printf(name[i] + "의 중간시험 점수를 입력하라: ");
					midterm = Integer.parseInt(scan.nextLine());
				} while (midterm < 0 && midterm > 100);
			}
			System.out.printf(name[i] + "의 기말시험 점수를 입력하라: ");
			int finalterm = Integer.parseInt(scan.nextLine());
			if (finalterm < 0 || finalterm > 100) {
				System.out.println("적절하지 않은 점수다.");
				do {
					System.out.printf(name[i] + "의 기말시험 점수를 입력하라: ");
					finalterm = Integer.parseInt(scan.nextLine());
				} while (finalterm < 0 && finalterm < 0);
			}

			student[i].setQuiz(quiz);
			student[i].setMidterm(midterm);
			student[i].setFinalterm(finalterm);

			System.out
					.println(name[i] + "의 총점은 " + totalScore(student[i]) + "이고 학점은 " + totalGrade(student[i]) + "이다.");
		}
	}

	private static Double totalScore(Student s) {
		return s.setTotalScore();
	}

	private static String totalGrade(Student s) {
		return s.setTotalGrade();
	}

}
package ch06.example;

import java.util.*;

public class Student1Practice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 학급 수 설정
		System.out.printf("학급 수를 입력하세요 --> ");
		int classNum = scan.nextInt();
		// 입력받은 수만큼 총 학급 수 설정
		// 객체의 배열을 생성 시 객체 자체가 아닌 객체를 참조하는 배열이 생성됨.
		// 따라서 student 인스턴스는 Student1 객체의 배열에 대한 참조를 담을 수 있는 배열을 생성한 것.
		Student1[][] student = new Student1[classNum][];

		// 학급 수 만큼 학생 키 설정
		for (int i = 0; i < classNum; i++) {
			System.out.printf("%d반 학생 수를 입력하세요 --> ", i + 1);
			int studentNum = scan.nextInt();
			scan.nextLine();
			// 입력받은 수 만큼 각 학급의 학생 수 설정
			student[i] = new Student1[studentNum];

			// 열의 크기 만큼 학생의 키 설정 반복
			for (int j = 0; j < studentNum; j++) {
				System.out.println("---------------입력---------------");
				System.out.printf("%d반의 %d번 학생의 이름과 키를 공백으로 구분해서 입력하세요 --> ", i + 1, j + 1);
				String studentInfo = scan.nextLine();

				// 입력받은 이름과 키를 공백으로 구분
				String[] info = studentInfo.split(" ");
				String name = info[0];
				String height = info[1];

				// 분리한 이름과 키를 ()를 붙여서 저장
				student[i][j] = new Student1(name, height);
			}
		}

		// 각 반 학생의 키 출력
		for (int i = 0; i < student.length; i++) {
			System.out.printf("%d반 학생들의 키: ", i + 1);
			for (int j = 0; j < student[i].length; j++) {
				if (j == student[i].length - 1) {
					System.out.println(student[i][j].getName()+"("+student[i][j].getHeight()+")");
				} else {
					System.out.print(student[i][j].getName()+"("+student[i][j].getHeight()+")" + ", ");
				}
			}
		}
	}

}

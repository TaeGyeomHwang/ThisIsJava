package ch05;

import java.util.*;

public class ArrayPractice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 학급 수 설정
		System.out.printf("학급 수를 입력하세요 --> ");
		int classNum = scan.nextInt();
		// 입력받은 수만큼 행 설정
		String[][] classHeights = new String[classNum][];
//		String[][] className = new String[classNum][];

		// 학급 수 만큼 학생 키 설정
		for (int i = 0; i < classNum; i++) {
			System.out.printf("%d반 학생 수를 입력하세요 --> ", i + 1);
			int studentNum = scan.nextInt();
			// 값만 취하고 enter는 사용하지 않는 nextInt와 같은 함수를 사용할 때는
			// 개행문자를 제거하는 습관을 들이는 것이 좋다.
			scan.nextLine();
			// 입력받은 수 만큼 열 설정
			classHeights[i] = new String[studentNum];
//			className[i] = new String[studentNum];

			// 열의 크기 만큼 학생의 키 설정 반복
			for (int j = 0; j < studentNum; j++) {
				System.out.println("---------------입력---------------");
				System.out.printf("%d반의 %d번 학생의 이름과 키를 공백으로 구분해서 입력하세요 --> ", i + 1, j + 1);
				String studentInfo = scan.nextLine();

				// nextLine과 split을 사용하지 말고 next()를 쓰면 공백 단위로 입력을 받을 수도 있다.
				// 이 경우 위의 nextInt에서 입력을 받을 때 값과 enter를 입력했기 때문에
				// scan.nextLine()을 써줘서 버퍼에 남아있는 개행문자를 제거해야 한다.

				// 입력받은 이름과 키를 공백으로 구분
				String[] info = studentInfo.split(" ");

				// 분리한 이름과 키를 ()를 붙여서 저장
				classHeights[i][j] = info[0] + "(" + info[1] + ")";

//				분리한 이름과 키 값을 각각의 배열에 할당
//				className[i][j] = info[0];
//				classHeights[i][j] = info[1];
			}
		}

		// 각 반 학생의 키 출력
		for (int i = 0; i < classHeights.length; i++) {
			System.out.printf("%d반 학생들의 키: ", i + 1);
			for (int j = 0; j < classHeights[i].length; j++) {
				if (j == classHeights[i].length - 1) {
					System.out.println(classHeights[i][j]);
//					System.out.print(className[i][j]);
//					System.out.println("(" + classHeights[i][j] + ")");
				} else {
					System.out.print(classHeights[i][j] + ", ");
//					System.out.print(className[i][j]);
//					System.out.print("(" + classHeights[i][j] + "), ");
				}
			}
		}
	}

}

//	이런 형태로 배열을 선언하면 생기는 문제점? 학생 한명을 나타내는데 사용하는 두 배열이 아무 연관이 없다.
//	사람 한명에 대한 데이터를 추가하려면 계속해서 배열을 만들어야 한다. 
//	이런 문제를 해결하기 위해 접근할 수 있는 방법으로 여러 속성을 묶어주는 class가 있다.

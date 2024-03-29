package ch04.practice;

import java.util.*;

public class UpDownGame {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String select;
		int input = 0;

		do {
			// 랜덤 값 생성
			int result = (int) (Math.random() * 100) + 1;
			// 추측 횟수 생성
			int count = 0;
			System.out.print(result);
			
			while (input != result) {
				// 사용자 값 입력
				System.out.println("숫자를 입력하십시오 -->");
				input = scan.nextInt();
				//	입력한 개행문자 제거
				scan.nextLine();

				// 입력 값이 작을 경우
				if (input < result) {
					System.out.println("정답은 해당 숫자보다 큽니다.");
					count++;
				}
				// 입력 값이 클 경우
				else if (input > result) {
					System.out.println("정답은 해당 숫자보다 작습니다.");
					count++;
				}
			}

			// 입력 값을 맞췄을 경우
			System.out.println("정답입니다.");
			System.out.println("추측 횟수는 [" + count + "] 번 입니다.");
			System.out.printf("계속 하시겠습니까?(y/n)  --> ");
			select = scan.nextLine();

		} while (select.equals("y"));

	}

}

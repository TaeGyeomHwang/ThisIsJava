package ch05;

import java.util.*;

public class practice09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		int stuNum = 0;
		int[] scores = {};
		int maxScore = 0;
		int totalScore = 0;
		
		while (true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------------------");
			System.out.printf("선택> ");
			input = scan.nextInt();

			if (input == 1) {
				System.out.printf("학생 수> ");
				stuNum = scan.nextInt();
				scan.nextLine();
				scores = new int[stuNum];

			} else if (input == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = scan.nextInt();
					scan.nextLine();
				}

			} else if (input == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]: " + scores[i]);
				}

			} else if (input == 4) {
				for (int i = 0; i < scores.length; i++) {
					if (maxScore < scores[i]) {
						maxScore = scores[i];
					}
					totalScore += scores[i];
				}
				System.out.println("최고 점수: " + maxScore);
				System.out.println("평균 점수: " + totalScore / stuNum);

			} else if (input == 5) {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}

}

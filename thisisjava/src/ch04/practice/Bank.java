package ch04.practice;

import java.util.*;

public class Bank {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 현재 금액 선언
		int input = 0;
		int currentMoney = 0;

		// 조건> do-while문 사용
		do {
			// 사용자 입력
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("--------------------------------");
			System.out.printf("선택> ");
			input = scan.nextInt();

			// 조건> switch-case문 사용
			switch (input) {
			
			case 1:	// 예금일 경우
				System.out.printf("예금액>");
				int deposit = scan.nextInt();
				currentMoney += deposit;
				continue;

			case 2:	// 출금일 경우
				System.out.printf("출금액>");
				int withdrawal = scan.nextInt();

				// 잔고보다 많은 금액을 인출하려고 했을 경우
				if (currentMoney < withdrawal) {
					System.out.println("잔고 부족");
					System.out.println("부족 금액 : " + (withdrawal - currentMoney) + "원");
				} else {
					currentMoney -= withdrawal;
				}
				continue;
				
			case 3:	// 잔고일 경우
				System.out.println("잔고>"+currentMoney);
				continue;
				
			case 4:	// 종료일 경우
				break;
			}
		} while (input != 4);
	}

}

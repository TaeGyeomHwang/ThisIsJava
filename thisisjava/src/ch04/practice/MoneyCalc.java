package ch04.practice;

import java.text.*;
import java.util.*;

public class MoneyCalc {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// DecimalFormat 클래스를 이용해서 숫자에 , 찍기
		DecimalFormat decFormat = new DecimalFormat("###,###");
		int moneyLeft = 10000;

		do {
			// 현재 가진 돈 출력
			System.out.printf("현재 가진 돈은 %s입니다.\n", decFormat.format(moneyLeft));

			// 사용할 돈 입력
			System.out.printf("얼마를 사용하시겠습니까? -->");
			int price = scan.nextInt();

			// 사용할 돈과 현재 가진 돈 비교
			// 사용할 돈이 현재 가진 돈보다 작거나 같을 경우
			if (price <= moneyLeft) {
				moneyLeft -= price;
			} else { // 그 외의 경우
				System.out.println("다시 입력해주세요, 사용 범위가 틀렸습니다.");
			}
		} while (moneyLeft != 0); // 현재 가진 돈이 0일 경우 종료
		System.out.println("모든 돈을 사용하였습니다.");
	}
}

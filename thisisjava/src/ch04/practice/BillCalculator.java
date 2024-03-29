package ch04.practice;

import java.util.*;

public class BillCalculator {

	public static void main(String[] args) {
		int discount, result;
		
		// 구매금액 입력
		Scanner scan = new Scanner(System.in);
		System.out.printf("구매 금액을 입력하세요 -->");
		int input = scan.nextInt();
		
		// 30만원 이상 구매?
		if(input>=300000) {
			// 할인액 설정
			discount = 30000;
		}// 30만원 미만 10만원 이상 구매?
		else if(300000>input && input>=100000) {
			discount = 5000;
		}else {
			discount =0;
		}
		
		// 청구금액 = 구매금액 - 할인액
		result = input - discount;
		
		// 구매금액, 할인액, 청구금액 출력
		System.out.println("구매금액 : " + input);
		System.out.println("할인액 : " + discount);
		System.out.println("청구 금액 : " + result);
	}

}

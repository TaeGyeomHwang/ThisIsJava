package ch04Practice;

import java.util.*;

public class Fibonacci {

	public static int recursion(int n) {
		if (n == 0)
			return 0; // 첫 번째 원소라면
		else if (n == 1)
			return 1; // 두 번째 원소라면
		else {
			return recursion(n - 2) + recursion(n - 1);
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.printf("수를 입력해주세요 --> ");
		// 수 입력
		int input = scan.nextInt();

		// 입력한 수 만큼 재귀함수 호출
		for (int i = 0; i <= input; i++) {
			//	해당 번째의 피보나치 수 출력
			System.out.print(recursion(i) + " ");
		}

	}

}

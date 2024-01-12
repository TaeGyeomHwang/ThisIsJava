package ch04Practice;

import java.util.*;

public class Equation {
	public static void main(String[] args) {

		// a, b, c값 입력
		Scanner scan = new Scanner(System.in);
		System.out.printf("a값을 입력하세요 --> ");
		int a = scan.nextInt();
		System.out.printf("b값을 입력하세요 --> ");
		int b = scan.nextInt();
		System.out.printf("c값을 입력하세요 --> ");
		int c = scan.nextInt();

		System.out.println("해당 방정식을 만족하는 모든 해를 출력합니다... ");
		// 조건 만족하는 x값 찾기
		for (int x = 0; x < c; x++) {
			// 조건 만족하는 y값 찾기
			for (int y = 0; y < c; y++) {
				//	방정식 조건
				if (a * x + b * y == c) {
					// (x,y) 출력
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}
	}
}

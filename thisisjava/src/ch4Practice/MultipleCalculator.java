package ch4Practice;

import java.util.*;

public class MultipleCalculator {

	public static void main(String[] args) {
		//	값 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("값을 입력해주세요. -> ");
		int input = scan.nextInt();
		
		//	3의 배수인가?
		if(input%3==0) {
			System.out.println("3의 배수이다.");
		}
		//	4의 배수인가?
		if(input%4==0) {
			System.out.println("4의 배수이다.");
		}
		//	6의 배수인가?
		if(input%6==0) {
			System.out.println("6의 배수이다.");
		}
		//	8의 배수인가?
		if(input%8==0) {
			System.out.println("8의 배수이다.");
		}
		//	그 이외의 경우
		if(input%3!=0 && input%4!=0 && input%6!=0 && input%8!=0) {
			System.out.println("어느 배수도 아니다.");
		}
		
		scan.close();
	}
	
}

package ch03;

import java.util.*;

public class EqualExam {

	public static void main(String[] args) {
		String str = new String("abc");
		System.out.println(str == "abc"); // 객체 타입은 주소를 저장하므로 두 개는 같지 않다.
		System.out.println(str.equals("abc")); // equals 메서드를 쓰면 값을 비교할 수 있다.

		Scanner scan = new Scanner(System.in);
		System.out.print("패스워드를 입력하세요 -> ");
		String str1 = scan.nextLine();
		
		if (str1.equals("codehows")) {
			System.out.println("환영합니다.");
		} else {
			System.out.println("잘못 입력했습니다.");
		}
		scan.close();
	}

}

package ch12;

import java.util.ArrayList;

public class WrapperExam {

	public static void main(String[] args) {
//		Integer i = new Integer(100); // deprecated 되었다. 앞으로 사용 안하기를 권장된다는 것.
//		Integer i = 100; // 따라서 래퍼 클래스는 이런 식으로 원시 타입에 값을 넣듯이 초기화한다.
//
//		int a = i.intValue(); // 래핑된 값을 언박싱하는 방법
//		int b = 10;
//		System.out.println(i+b);	//	언박싱하지 않더라도 자바에서 자동으로 언박싱 해준다.

		Integer a = 300;
		Integer b = 300;
		System.out.println(a == b); // 래퍼 객체는 내부 값이 아닌 객체 번지를 비교한다.
		System.out.println(a.equals(b)); // 따라서 값을 비교하려면 equals()를 사용한다.

		Character c = 'A';
		Character d = 'A';
		System.out.println(c.equals(d));	//	유니코드 값으로 비교하므로 true다.
		
	}

}

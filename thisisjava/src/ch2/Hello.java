package ch2;

import java.util.*;

public class Hello {
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("상품의 가격: %d원\n",123);
		System.out.printf("상품의 가격: %6d원\n",123);
		System.out.printf("상품의 가격: %-6d원\n",123);
		System.out.printf("상품의 가격: %06d원\n",123);
		
		System.out.printf("원의 반지름을 입력하세요 -> ");
		double a = scan.nextDouble();
		System.out.printf("반지름이 10인 원의 넓이: %.2f", Math.PI*a*a);
		scan.close();
		
//		byte byteValue = 10;
//		byte result = byteValue + byteValue;
//		안된다.
	}
}

package ch03;

import java.math.*;

public class AccuracyExample {

	public static void main(String[] args) {
//		int apple = 1;
//		double pieceUnit = 0.1;	//	실수로는 정확한 연산이 불가능하다.
//		int number = 7;
//		double result = apple - number * pieceUnit;

		//	방법 1
//		int apple = 1;
//		int number = 7;
//		double result = (apple * 10 - number) / 10.0; // 정수 연산으로 바꾸고 계산해야 한다.
		
		//	방법 2
		BigDecimal apple = new BigDecimal(1);
		BigDecimal pieceUnit = new BigDecimal("0.1");	//	BigDecimal은 문자열로 넣어도 변환해서 동작함
		BigDecimal number = new BigDecimal(7);
		
		BigDecimal tmp = number.multiply(pieceUnit);
		BigDecimal result = apple.subtract(tmp);	//	BigDecimal로 계산한 모든 값은 정확하게 계산된다.
		
		System.out.println(result);
	}

}

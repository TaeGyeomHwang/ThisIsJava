package ch07;

public class CalculatorExam {

	public static void main(String[] args) {
		//	메서드를 재정의하는 것을 오버라이딩이라고 한다.
		int r = 10;
		
		Calculator cal = new Calculator();
		System.out.println(cal.areaCircle(r));
		
		Computer com = new Computer();
		System.out.println(com.areaCircle(r));

	}

}

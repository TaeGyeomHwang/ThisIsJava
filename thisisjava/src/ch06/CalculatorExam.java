package ch06;

public class CalculatorExam {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.plus(10, 10);
		cal.powerOn();
		System.out.println(cal.plus(10, 10));
		System.out.println(cal.minus(10, 10));
		System.out.println(cal.plus(10.0, 10.0));
		System.out.println(cal.sum(new int[] {1,2,3,1}));
		cal.powerOff();
	}

}

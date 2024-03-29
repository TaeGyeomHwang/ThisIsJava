package ch06;

public class Rectangle {
	Rectangle() {
		System.out.println("Rectangle 객체를 생성하였습니다.");
	}

	 void round(int a, int b) {
		System.out.println("가로가 " + a + ", 세로가 " + b + "인 직사각형의 둘레: " + (a * 2 + b * 2));
	}

	void area(int a, int b) {
		System.out.println("가로가 " + a + ", 세로가 " + b + "인 직사각형의 넓이: " + a * b);
	}

	void area(double a, double b) {
		System.out.println("가로가 " + a + ", 세로가 " + b + "인 직사각형의 넓이: " + a * b);
	}
}

package ch06;

public class CarExam {

	public static void main(String[] args) {
		// 자동차 인스턴스 생성
		Car myCar = new Car("현대자동차", 60, true);
//		System.out.println("내 차의 모델명: " + myCar.model);
//		System.out.println("내 차의 속도: " + myCar.speed);
//		System.out.println("내 차의 시동여부: " + myCar.start);
		System.out.println(myCar.drive("김김김"));
	}

}

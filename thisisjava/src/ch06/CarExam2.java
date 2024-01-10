package ch06;

public class CarExam2 {

	public static void main(String[] args) {
		Car car1 = new Car();	//	인스턴스 객체 생성
		Car car2 = new Car();
		Car car3 = new Car();

//		car1.gas = 10;
//		car2.gas = 20;
//		car1.gas = 30;
		
		System.out.println(car1.gas);	//	클래스 멤버로 선언된 값은 인스턴스 객체들이 모두 공유한다.
		System.out.println(car2.gas);
		System.out.println(car3.gas);
		Car.printGas();	//	Math 라이브러리와 같은 형태를 지닌다. 인스턴스를 만들지 않고도 사용할 수 있는 필드.
	}

}

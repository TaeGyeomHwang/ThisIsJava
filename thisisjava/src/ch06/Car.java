package ch06;

public class Car {
	String model = "현대자동차"; // 명시적 초기화
	private int speed = 60;
	static int gas; // 클래스(정적) 필드로 선언하면 같은 클래스로 선언된 각각의 인스턴스가 값을 공유하게 된다.
	boolean start = true;

	static {	//	블록으로 값을 초기화할 수도 있다.
		gas = 20;
	}
	
	{ // 초기화 블록
		model = "기아자동차";
		speed = 30;
	}

	public Car() { // 생성자 순으로 우선순위를 가져간다.
		model = "자동차";
	}

	Car(String model) { // 파라미터의 개수가 같더라도 타입이 다르거나 순서가 다르면 오버로딩이 가능하다.
		this(model, 60, true); // 파라미터와 필드명이 같으면 구분이 어려우므로 this로 표기
	}

	Car(int speed) { // this()를 통해 간결하게 코드 작성 가능.
		this("현대자동차", speed, true);
	}

	Car(String model, int speed, boolean start) {
		this.model = model;
		this.speed = speed;
		this.start = start;
	}

	String drive(String name) { // 메서드를 만들때 리턴할 값을 표시한다.
		return name + "을 태우고 " + this.speed + "의 속도로 출발합니다";
	}

	public static void printGas() {
		System.out.println(gas);
	}
}

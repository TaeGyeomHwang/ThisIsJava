package ch06;

public class Calculator {
	boolean power = false;
	
	//	전원 켜기
	void powerOn() {
		this.power = true;
		System.out.println("전원을 켭니다.");
	}

	//	전원 끄기
	void powerOff() {
		this.power = false;
		System.out.println("전원을 끕니다.");
	}

	int plus(int x, int y) {
		int result = 0;
		if(power) {
			result = x + y;
		}else {
			System.out.println("전원이 꺼져있습니다.");
		}
		return result;
	}
	
	double plus(double x, double y) {	//	오버로딩
		double result = 0;
		if(power) {
			result = x + y;
		}else {
			System.out.println("전원이 꺼져있습니다.");
		}
		return result;
	}
	
	int minus(int x, int y) {
		int result = 0;
		if(power) {
			result = x - y;
		}else {
			System.out.println("전원이 꺼져있습니다.");
		}
		return result;
	}
	
//	int sum(int ... values) {
//		int result = 0;
//		for(int v : values) {
//			result += v;
//		}
//		return result;
//	}	
	
	int sum(int[] values) {	//	이 형태를 더 많이 쓴다.
	int result = 0;
	for(int v : values) {
		result += v;
	}
	return result;
}
}

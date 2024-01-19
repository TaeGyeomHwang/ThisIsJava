package ch16;

public class LambdaExam {

	public static void main(String[] args) {
//		Computer com = new Computer();
//
//		action(5.0, 5.0, Math::pow); // 메서드 참조 방식
//		action(10.0, 5.0, (x, y) -> Math.pow(x, y));
//
//		action(3.0, 3.5, com::instanceMethod);
//		action(3.0, 3.5, (x, y) -> {
//			return com.instanceMethod(x, y);
//		});
		
//		Computer com = get(() -> new Computer());
		Computer com = get(Computer::new);

	}

	public static void action(double x, double y, Calculable calculable) {
		System.out.println("calculate 메소드 실행");
		System.out.println(calculable.calculate(x, y));
		System.out.println("calculate 메소드 종료");
	}

	public static Computer get(Creatable creatable) {
		return creatable.create();
	}
}

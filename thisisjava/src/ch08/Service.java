package ch08;

public interface Service {
	//	인터페이스-구현-인터페이스화 해야 사용할 수 있는 메서드. 반드시 구현 객체를 만들어야 한다.
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속 코드");
		defaultCommon();
	}
	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속 코드");
		defaultCommon();
	}
	private void defaultCommon() {
		System.out.println("defaultMethod 종속 코드 A");
		System.out.println("defaultMethod 종속 코드 B");
	}
	
	static void staticMethod1() {
		System.out.println("staticMethod1 종속 코드");
		staticCommon();
	}
	static void staticMethod2() {
		System.out.println("staticMethod2 종속 코드");
		staticCommon();
	}
	static void staticCommon() {
		System.out.println("staticMethod 종속 코드 C");
		System.out.println("staticMethod 종속 코드 D");
	}
}

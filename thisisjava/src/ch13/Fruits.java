package ch13;

public class Fruits<T> {
	private T kind;
//	private static T a;	//	제네릭은 인스턴스가 선언되어야 타입이 정해지므로 static 사용 불가.
	
	private T[] arr;	//	제네릭 타입으로 참조 변수는 만들 수 있지만 객체는 만들 수 없다.
//	private T[] arr = new K[10];
	
	public void set(T t) {
		this.kind = t;
	}
	
	public T get() {
		return this.kind;
	}
	
	public static <T, K> String method1(T t, K k) {
		return t + "" + k;
	}
	
	public <K> K method2(K k) {
		return k;
	}
}

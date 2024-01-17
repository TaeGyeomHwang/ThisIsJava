package ch13.example;

public class Container3<T, K> {
	private T t;
	private K k;
	
	public T getKey() {
		return t;
	}
	
	public K getValue() {
		return k;
	}
	
	public void set(T t, K k) {
		this.t = t;
		this.k = k;
	}
}

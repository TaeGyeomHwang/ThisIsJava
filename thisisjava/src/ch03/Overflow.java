package ch03;

public class Overflow {

	public static void main(String[] args) {
		byte a = 127;
		byte b = -128;
		System.out.println(++a); //	오버플로우가 일어난다.
		System.out.println(--a); //	언더플로우가 일어난다.
	}

}

package ch06;

public class Korean {
	final static String nation = "대한민국";	//	상수: 고정되어야 하고 공유되어야 하는 값
	final String ssn;	//	final 필드: 고정되어야 하지만 공유는 하지 않아도 되는 값

	String name;

	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
}

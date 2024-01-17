package ch13.example;

public class Util {
	public static <K,V> V getValue(Pair<K,V> p, K k) {	//	<타입 파라미터 정의> 리턴타입 메소드명(매개변수)
		if(p.getKey()==(k)) {
			return p.getValue();
		}else {
			return null;
		}
	}
}

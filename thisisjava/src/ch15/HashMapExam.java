package ch15;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExam {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); // value를 덮어쓴것이다.

		System.out.println("총 엔트리 수: " + map.size());

		String key = "홍길동";
		int value = map.get(key);
		System.out.println(key + ": " + value);

		String key2 = "김지영";	//	어지간하면 get보다 getOrDefault를 사용할 것
		int value2 = map.getOrDefault(key2, 0);	//	키값으로 검색이 안된다며 디폴드값으로 value를 리턴
		System.out.println(key2 + ": " + value2);

//		Set<String> keySet = map.keySet();
//		for(String s: keySet) {
//			System.out.println(s);
//		}
//
//		for(Integer i : map.values()) {	//	보통 이렇게 더 많이 쓴다.
//			System.out.println(i);
//		}
//		
//		for(Entry<String, Integer> e : map.entrySet()) {
//			System.out.println(e.getKey()+" "+e.getValue());
//		}

	}
}

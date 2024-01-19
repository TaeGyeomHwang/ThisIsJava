package ch15.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharFrequeny {

	public static void main(String[] args) {
		String str = "hi, my name is donghee. nice to meet you";
		Map<String, Integer> map = new HashMap<>();
		
		String[] str_arr = str.split("");
		int maxVal = 0;
		String maxString = "";

		for (String s : str_arr) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}

		for (Entry<String, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
			if (e.getValue() > maxVal && e.getKey().equals(" ") == false) {
				maxVal = e.getValue();
				maxString = e.getKey();
			}
		}

		System.out.println("가장 많이 등장한 문자: " + maxString);

	}
}

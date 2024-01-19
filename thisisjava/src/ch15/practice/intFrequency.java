package ch15.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class intFrequency {

	public static void main(String[] args) {
		int[] num = { 1, 1, 4, 7, 3, 5, 5, 4, 3, 1, 6 };
		Map<Integer, Integer> map = new HashMap<>();

		int maxVal = 0;
		Integer maxInt = 0;

		for (Integer s : num) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.getOrDefault(s, 0) + 1);
			}
		}

		for (Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
			if (e.getValue() > maxVal) {
				maxVal = e.getValue();
				maxInt = e.getKey();
			}
		}

		System.out.println("가장 많이 등장한 수: " + maxInt);

	}

}

package ch15;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapExam {

	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<>();

		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 50);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 70);

		for (Entry<String, Integer> e : treeMap.entrySet()) {
			System.out.println(e.getKey() + "-" + e.getValue());
		}
		
		Entry<String, Integer> e = treeMap.firstEntry();
		System.out.println(e.getKey() + "-" + e.getValue());
		
		Entry<String, Integer> e2 = treeMap.higherEntry("h");
		System.out.println(e2.getKey() + "-" + e2.getValue());
	}

}

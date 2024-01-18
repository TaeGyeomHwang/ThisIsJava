package ch15.practice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNum {

	public static void main(String[] args) {
		String[] str = { "apple", "banana" };
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " -> ");
			for (char c : str[i].toCharArray()) {
				if (!set.contains(c)) {
					sb.append(c);
					set.add(c);
				}
			}
			System.out.println(sb.toString());
			set.clear();
			sb.delete(0, sb.length());
		}
	}
}

package ch15.practice;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class NumberSorting {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 4, 7, 3, 5, 5, 4, 3, 1, 6 };
		Set<Integer> set = new TreeSet<>();

		for (Integer i : nums) {
			set.add(i);
		}

		System.out.print("수정된 배열: " + set);

	}

}

package ch17.se8;

import java.util.Arrays;

public class LoopingExam {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };

//		Arrays.stream(arr).filter(i -> i % 2 == 0).forEach(e -> System.out.println(e));
		System.out.println(Arrays.stream(arr)
							.filter(i -> i % 2 == 0)
							.peek(e -> System.out.println(e))
							.allMatch(e->e%2!=0));

		int[] arr2 = { 2, 4, 6, 8, 10 };
		System.out.println(Arrays.stream(arr2).allMatch(e -> e % 2 == 0));
	}

}

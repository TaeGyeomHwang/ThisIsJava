package ch17.se10;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class StreamExam {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };

		long count = Arrays.stream(arr).filter(e -> e % 2 == 0).count();
		System.out.println(count);

		long sum = Arrays.stream(arr).filter(e -> e % 2 == 0).sum();
		System.out.println(sum);

		double average = Arrays.stream(arr).filter(e -> e % 2 == 0).average().getAsDouble();
		System.out.println(average);

		int max = Arrays.stream(arr).filter(e -> e % 2 == 0).max().getAsInt();
		System.out.println(max);

		int min = Arrays.stream(arr).filter(e -> e % 2 == 0).min().getAsInt();
		System.out.println(min);

		OptionalInt first = Arrays.stream(arr).filter(e -> e % 2 == 0).findFirst();
		System.out.println(first);
	}

}

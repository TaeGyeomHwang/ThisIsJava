package ch17.se4;

import java.util.stream.IntStream;

public class StreamExam2 {

	static int sum = 0;

	public static void main(String[] args) {
		IntStream.range(1, 100).forEach(i -> sum += i);
		
		System.out.println(sum);
	}

}

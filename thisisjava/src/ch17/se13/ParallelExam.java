package ch17.se13;

import java.util.*;

public class ParallelExam {

	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> scores = new ArrayList<>();

		for (int i = 0; i < 100000000; i++) {
			scores.add(r.nextInt(101));
		}

		double startTime = 0;
		double endTime = 0;
		double time = 0;

		startTime = System.nanoTime();
		scores.stream().mapToInt(i -> i.intValue()).average().getAsDouble();
		endTime = System.nanoTime();
		time = (endTime - startTime)/1000000000;
		System.out.println(time);
		
		startTime = System.nanoTime();
		scores.parallelStream().mapToInt(i -> i.intValue()).average().getAsDouble();
		endTime = System.nanoTime();
		time = (endTime - startTime)/1000000000;
		System.out.println(time);
	}

}

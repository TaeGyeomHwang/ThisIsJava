package ch17.se3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExam1 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student("홍길동", 10));
		list.add(new Student("신용권", 20));
		list.add(new Student("유미선", 30));

		Stream<Student> originalStream = list.stream();
		IntStream middleStream = originalStream.mapToInt((s) -> s.getScore());
		double avg = middleStream.average().getAsDouble();
		System.out.println(avg);
		
		System.out.println(
				list.stream()
				.mapToInt(s->s.getScore())
				.average()
				.getAsDouble());
	}

}

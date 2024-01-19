package ch17.se10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class StreamExam2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student("홍길동", 92));
		list.add(new Student("신용권", 95));
		list.add(new Student("김자바", 88));

		int sum1 = list.stream().mapToInt(Student::getScore).sum();
		int sum2 = list.stream()
				.mapToInt(Student::getScore)
				.reduce((a, b) -> a + b)	//	reduce의 매개변수가 람다식 하나면 옵셔널 반환
				.orElse(0);	//	orElse로 디폴트 선언
		int sum3 = list.stream().mapToInt(Student::getScore).reduce(0, (a, b) -> a + b);	//	파라미터 2개면 원시타입 반환
	}

}

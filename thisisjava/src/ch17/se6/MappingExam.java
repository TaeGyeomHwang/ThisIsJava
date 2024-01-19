package ch17.se6;

import java.util.ArrayList;
import java.util.List;

public class MappingExam {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 85));
		list.add(new Student("홍길동", 92));
		list.add(new Student("홍길동", 87));

		list.stream().mapToInt(e -> e.getScore()).forEach(e -> System.out.println(e));
		
	}

}

package ch17.se12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExam {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", "남", 92));
		list.add(new Student("김수영", "여", 87));
		list.add(new Student("김자바", "남", 95));
		list.add(new Student("오해영", "여", 93));
		
		List<Student> list1 = list.stream()
										.filter(e->e.getGender().equals("남"))
										.collect(Collectors.toList());
		for(Student s: list1) System.out.println(s);

		Map<Object, Object> map = list.stream()
										.collect(Collectors.toMap(s -> s.getName(),
																  s->s.getScore()));
		
		System.out.println(map);
	}

}

package ch15;

import java.util.TreeSet;

public class PersonExam {

	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<>();

		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("김자바", 25));
		treeSet.add(new Person("박지원", 31));

		for (Person p : treeSet) {
			System.out.println(p.name + ", " + p.age);
		}
	}

}

package ch15;

public class Person implements Comparable<Person> {
	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) { // 오름차순으로 정렬된다.
//		if (age < o.age)
//			return -1;
//		else if (age == o.age)
//			return 0;
//		else
//			return 1;
		return this.age - o.age; // 한줄로 줄일 수 있다.
	}

}

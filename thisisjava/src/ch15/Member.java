package ch15;

public class Member {
	String name;
	int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member target) {
			return target.name.equals(this.name) && (target.age == this.age);
		} else {
			return false;
		}
	}

}

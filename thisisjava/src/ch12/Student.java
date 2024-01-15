package ch12;

public class Student {
	int id;
	String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student s) {
			if (this.id == s.id) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	@Override
	public String toString() {
		return "학번은 " + this.id + ", 이름은 " + this.name + "입니다.";
	}

	@Override
	public int hashCode() {
		return this.id + name.hashCode();
	}
}

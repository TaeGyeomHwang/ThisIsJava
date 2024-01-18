package ch15.example;

//public class Student {
//	public int studentNum;
//	public String name;
//
//	public Student(int studentNum, String name) {
//		super();
//		this.studentNum = studentNum;
//		this.name = name;
//	}
//
//	@Override
//	public int hashCode() {
//		return this.studentNum;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Student s) {
//			return s.studentNum == this.studentNum;
//		}
//		return false;
//	}
//}

public class Student implements Comparable<Student>{
	public String id;
	public int score;

	@Override
	public int compareTo(Student o) {
		return this.score - o.score;
	}

}

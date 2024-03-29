package ch07;

public class StudentExam {

	public static void personInfo(Person person) {
		//	person 인스턴스일 경우
		System.out.println("name: " + person.name);
		person.walk();
		
		//	student 인스턴스일 경우
		if (person instanceof Student student) {
			System.out.println("studentNo: " + student.studentNo);
			student.study();
		}
	}

	public static void main(String[] args) {
		Person p = new Person("홍길동");

		personInfo(p);

		System.out.println();

		Person s = new Student("김길동", 10);
		personInfo(s);

	}

}

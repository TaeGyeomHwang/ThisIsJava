package ch12;

public class StudentExam {

	public static void main(String[] args) {
//		Student s = new Student();
//		s.toString();	//	object 클래스를 기본으로 상속받기 때문에 컴파일 오류 없음

		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(2, "홍길동");
		Student s3 = new Student(1, "김자바");
		
		if(s1.equals(s2)) {
			System.out.println("두 객체는 동등하게 취급됩니다.");
		}else {
			System.out.println("두 객체는 다르게 취급됩니다.");
		}
		if(s1.equals(s3)) {
			System.out.println("두 객체는 동등하게 취급됩니다.");
		}else {
			System.out.println("두 객체는 다르게 취급됩니다.");
		}
		
		System.out.println(s1);	//	toString() 메소드를 거쳐서 출력되는 것이므로 참조 변수를 출력 가능.
		System.out.println(s2);
		System.out.println(s3);
		
		if(s1.hashCode()==s2.hashCode()) {
			System.out.println("두 객체는 동등하게 취급됩니다.");
		}else {
			System.out.println("두 객체는 다르게 취급됩니다.");
		}
		if(s1.hashCode()==s3.hashCode()) {
			System.out.println("두 객체는 동등하게 취급됩니다.");
		}else {
			System.out.println("두 객체는 다르게 취급됩니다.");	//	id는 같아도 리터럴이 다르므로 hashCode 번지값이 달라서 false 출력.
		}
		
		StudentRecord sr = new StudentRecord(1,"홍길동");
		System.out.println(sr.id());
		System.out.println(sr.name());
		System.out.println(sr);
		
		StudentRecord sr2 = new StudentRecord(1,"홍길");
		System.out.println(sr.equals(sr2));
		System.out.println(sr.hashCode()==sr2.hashCode());
	}

}

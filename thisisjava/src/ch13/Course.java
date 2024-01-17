package ch13;

public class Course {
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함");
	}	//	사람이면 다 가능
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course2을 등록함");
	}	//	학생만 가능
	public static void registerCourse3(Applicant<? super Worker> applicant) {	//	Worker를 포함한 부모들만 가능
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함");
	}	//	근로자를 포함한 클래스만 가능
}

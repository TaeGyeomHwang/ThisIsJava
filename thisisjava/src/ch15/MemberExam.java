package ch15;

import java.util.HashSet;
import java.util.Set;

public class MemberExam {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		Member m1 = new Member("홍길동", 30);
		Member m2 = new Member("홍길동", 30);

		set.add(m1); // 인스턴스는 다르지만 리터럴은 같다. 따라서 같은 번지를 참조한다.
		set.add(m2);

		System.out.println(m1.name.hashCode() + " " + m1.age);
		System.out.println(m2.name.hashCode() + " " + m2.age);
		System.out.println(m1.equals(m2));
		
		System.out.println(set.size());
	}

}

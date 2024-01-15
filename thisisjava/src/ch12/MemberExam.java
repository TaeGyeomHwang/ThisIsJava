package ch12;

public class MemberExam {

	public static void main(String[] args) {
		Member m = new Member(); // 롬복은 기본 생성자를 만들어준다.
		System.out.println(m); // 롬복을 라이브러리로 추가하면 해쉬 코드 값이 아닌 요소의 리터럴이 출력된다.
		m.setId("test"); // getter, setter를 생성해준다.
		m.setName("홍길동");
		m.setAge(32);
		System.out.println(m); // toString()도 만들어준다.  

		Member m2 = new Member("test", "홍길동", 32);
		if(m.equals(m2)) System.out.println("동등합니다.");	//	equals()와
		if(m.hashCode()==m2.hashCode())System.out.println("동등합니다.");	//	hashcode()도 생성한다.
	}

}

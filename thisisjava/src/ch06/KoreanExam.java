package ch06;

public class KoreanExam {

	public static void main(String[] args) {
		Korean k1 = new Korean("123456-1234567","김김김");
		
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		k1.name = "박박박";
		System.out.println(k1.name);
	}

}

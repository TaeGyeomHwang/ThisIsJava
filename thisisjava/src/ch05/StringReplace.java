package ch05;

public class StringReplace {

	public static void main(String[] args) {
		String oldStr = "자바 프로그래밍";
		String newStr = oldStr.replace("자바", "Java");
		
		System.out.println(oldStr);
		System.out.println(newStr);

	}

}

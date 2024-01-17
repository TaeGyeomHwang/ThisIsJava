package ch12;

import java.util.regex.Pattern;

public class PatternExam {

	public static void main(String[] args) {
//		Boolean result = Pattern.matches("\\d{2,3}-\\d{3,4}-\\d{4}", "051-1234-5678");
		Boolean result = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", "kim123@goole.com");	//	두번째 .부터는 몇개나 있어도 상관없다.
		System.out.println(result);
	}

}

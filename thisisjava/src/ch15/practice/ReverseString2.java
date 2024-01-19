package ch15.practice;

import java.util.Stack;

public class ReverseString2 {

	public static void main(String[] args) {
		String str = "aabbbcdddde";
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();

		System.out.println("기존 문자열: " + str);
		char c, tmp;

//		for (int i = 0; i < str.length(); i++) {	// .charAt() 메소드로 접근해도 되지만
//			st.push(str.charAt(i));
//		}
		
		for(char ch : str.toCharArray()) {	//	for each문과 str.toCharArray()를 통해 간결하게 작성할 수 있다.
			st.push(ch);
		}

		c = st.pop();
		sb.append(c);

		while (!st.isEmpty()) {
			tmp = st.pop();
			if (c != tmp) {
				sb.append(tmp);
				c = tmp;
			}
		}
		System.out.println("변경된 문자열: " + sb);
	}

}

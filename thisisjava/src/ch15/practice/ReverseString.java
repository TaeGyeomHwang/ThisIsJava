package ch15.practice;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

	public static void main(String[] args) {
		String str = "ABCDE";
		StringBuilder sb = new StringBuilder();
		List<Character> arr = new ArrayList<>();

		System.out.println("기존 문자열: " + str);
		char c, tmp;

		for (char ch : str.toCharArray()) { // for each문과 str.toCharArray()를 통해 간결하게 작성할 수 있다.
			arr.add(ch);
		}
		// 0번 인덱스에 지정해서 넣으면 거꾸로 저장될 것이다.
//		for (char ch : str.toCharArray()) { 
//			arr.add(0, ch);
//		}
		

		for (int i = arr.size() - 1; i > -1; i--) {
			sb.append(arr.get(i));
		}

		System.out.println("변경된 문자열: " + sb);
	}
}

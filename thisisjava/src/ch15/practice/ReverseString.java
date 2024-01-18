package ch15.practice;

public class ReverseString {

	public static void main(String[] args) {
		String str = "ABCDE";
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse().toString());
	}
}

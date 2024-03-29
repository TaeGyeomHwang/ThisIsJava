package ch06.example;

public class Exercise6_22 {

	private static boolean isNumber(String str) {
		return str.chars().allMatch(Character::isDigit);

//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) != '0' && str.charAt(i) != '1' && 
//				str.charAt(i) != '2' && str.charAt(i) != '3'&&
//				str.charAt(i) != '4' && str.charAt(i) != '5' && 
//				str.charAt(i) != '6' && str.charAt(i) != '7'&& 
//				str.charAt(i) != '8' && str.charAt(i) != '9') 
//			{
//				return false;
//			}
//		}
//		return true;
	}

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "123o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

	}

}

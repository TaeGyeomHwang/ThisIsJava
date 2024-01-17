package ch12;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailPhoneNumExam {

	private static String phoneNum;
	private static String eMail;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String eMailVal = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String phoneNumVal = "\\d{2,3}-\\d{3,4}-\\d{4}";

		while(true) {
			System.out.printf("이메일을 입력하세요: ");
			eMail = scan.nextLine();
			
			if(Pattern.matches(eMailVal, eMail)) {
				break;
			}else {
				System.out.printf("잘못 입력하였습니다.");
			}
		}
		while(true) {
			System.out.printf("전화번호를 입력하세요: ");
			phoneNum = scan.nextLine();
			
			if(Pattern.matches(phoneNumVal, phoneNum)) {
				break;
			}else {
				System.out.printf("잘못 입력하였습니다.");
			}
		}
		
		System.out.println("\n이메일: " + eMail + "\n전화번호: " + phoneNum);
	}

}

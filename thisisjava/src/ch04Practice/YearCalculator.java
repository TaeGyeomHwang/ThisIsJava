package ch04Practice;

import java.util.*;

public class YearCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("년도를 입력해주세요. -> ");
		int year = scan.nextInt();
		
		if(year%4==0) {
			if(year%1000!=0 || year%400==0) {
				System.out.println(year+"년은 윤년입니다.");
			}else {
				System.out.println(year+"년은 윤년이 아닙니다.");
			}
		}else {
			System.out.println(year+"년은 윤년이 아닙니다.");
		}
	}

}

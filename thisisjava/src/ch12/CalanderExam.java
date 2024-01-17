package ch12;

import java.util.Calendar;

public class CalanderExam {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 싱글톤 패턴이라 인스턴스를 새로 못 만들고 이미 만들어진 정적 멤버 인스턴스를 가지고 와서 써야함.
//		System.out.println(cal.get(Calendar.YEAR));
//		System.out.println(cal.get(Calendar.MONTH) + 1);
//		System.out.println(cal.get(Calendar.DATE));
//		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));	//	일월화수목금토
//		System.out.println(Calendar.MONDAY);
//		System.out.println(cal.get(Calendar.AM_PM));
//		System.out.println(cal.get(Calendar.HOUR));
		
		System.out.println(cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DATE) + "일");
		if(cal.get(Calendar.DAY_OF_WEEK) == 4 && cal.get(Calendar.HOUR_OF_DAY)<13) {
			System.out.println("수요일 오전");
		}
		System.out.println(cal.get(Calendar.HOUR) + "시 " + cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초");

	}

}

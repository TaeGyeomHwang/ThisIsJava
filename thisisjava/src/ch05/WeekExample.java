package ch05;

import java.util.Calendar;

public class WeekExample {

	public static void main(String[] args) {
		Week today = null;
		
		Calendar cal = Calendar.getInstance();	//	런타임 중 Calendar 라는 객체는 반드시 하나만 존재해야 하므로 new를 써서 생성하지 않음
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
			case 1: today = Week.SUNDAY;	break;
			case 2: today = Week.MONDAY;	break;
			case 3: today = Week.TUESDAY;	break;
			case 4: today = Week.WEDNESDAY;	break;
			case 5: today = Week.THURSDAY;	break;
			case 6: today = Week.FRIDAY;	break;
			case 7: today = Week.SATURDAY;	break;
		}
		
		if(today == Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다.");
		}else {
			System.out.println("열심히 자바를 공부합니다.");
		}
	}

}

package ch12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {

	public static void main(String[] args) {
		Date date = new Date();	//	date 클래스가 있지만 LocalDateTime을 더 많이 쓴다.
		System.out.println(date);

		SimpleDateFormat sm = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String str = sm.format(date);
		System.out.println(str);
	}

}

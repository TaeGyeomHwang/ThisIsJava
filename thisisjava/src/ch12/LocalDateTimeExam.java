package ch12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExam {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime ldt2 = LocalDateTime.now();

		// 포맷터 생성
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		String date = ldt.format(dtf);
		System.out.println(date);

		LocalDateTime mY = ldt.minusYears(1);
		System.out.println(mY.format(dtf));

		LocalDateTime mM = ldt.minusMonths(1);
		System.out.println(mM.format(dtf));

		if (mY.isAfter(mM)) {
			System.out.println("mM의 날짜가 더 이후입니다.");
		} else {
			System.out.println("mM의 날짜가 같거나 더 이전입니다.");
		}

		if (ldt.isEqual(ldt2)) {
			System.out.println("두 날짜가 서로 같습니다.");
		} else {
			System.out.println("두 날짜가 다릅니다.");
		}

		LocalDateTime nextYear = LocalDateTime.of(2025, 1, 1, 0, 0, 0);
		long dDay = ldt.until(nextYear, ChronoUnit.DAYS);
		System.out.println("올해가 끝나기까지 남은 일 수: " + dDay);
	}

}

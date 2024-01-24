package ch18.practice;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateDateFile {

	public static void main(String[] args) throws Exception {
		LocalDate date;
		LocalTime time = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = time.format(timeFormatter);
		Path path1;
		Path path2;

		for (int i = 0; i < 10; i++) {
			date = LocalDate.now().plusDays(i);
			path1 = Paths.get("C:/Temp/" + date.getYear() + "/" + date.getMonthValue() + "/" + date.getDayOfMonth());
			path2 = Paths.get(path1 + "/now.txt");
			String data = "현재 시각: " + date + " " + formattedTime;
			
			Files.createDirectories(path1);
			System.out.println(path1 + " 디렉터리를 생성하였습니다.");
			Files.writeString(path2, data, Charset.forName("UTF-8"));
			System.out.println(path2 + "파일을 생성하였습니다.");
		}
	}

}
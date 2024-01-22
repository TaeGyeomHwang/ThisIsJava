package ch18;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExam {

	public static void main(String[] args) throws Exception {
		String data = """
				id: winter
				email: winter@mycompany.com
				tel: 010-1234-5678
				""";
		
		Path path = Paths.get("C:/Temp2/user.txt");
		Files.writeString(path, data, Charset.forName("UTF-8"));
		
		System.out.println(Files.probeContentType(path));
		System.out.println(Files.size(path));
		System.out.println(Files.readString(path, Charset.forName("UTF-8")));
	}

}

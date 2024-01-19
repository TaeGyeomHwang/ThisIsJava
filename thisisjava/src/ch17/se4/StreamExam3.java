package ch17.se4;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamExam3 {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(StreamExam3.class.getResource("data.txt").toURI());
		Files.lines(path, Charset.defaultCharset()).forEach(line -> System.out.println(line));
	}

}

package ch17.se4;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExam3 {

	public static void main(String[] args) throws Exception {
		URI uri = StreamExam3.class.getResource("data.txt").toURI();
		Path path = Paths.get(uri);
		Files.lines(path, Charset.defaultCharset()).forEach(line -> System.out.println(line));
	}

}
